package com.pumkins.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: dengKai
 * @date: 2022/02/14 14:14
 * @description:
 */
@Data
@Accessors(chain = true)
public class WordManageReq {
    private MultipartFile xlsxFile;
    private Integer theDay;
}
