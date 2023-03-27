package com.pumkins.restful.service.blog;


import com.pumkins.dto.request.BlogSearchReq;
import com.pumkins.dto.resp.BlogResp;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/01/14 07:43
 * @description: TODO
 */

public interface RecentBlogService {

    List<String> getBlogTags();

    List<BlogResp> getRecentBlogList(BlogSearchReq blogSearchReq);
}
