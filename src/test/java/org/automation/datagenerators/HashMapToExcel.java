package org.automation.datagenerators;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapToExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Student Data");

        Map<String, String> data = new HashMap<String, String>();
        data.put("101", "John");
        data.put("102", "Doe");
        data.put("103", "Jane");
        data.put("104", "Doge");
        data.put("105", "Dane");

        int rownum = 0;
        for (Map.Entry entry : data.entrySet()) {
            XSSFRow row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue((String) entry.getKey());
            row.createCell(1).setCellValue((String) entry.getValue());
        }
        FileOutputStream fos = new FileOutputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\target\\FileExcelData\\StudentData.xlsx");
        wb.write(fos);
        fos.close();
        System.out.println("Excel file created successfully");
    }
}