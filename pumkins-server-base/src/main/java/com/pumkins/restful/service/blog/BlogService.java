package com.pumkins.restful.service.blog;


import com.pumkins.dto.request.BlogReq;
import com.pumkins.dto.resp.BlogResp;
import com.pumkins.dto.resp.ImgResp;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/01/14 07:43
 * @description: TODO
 */

public interface BlogService {
    ImgResp uploadImg(MultipartFile file) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;

    Integer saveBlog(BlogReq blogReq);

    Integer saveEditBlog(BlogReq blogReq);

    BlogResp getBlogById(Integer blogId);

    List<BlogResp> getArticleBlog();

    void blogView(Integer id);

    String saveMarkdownImages(MultipartFile file) throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
