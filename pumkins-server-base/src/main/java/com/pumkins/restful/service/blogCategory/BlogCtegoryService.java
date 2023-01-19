package com.pumkins.restful.service.blogCategory;

import com.pumkins.dto.request.BlogCategoryReq;
import com.pumkins.dto.resp.BlogCategoryResp;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/01/19 07:21
 * @description: TODO
 */

public interface BlogCtegoryService {
    BlogCategoryResp saveCategory(BlogCategoryReq blogCategoryReq);

    List<BlogCategoryResp> getCategory();
}

