package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcellRead {

@Test
    public void read_from_excel_file() throws IOException {

    String path="SampleData.xlsx";

    File file=new File(path);
    FileInputStream fileInputStream=new FileInputStream(file);

    XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
    XSSFSheet sheet=workbook.getSheet("Employees");

    System.out.println(sheet.getRow(1).getCell(0));

int usedRowns=sheet.getPhysicalNumberOfRows();
    System.out.println(usedRowns);

    int lastUsedRow= sheet.getLastRowNum();
    System.out.println(lastUsedRow);

    for (int rowNum = 0; rowNum < usedRowns; rowNum++) {
        if (sheet.getRow(rowNum).getCell(0).equals("Vinod")){

            System.out.println(sheet.getRow(rowNum).getCell(0));
        }
    }

    for (int rowNum = 0; rowNum < usedRowns; rowNum++) {
        if (sheet.getRow(rowNum).getCell(0).equals("Linda")){

            System.out.println("sheet.getRow(rowNum).getCell(2) = " + sheet.getRow(rowNum).getCell(2));
        }
    }

}
}
