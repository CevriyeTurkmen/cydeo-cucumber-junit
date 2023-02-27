package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

@Test
    public void read_from_excel_file() throws IOException {

    String path="SampleData.xlsx";

    File file=new File(path);
    FileInputStream fileInputStream=new FileInputStream(file);

    XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
    XSSFSheet sheet=workbook.getSheet("Employees");

    System.out.println(sheet.getRow(1).getCell(0));

int usedRows=sheet.getPhysicalNumberOfRows();
    System.out.println(usedRows);

    int lastUsedRow= sheet.getLastRowNum();
    System.out.println(lastUsedRow);

    for (int rowNum = 0; rowNum < usedRows; rowNum++) {
        if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){

            System.out.println(sheet.getRow(rowNum).getCell(0));
        }
    }

    for (int rowNum = 0; rowNum < usedRows; rowNum++) {
        if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){

            System.out.println("Linda's job ID is = " + sheet.getRow(rowNum).getCell(2));
        }
    }

}
}
