package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl= "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openWebBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException{
        Thread.sleep(1000);
        //enter valid user name
        sendTextOnElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]"),"johnsmith3");
        //enter valid password
        sendTextOnElement(By.name("password"),"asbdee12");
      //click on login
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //verify
        String expText ="Accounts Overview";
        String actText = getTextElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        Assert.assertEquals(expText,actText);





    }
    @Test
    public void verifyTheErrorMessage()  throws InterruptedException{
        Thread.sleep(1000);
        //enter invalid user name
        sendTextOnElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]"),"johnsmith312");
        //enter invalid password
        sendTextOnElement(By.name("password"),"asbdee1200");
        //click on login
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //* Verify the error message ‘The username and password could not be verified

    }
    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException{
        Thread.sleep(1000);
        //enter valid user name
        sendTextOnElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]"),"johnsmith3");
        //enter valid password
        sendTextOnElement(By.name("password"),"asbdee12");
        //click on login
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //click on logout
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

       //* Verify the text ‘Customer Login’
        String expText ="Customer Login";
        String actText = getTextElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        Assert.assertEquals(expText,actText);


    }
    @After
    public void closeTab(){
        closeBrowser();
    }


}
