package com.pumkins.restful.service.blogComment;

import com.pumkins.dto.request.BlogCommentReq;
import com.pumkins.dto.resp.BlogCommentResp;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/01/22 16:16
 * @description: TODO
 */

public interface BlogCommentService {
    void save(BlogCommentReq blogCommentReq);

    List<BlogCommentResp> getBlogCommentByBlogId(Integer blogId);
}
