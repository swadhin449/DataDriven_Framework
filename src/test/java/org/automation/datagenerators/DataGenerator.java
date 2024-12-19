package org.automation.datagenerators;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class DataGenerator {

    @DataProvider(name = "dp")
    public Object[][] testDataGenerator() {
        Object[][] data = {{"student", "Password123"}};
        return data;
    }

    @DataProvider(name = "Excel")
    public Object[][] testData(Method met) throws IOException {
        if (met.getName().equalsIgnoreCase("validateLogin")) {
            FileInputStream fis = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\target\\FileExcelData\\Excel 1.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet loginSheet = wb.getSheet("Sheet1");
            int numOfRows = loginSheet.getPhysicalNumberOfRows();
            Object[][] data = new Object[numOfRows][2];
            for (int i = 0; i < numOfRows; i++) {
                XSSFRow row = loginSheet.getRow(i);
                XSSFCell un = row.getCell(0);
                XSSFCell pw = row.getCell(1);
                data[i][0] = un.getStringCellValue();
                data[i][1] = pw.getStringCellValue();
            }
            return data;
        }else{
            Object[][] data = new Object[2][2];
            return data;
        }

    }

}
