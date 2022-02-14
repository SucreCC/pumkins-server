package com.pumkins.service.impl;

import com.pumkins.entity.QWord;
import com.pumkins.entity.Word;
import com.pumkins.repository.WordRepository;
import com.pumkins.service.WordsService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author: dengKai
 * @date: 2022/02/13 17:56
 * @description:
 */
@Service
public class WordsServiceImpl implements WordsService {
    private final List<Word> wordList = new ArrayList<>();
    private final Integer theFirstColumn = 1;
    private final Integer theSecondColumn = 2;
    private final Integer theFirstSheet = 0;
    private final int zeroRow = 0;
    private final QWord qWord = QWord.word;

    @Autowired
    private WordRepository wordRepository;


    /**
     * @param multipartFile poi 与 poi-ooxml 的版本一致 此处统一为4.1.2
     *                      excel页数从0开始，行数从0开始，列数从1开始。
     * @param theDay
     */

    @Override
    public void addTodayWords(MultipartFile multipartFile, Integer theDay){
        try {
            getWordList(multipartFile, theDay);
            if (ObjectUtils.isEmpty(wordList)) {
                throw new Exception("wordlist is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        wordRepository.saveAll(wordList);
    }

    private void getWordList(MultipartFile multipartFile, Integer theDay) throws Exception {


        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(multipartFile.getInputStream());
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(theFirstSheet);
        int totalRows = xssfSheet.getPhysicalNumberOfRows();

        if (totalRows == zeroRow) {
            throw new Exception("you upload a empty excel");
        }

        for (int i = 0; i < totalRows; i++) {
            XSSFRow row = xssfSheet.getRow(i);
            Word word = new Word()
                .setCreateDate(new Date().toString())
                .setTheDay(theDay)
                .setWordName(row.getCell(theFirstColumn).getStringCellValue())
                .setWordContent(row.getCell(theSecondColumn).getStringCellValue());
            wordList.add(word);
        }

    }
}
