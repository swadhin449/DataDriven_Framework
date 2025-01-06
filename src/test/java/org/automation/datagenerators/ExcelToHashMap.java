package org.automation.datagenerators;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelToHashMap {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\target\\FileExcelData\\StudentData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Student Data");

        int rowCount = sheet.getLastRowNum();
        HashMap<String,String> data = new HashMap<>();

        //Reading the Data from Excel to HashMap
        for(int i=0;i<=rowCount;i++){
            String key = sheet.getRow(i).getCell(0).getStringCellValue();
            String value = sheet.getRow(i).getCell(1).getStringCellValue();
            data.put(key,value);
        }

        //Read data from HashMap
        for(Map.Entry entry: data.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        FileInputStream file = new FileInputStream("path");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet(sheetName);

        XSSFRow row = sheet.getRow(rownum);
        XSSFCell cell = row.createCell(colnum);
        cell.setCellValue(data);

        FileOutputStream fos = new FileOutputStream("path");
        wb.write(fos);
        wb.close();
        file.close();
        fos.close();
    }
}
