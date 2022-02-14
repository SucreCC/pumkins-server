package com.pumkins.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: dengKai
 * @date: 2022/02/14 11:10
 * @description:
 */
@Data
@Accessors(chain = true)
public class WordReq {

    private Integer id;
    private String wordName;
    private String wordContent;
    private String createDate;
    private Integer theDay;
}
