package com.thetestingacademy.ex_08_DataDrivenTesting_POI;

import com.thetestingacademy.ex_02_seleniumBasics.CommonToAll;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SeleniumBasics_31_utils extends CommonToAll {

    static Workbook workbook;
    static Sheet sheet;


    public static String Sheet_path = System.getProperty("user.dir") + "/src/test/Resources/SampleExcel.xlsx";


    public static Object[][] getSheetFromExcel(String sheetName) {

        //find Excel
        try {
            FileInputStream fileInputStream = new FileInputStream(Sheet_path);
            workbook = WorkbookFactory.create(fileInputStream);
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                System.out.println(workbook.getSheetName(i));
            }
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet with name " + sheetName + " not found!");
            }

        } catch (IOException e) {
            System.out.println("File not found or not created");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }


        }
        return data;
    }
}
