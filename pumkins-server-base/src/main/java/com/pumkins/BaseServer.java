package com.pumkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: dengKai
 * @date: 2021/12/03 11:36
 * @description: 启动类
 */
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class BaseServer {
    public static void main(String[] args) {
        SpringApplication.run(BaseServer.class);
    }
}
