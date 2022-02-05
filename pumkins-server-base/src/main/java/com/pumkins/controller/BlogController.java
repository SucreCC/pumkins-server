package com.pumkins.controller;

import com.pumkins.dto.request.BlogReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dengKai
 * @date: 2022/02/05 20:58
 * @description: blog页面相关请求
 */
@RestController
@RequestMapping("pumkins/blog")
public class BlogController {
    @PostMapping("/save")
    public void saveBlog(BlogReq blogReq){
        System.out.println("1111");
    }
}
