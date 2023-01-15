package com.pumkins.restful.controller.blog;

import com.pumkins.dto.request.BlogReq;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.blog.BlogService;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author: dengKai
 * @date: 2022/02/05 20:58
 * @description: blog页面相关请求
 */
@RestController
@RequestMapping("pumkins/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/save")
    public JsonResp<BlogReq> saveBlog(@RequestBody BlogReq blogReq){
        return JsonResp.success(blogReq);
    }

    @PostMapping("/blog-picture")
    public JsonResp<String> update(@RequestParam("file") MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidBucketNameException {
        return JsonResp.success(blogService.uploadImg(file));
    }
}
