package com.pumkins.restful.service.tags;

import java.util.List;

/**
 * @Author: dengKai
 * @Date: 2023-01-20-20-34
 * @Description: TODO
 */

public interface BlogTagService {
    List<Integer> getTagByBlogId(Integer blogId);
}
