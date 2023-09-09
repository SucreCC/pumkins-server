package com.pumkins.config.newsapi.dto.response;

import com.pumkins.config.newsapi.dto.Source;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: SourcesResponse
 */

@Data
@Accessors(chain = true)
public class SourcesResponse {
    private String status;
    private List<Source> sources;
}
