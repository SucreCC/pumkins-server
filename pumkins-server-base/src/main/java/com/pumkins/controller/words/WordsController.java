package com.pumkins.controller.words;

import com.pumkins.dto.request.WordManageReq;
import com.pumkins.resp.JsonResp;
import com.pumkins.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: dengKai
 * @date: 2022/02/13 15:54
 * @description:
 */
@RestController
@RequestMapping("pumkins/words")
public class WordsController {
    @Autowired
    private WordsService wordsService;


    @PostMapping("/add")
    public JsonResp addWords(@RequestParam("xlsxFile") MultipartFile multipartFile) throws IOException {
        wordsService.addTodayWords(multipartFile);
        return JsonResp.success("success");
    }
}
