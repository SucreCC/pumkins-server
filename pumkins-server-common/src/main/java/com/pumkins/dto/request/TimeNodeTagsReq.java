package com.pumkins.dto.request;

import com.pumkins.entity.TimeNodeTags;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/03/17 15:45
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class TimeNodeTagsReq {
    private Integer id;
    private String tagName;
    private Date createDate;
    private Date updateDate;

    public TimeNodeTags convertToTimeNodeTags(){
        TimeNodeTags timeNodeTags = new TimeNodeTags();
        BeanUtils.copyProperties(this,timeNodeTags);
        return timeNodeTags;
    }

}
