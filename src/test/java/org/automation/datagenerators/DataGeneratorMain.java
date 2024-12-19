package org.automation.datagenerators;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class DataGeneratorMain {
    public static void main(String[] args) throws Exception {
        generateMainData();
    }
    public static void generateMainData() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\SwadhinKumarJena\\IdeaProjects\\DataDriven_Framework\\target\\MainExcelFile\\MainExcel.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        int numOfRows = sheet.getPhysicalNumberOfRows();
        Row row = sheet.getRow(numOfRows - 1);
        int numOfCell = 0;
        if (row != null) {
            numOfCell = row.getPhysicalNumberOfCells();
        }
        for (int i = 0; i < numOfRows; i++) {
            String p1 = null;
            for (int j = 0; j < numOfCell; j++) {
                p1 = sheet.getRow(i).getCell(j).getStringCellValue();
            }

            FileInputStream fi = new FileInputStream(p1);
            XSSFWorkbook work = new XSSFWorkbook(fi);
            XSSFSheet sh= work.getSheet("Sheet1");

            int r = sh.getPhysicalNumberOfRows();
            Row rr = sh.getRow(numOfRows - 1);
            int c = 0;
            if (rr != null) {
                c = rr.getPhysicalNumberOfCells();
            }
            for(int k=0;k<r;k++){
                String p2 = null;
                for(int l=0;l<c;l++){
                    p2 = sh.getRow(k).getCell(l).getStringCellValue();
                    System.out.print(p2+" ");
                    if(l<c-1) {
                        System.out.print(": ");
                    }
                }
                System.out.println();
            }
        }

    }
}
