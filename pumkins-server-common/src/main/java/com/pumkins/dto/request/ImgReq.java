package com.pumkins.dto.request;

import com.pumkins.entity.Img;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: dengKai
 * @date: 2023/01/14 22:23
 * @description: TODO
 */
@Data
@Accessors(chain = true)
public class ImgReq {
    private Long id;
    private String md5;
    private Long size;
    private String suffix;
    private String imgName;
    private Date createDate;
    private Date updateDate;

    public Img convertToImg(){
        return new Img()
            .setImgName(this.getImgName())
            .setSize(this.getSize())
            .setSuffix(this.getSuffix())
            .setMd5(this.getMd5())
            .setCreateDate(this.getCreateDate())
            .setUpdateDate(this.getUpdateDate());
    }
}
