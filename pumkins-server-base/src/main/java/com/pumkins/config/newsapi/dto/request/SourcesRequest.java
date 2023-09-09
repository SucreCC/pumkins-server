package com.pumkins.config.newsapi.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: SourcesRequest
 */

@Data
@Accessors(chain = true)
public class SourcesRequest implements Requester {
    private String apiKey;
    private String category;
    private String language;
    private String country;
}
