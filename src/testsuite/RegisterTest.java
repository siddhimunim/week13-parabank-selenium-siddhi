package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl= "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openWebBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay() throws InterruptedException{
        Thread.sleep(1000);
        //click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //verify text
        String expectedMessage = "Signing up is easy!";
        String actualMessage = getTextElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void userSholdRegisterAccountSuccessfully()throws InterruptedException{
        //click on register link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //enter first name
        sendTextOnElement(By.id("customer.firstName"), "John");
        //enter last name
        sendTextOnElement(By.id("customer.lastName"),"Smith");
        //enter address
        sendTextOnElement(By.id("customer.address.street"),"20,abc street");
        //enter city
        sendTextOnElement(By.id("customer.address.city"),"Bristol");
        //enter state
        sendTextOnElement(By.id("customer.address.state"),"Hampshire");
        //enter zip code
        sendTextOnElement(By.id("customer.address.zipCode"),"01595");
        //enter phone
        sendTextOnElement(By.id("customer.phoneNumber"),"15295875");
        //enter SSN
        sendTextOnElement(By.id("customer.ssn"),"4558");
        //enter Username
        sendTextOnElement(By.id("customer.username"),"johnsmith3");
        //enter password
        sendTextOnElement(By.id("customer.password"),"asbdee12");
        //enter confirmation
        sendTextOnElement(By.id("repeatedPassword"),"asbdee12");
       //type on regestration button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //verify
        String expectedMessage ="Your account was created successfully. You are now logged in.";
        String actualMessage = getTextElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        Assert.assertEquals(expectedMessage,actualMessage);




    }
    @After
    public void closeTab(){
        closeBrowser();
    }



}
