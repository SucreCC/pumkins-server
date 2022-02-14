package com.pumkins.service;

import org.springframework.web.multipart.MultipartFile;


/**
 * @author: dengKai
 * @date: 2022/02/13 17:53
 * @description:
 */

public interface WordsService {

    void addTodayWords(MultipartFile multipartFile, Integer theDay);
}
