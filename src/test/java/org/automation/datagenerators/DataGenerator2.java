package org.automation.datagenerators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.utility.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataGenerator2 {
    public static void main(String[] args) throws Exception {
        //generateMainData();
        try {
            DataGenerator2 d2 = new DataGenerator2(Utility.fetchExcelValue("Excel3"));
            System.out.println("Number Of Rows: "+d2.getRowValue("Sheet1"));
            System.out.println("Number of Cells on Each Row: "+d2.getCellValues("Sheet1"));
            d2.generateCellData("Sheet1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public FileInputStream fis;
    public XSSFWorkbook wb;
    public XSSFSheet sheet;
    String path = null;
    DataGenerator2(String path){
        this.path=path;
    }

    public int getRowValue(String sheetName) throws IOException {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);

        // Check if the sheet is null or has no rows
        if (sheet == null || sheet.getPhysicalNumberOfRows() == 0) {
            System.out.println("The sheet is empty.");
            return -1; // Returning -1 to indicate the sheet is empty
        }
        //int numOfRows = sheet.getLastRowNum();//Index of Rows
        int numOfRows = sheet.getPhysicalNumberOfRows();//Length of Rows

        return numOfRows;
    }
    public int getCellValues(String sheetName){
        try {
            fis = new FileInputStream(path);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetName);
            int numOfRows = sheet.getPhysicalNumberOfRows();
            Row row = sheet.getRow(numOfRows - 1);
            int numOfCell = 0;
            if (row != null) {
                numOfCell = row.getPhysicalNumberOfCells();
            }
            return numOfCell;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public void generateCellData(String sheetName) throws Exception {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);

        int numOfRows = sheet.getPhysicalNumberOfRows();//Length of Rows
        Row row = sheet.getRow(numOfRows - 1);
        int numOfCell = 0;
        if (row != null) {
            numOfCell = row.getPhysicalNumberOfCells();
        }

        for (int i = 0; i < numOfRows; i++) {
            String p1 = null;
            for (int j = 0; j < numOfCell; j++) {
                Cell cell = sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); // Get cell and handle null
                if (cell != null) {
                    // Get the type of the cell and switch accordingly
                    switch (cell.getCellType()) {
                        case STRING:
                            p1 = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            p1 = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            p1 = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case BLANK:
                            p1 = "No Data";
                            break;
                        default:
                            p1 = "Unknown Type"; // For other unsupported cell types
                            break;
                    }
                }
                System.out.print(p1 + " ");  // Print the value of the cell (p1)
            }
            System.out.println(); // New line after each row
        }
    }

}
