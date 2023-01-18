package com.pumkins.dto.resp;

import com.pumkins.entity.Img;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import java.util.Date;
import java.util.Objects;

/**
 * @author: dengKai
 * @date: 2023/01/14 22:00
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class ImgResp {

    private Integer id;
    private String md5;
    private Long size;
    private String suffix;
    private String imgName;
    private Date createDate;
    private Date updateDate;

    public static ImgResp build(Img img) {
        ImgResp imgResp = new ImgResp();
        if (Objects.nonNull(img)) {
            BeanUtils.copyProperties(img,imgResp);
        }
        return imgResp;
    }
}
