package org.automation.datagenerators;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.utility.Utility;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class DataGenerator3 {
    @DataProvider(name = "Excel4")
    public Object[][] testUserPass(Method met) throws IOException {
        if (met.getName().equalsIgnoreCase("validateLogin")) {
            FileInputStream fis = new FileInputStream(Utility.fetchExcelValue("Excel4"));
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet loginSheet = wb.getSheet("Sheet1");
            int numOfRows = loginSheet.getPhysicalNumberOfRows();
            System.out.println("Number of rows: " + numOfRows);
            Object[][] data = new Object[numOfRows-1][2];
            for (int i = 1; i < numOfRows; i++) {
                XSSFRow row = loginSheet.getRow(i);
                XSSFCell un = row.getCell(0);
                XSSFCell pw = row.getCell(1);
                data[i-1][0] = un.getStringCellValue();
                data[i-1][1] = pw.getStringCellValue();
            }
            return data;
        }
        Object[][] data = new Object[1][2];
        return data;
    }

    @DataProvider(name = "Excel")
    public Object[][] testUserPassWord(Method met) throws IOException {
        try (FileInputStream fis = new FileInputStream(Utility.fetchExcelValue("Excel4"));
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {

            if (met.getName().equalsIgnoreCase("validateLogin")) {
                XSSFSheet loginSheet = wb.getSheet("Sheet1");
                if (loginSheet == null) {
                    System.out.println("Sheet 'Sheet1' not found in the workbook.");
                    return new Object[0][0]; // Return an empty array if the sheet is missing
                }

                int numOfRows = loginSheet.getPhysicalNumberOfRows();
                System.out.println("Number of rows: " + numOfRows);

                if (numOfRows <= 1) {
                    System.out.println("No data rows found in the sheet.");
                    return new Object[0][0]; // Return an empty array if there are no data rows
                }

                Object[][] data = new Object[numOfRows - 1][2]; // Adjust size to exclude header
                for (int i = 1; i < numOfRows; i++) { // Start from row 1 to skip header
                    XSSFRow row = loginSheet.getRow(i);
                    if (row != null) {
                        XSSFCell un = row.getCell(0);
                        XSSFCell pw = row.getCell(1);

                        data[i - 1][0] = (un != null) ? un.getStringCellValue() : ""; // Handle null cells
                        data[i - 1][1] = (pw != null) ? pw.getStringCellValue() : ""; // Handle null cells
                    }
                }
                return data;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Excel file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }

        // Default return if method name is not "validateLogin" or in case of exceptions
        System.out.println("Returning default data.");
        return new Object[1][2]; // Default array with one empty row
    }
}
