package com.pumkins.util;


import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: dengKai
 * @date: 2023/01/14 07:46
 * @description: TODO
 */

@Configuration
public class MinionUtils {

    private final static String IMG_BUCKET_NAME = "images";

    @Value("${minio.host}")
    private String host;

    @Value("${minio.username}")
    private String username;

    @Value("${minio.password}")
    private String password;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;


    public String upload(MultipartFile file) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {


        String newImgName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS"))
            + RandomStringUtils.random(4, true, true)
            + "."
            + FilenameUtils.getExtension(file.getOriginalFilename());

        MinioClient minioClient = buildMinioClient();
        PutObjectArgs bucket = PutObjectArgs.builder()
            .contentType(file.getContentType())
            .stream(file.getInputStream(), file.getSize(), 0)
            .bucket(IMG_BUCKET_NAME)
            .object(newImgName)
            .build();
        minioClient.putObject(bucket);
        return newImgName;
    }

    private MinioClient buildMinioClient() {
        return MinioClient.builder().endpoint(this.host)
//            .credentials(username, password)
            .credentials(accessKey, secretKey)
            .build();
    }


}
