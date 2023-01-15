package com.pumkins.config.fileUpload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author: dengKai
 * @date: 2023/01/13 21:21
 * @description: TODO
 */

@Configuration
public class UploadConfig {

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

}
