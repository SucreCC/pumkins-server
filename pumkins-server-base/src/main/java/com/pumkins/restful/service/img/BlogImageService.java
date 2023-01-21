package com.pumkins.restful.service.img;

import java.util.List;

/**
 * @Author: dengKai
 * @Date: 2023-01-20-14-38
 * @Description: TODO
 */

public interface BlogImageService {
    void saveBatch(List<Integer> images, Integer blogId);

    List<Integer> getImgByBlogId(Integer id);

    void saveEditBlogImages(List<Integer> images, Integer blogId);
}
