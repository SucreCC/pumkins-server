package com.pumkins.restful.service.img;

import com.pumkins.dto.request.ImgReq;
import com.pumkins.dto.resp.ImgResp;

import java.util.List;


/**
 * @Author: dengKai
 * @Date: 2023-01-14-22-13
 * @Description: TODO
 */

public interface ImgService {
    ImgResp checkDuplicateImg(String md5, long size, String suffix);

    ImgResp save(ImgReq imgReq);

    List<Integer> defaultImg();
}
