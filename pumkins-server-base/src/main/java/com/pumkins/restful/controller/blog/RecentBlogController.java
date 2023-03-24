package com.pumkins.restful.controller.blog;

import com.pumkins.dto.resp.BlogResp;
import com.pumkins.dto.response.JsonResp;
import com.pumkins.restful.service.blog.RecentBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/03/24 11:14
 * @description: TODO
 */
@RestController
@RequestMapping("/pumkins/recent-blog")
public class RecentBlogController {

    @Autowired
    private RecentBlogService recentBlogService;

    @GetMapping("/get-tag-list")
    public JsonResp<List<String>> getBlogCategory() {
        return JsonResp.success(recentBlogService.getBlogTags());
    }
}
