package com.pumkins.restful.service.blog.impl;

import com.pumkins.dto.request.BlogReq;
import com.pumkins.dto.request.ImgReq;
import com.pumkins.dto.resp.BlogResp;
import com.pumkins.dto.resp.ImgResp;
import com.pumkins.entity.Blog;
import com.pumkins.entity.QBlog;
import com.pumkins.entity.QBlogCategory;
import com.pumkins.repository.BlogRepository;
import com.pumkins.restful.service.blog.BlogService;
import com.pumkins.restful.service.img.BlogImageService;
import com.pumkins.restful.service.img.ImgService;
import com.pumkins.restful.service.tags.TagsService;
import com.pumkins.util.MinionUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: dengKai
 * @date: 2023/01/14 07:45
 * @description: TODO
 */
@Component
public class BlogServiceImpl implements BlogService {

    private final static QBlog Q_BLOG = QBlog.blog;

    @Autowired
    private ImgService imgService;

    @Autowired
    private BlogImageService blogImageService;

    @Autowired
    private MinionUtils minionUtils;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private TagsService tagsService;

    @Override
    public ImgResp uploadImg(MultipartFile file) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String md5 = DigestUtils.md5Hex(file.getInputStream());
        long size = file.getSize();
        String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
        ImgResp imgResp = imgService.checkDuplicateImg(md5, size, suffix);

        if (Objects.nonNull(imgResp.getImgName())) {
            return imgResp;
        }

        String newImgName = minionUtils.upload(file);

        ImgReq imgReq = new ImgReq()
            .setMd5(md5)
            .setSize(size)
            .setSuffix(suffix)
            .setImgName(newImgName)
            .setCreateDate(new Date())
            .setUpdateDate(new Date());

        return imgService.save(imgReq);
    }

    @Override
    public Integer saveBlog(BlogReq blogReq) {
        Date date = new Date();
        blogReq.setCreateDate(date)
            .setUpdateDate(date);
        Blog blog = blogRepository.save(blogReq.convertToBlog());
        Integer blogId = blog.getId();

        List<Integer> tagIds = tagsService.saveTags(blogReq.getTags());
        tagsService.saveBatch(tagIds, blogId);

        List<Integer> images = blogReq.getImages();
        if (Objects.isNull(images)) {
            images = imgService.defaultImg();
        }
        blogImageService.saveBatch(images, blogId);
        return blogId;
    }


    @Override
    public BlogResp getBlogById(Integer blogId) {
        Blog blog = jpaQueryFactory.selectFrom(Q_BLOG)
            .where(Q_BLOG.id.eq(blogId))
            .fetchOne();

        List<String> tags = tagsService.getTagByBlogId(blogId);
        List<String> images = imgService.getImgByBlogId(blogId);
        return BlogResp.build(blog, tags, images);
    }
}
