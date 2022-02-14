package com.pumkins.service.impl;

import com.pumkins.service.WordsService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author: dengKai
 * @date: 2022/02/13 17:56
 * @description:
 */
@Service
public class WordsServiceImpl implements WordsService {

    /**
     *
     * @param multipartFile
     * poi 与 poi-ooxml 的版本一致 此处统一为4.1.2
     * excel页数从0开始，行数从0开始，列数从1开始。
     */

    @Override
    public void addTodayWords(MultipartFile multipartFile) {

        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(multipartFile.getInputStream());
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
            int totalRows = xssfSheet.getPhysicalNumberOfRows();

            for (int i = 0; i < totalRows; i++) {
                XSSFRow row = xssfSheet.getRow(i);
                int columns = row.getPhysicalNumberOfCells();
                for (int col = 1; col < columns; col++) {
                    XSSFCell cell = row.getCell(col);
                    System.out.println(cell);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
