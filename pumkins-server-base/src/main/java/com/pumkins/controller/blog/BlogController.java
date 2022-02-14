package com.pumkins.controller.blog;

import com.pumkins.dto.request.BlogReq;
import com.pumkins.resp.JsonResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public JsonResp<BlogReq> saveBlog(@RequestBody BlogReq blogReq){
        return JsonResp.success(blogReq);
    }
}
