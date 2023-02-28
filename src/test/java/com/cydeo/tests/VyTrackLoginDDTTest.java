package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackLoginPage vyTrackLoginPage=new VyTrackLoginPage();
    VyTrackDashboardPage vyTrackDashboardPage=new VyTrackDashboardPage();

    @Before
    public void setUp(){

        Driver.getDriver().get("https://qa2.vytrack.com/user/login");

    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {

        String filePath="VyTrackQa2Users.xlsx";
        FileInputStream in=new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(in);
        XSSFSheet sheet=workbook.getSheet("data");

        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            String username=sheet.getRow(i).getCell(0).toString();
            String password=sheet.getRow(i).getCell(1).toString();
            String firstname=sheet.getRow(i).getCell(2).toString();
            String lastname=sheet.getRow(i).getCell(3).toString();
            vyTrackLoginPage.login(username,password);

            String actualFullname=vyTrackDashboardPage.fullName.getText();

            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
            wait.until(ExpectedConditions.visibilityOf(vyTrackDashboardPage.fullName));
            XSSFCell resultCell=sheet.getRow(i).getCell(4);

            if (actualFullname.contains(firstname)&&actualFullname.contains(lastname)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            }else
            {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }
vyTrackDashboardPage.logout();
        }

        FileOutputStream out=new FileOutputStream(filePath);
        workbook.write(out);
        in.close();
        out.close();
        workbook.close();





    }




}
