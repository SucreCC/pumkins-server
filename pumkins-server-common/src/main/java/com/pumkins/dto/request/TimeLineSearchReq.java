package com.pumkins.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author: dengKai
 * @date: 2022/11/03 20:43
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class TimeLineSearchReq {
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;
    private List<String> tags;
}
