package com.pumkins.restful.service.tags;

import java.util.List;

/**
 * @Author: dengKai
 * @Date: 2023-01-17-10-07
 * @Description: TODO
 */

public interface TagsService {
    void checkDuplicateTag(List<String> tags);

    List<Integer> saveTags(List<String> tags);
}

