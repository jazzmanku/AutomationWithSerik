package funtional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Helper;

public class UiTest extends TestBase {


    @Test(enabled = true)
    public void TestRadio() throws InterruptedException {
        // First test run
        // Are you excited For Automation Testing?
        WebElement radioButton = driver.findElement(By.id("Are_you_excited_For_Automation_Testing__No"));
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected());
        stringBuffer.append("Test Case .........: Status: PASS" +"\n");
    }

    @Test(enabled = false)
    public void TestCheckbox(){
        //What is your dream job?
        WebElement checkBox = driver.findElement(By.id("What_is_your_dream_job__100K_Job"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());
        stringBuffer.append("Test Case .........: Status: PASS" +"\n");
    }

    @Test
    public void ReadProps(){
        System.out.println(Helper.readPropertyByKey("app_url"));
    }

    @Test(enabled = false)
    public void TestOtherThings(){
        //            //Email *
//            driver.findElement(By.id("Email")).sendKeys("ssss@gmail.com");
//            //Today’s Date?
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate localDate = LocalDate.now();
//            driver.findElement(By.id("Today_s_Date_")).sendKeys(dtf.format(localDate));
//            //Current Timestamp?
//            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH/mm");
//            LocalTime localTime = LocalTime.now();
//            driver.findElement(By.id("Current_Timestamp_")).sendKeys(dtf1.format(localTime));
//            //Enter any number between 1 to 100 *
//            driver.findElement(By.id("Enter_any_number_between__1_to_100")).sendKeys("99");
//            //Favorite Website? *
//            driver.findElement(By.id("Favorite_Website_")).sendKeys("https://mail.google.com/");
//            //Fill in the Address
//            driver.findElement(By.id("Fill_in_the_Address_address_line_1")).sendKeys("Thompson 99");
//            driver.findElement(By.id("Fill_in_the_Address_city")).sendKeys("Astana");
//            driver.findElement(By.id("Fill_in_the_Address_country")).sendKeys("Kazakhstan");
//            //What do you think of this form? *
//            driver.findElement(By.id("What_do_you_think_of_this_form_")).sendKeys("Tricky");
//            //Click submit
//            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div/" +
//                    "section/div/form/fieldset/div[14]/div/input")).click();
    }

    }

