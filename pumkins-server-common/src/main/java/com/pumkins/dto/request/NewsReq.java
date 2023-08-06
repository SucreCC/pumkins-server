package com.pumkins.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2023/08/06 20:35
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class NewsReq {
    private String title;
    private String url;
}
