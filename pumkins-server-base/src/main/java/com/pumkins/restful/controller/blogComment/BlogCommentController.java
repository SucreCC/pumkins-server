package com.pumkins.restful.controller.blogComment;

import com.pumkins.dto.request.BlogCommentReq;
import com.pumkins.dto.resp.BlogCommentResp;
import com.pumkins.dto.resp.BlogResp;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.blogComment.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: dengKai
 * @date: 2023/01/22 17:46
 * @description: TODO
 */
@RestController
@RequestMapping("pumkins/comment")
public class BlogCommentController {

    @Autowired
    private BlogCommentService blogCommentService;

    @PostMapping("/save-blog-comment")
    public JsonResp<BlogCommentResp> login(@RequestBody BlogCommentReq blogCommentReq) {
        blogCommentService.save(blogCommentReq);
        return JsonResp.success(null);
    }

    @GetMapping("/get-blog-comment")
    public JsonResp<List<BlogCommentResp>> getBlogById(@RequestParam() Integer blogId) {
        return JsonResp.success(blogCommentService.getBlogCommentByBlogId(blogId));
    }
}
