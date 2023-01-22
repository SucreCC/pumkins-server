package com.pumkins.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/01/22 10:58
 * @description: TODO
 */
@Data
@Accessors
public class BlogCommentReq {
    private Integer id;
    private Integer blogId;
    private Integer parentId;
    private Integer childrenId;
    private Integer blogComment;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;
}
