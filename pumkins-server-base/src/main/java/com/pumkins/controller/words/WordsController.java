package com.pumkins.controller.words;

import com.pumkins.resp.JsonResp;
import com.pumkins.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


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
    public JsonResp addWords(@RequestParam("xlsxFile") MultipartFile multipartFile, @RequestParam("theDay") Integer theDay){
        wordsService.addTodayWords(multipartFile,theDay);
        return JsonResp.success("success");
    }
}
