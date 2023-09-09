package com.pumkins.config.newsapi.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author: dengKai
 * @date: 2023/08/05 08:47
 * @description: EverythingRequest
 */
@Data
@Accessors(chain = true)
public class EverythingRequest implements Requester {
    private String apiKey;
    private String q;
    private String searchIn;
    private String sources;
    private String domains;
    private String excludeDomains;
    /**
     *     A date and optional time for the newest article allowed. This should be in ISO 8601 format (e.g. 2023-08-06 or 2023-08-06T01:44:53)
     */
    private String from;
    private String to;
    private String language;
    private String sortBy;
    private String pageSize;
    private String page;
}
