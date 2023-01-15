package com.pumkins.restful.service.blog.impl;

import com.pumkins.dto.request.ImgReq;
import com.pumkins.dto.resp.ImgResp;
import com.pumkins.restful.service.blog.BlogService;
import com.pumkins.restful.service.img.ImgService;
import com.pumkins.util.MinionUtils;
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
import java.util.Objects;

/**
 * @author: dengKai
 * @date: 2023/01/14 07:45
 * @description: TODO
 */
@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    private ImgService imgService;

    @Autowired
    private MinionUtils minionUtils;

    @Override
    public String uploadImg(MultipartFile file) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String md5 = DigestUtils.md5Hex(file.getInputStream());
        long size = file.getSize();
        String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
        ImgResp imgResp = imgService.checkDuplicateImg(md5, size, suffix);

        if (Objects.nonNull(imgResp.getImgName())){
            return imgResp.getImgName();
        }

        String newImgName = minionUtils.upload(file);

        ImgReq imgReq = new ImgReq()
            .setMd5(md5)
            .setSize(size)
            .setSuffix(suffix)
            .setImgName(newImgName)
            .setCreateDate(new Date())
            .setUpdateDate(new Date());
        imgService.save(imgReq);

        return imgReq.getImgName();
    }
}