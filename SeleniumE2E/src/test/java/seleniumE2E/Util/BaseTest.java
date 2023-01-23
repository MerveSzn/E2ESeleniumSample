package seleniumE2E.Util;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;


/**
 * @author merve.sozen
 */
public class BaseTest {

    protected WebDriver driver; //aynı pakettekiler drivera ulaşabilir.


    //set driver and manage them

    @BeforeClass
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    /*@AfterMethod
    public void tearDown(){
        driver.quit();
    }*/


    protected WebElement find(By locator){
        return driver.findElement(locator);
    }


    protected void click(By locator){
        find(locator).click();
    }

    protected void waitVisibility(By locator){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitClickable(By locator){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(50));

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean isDisplayed(By locator){
        boolean isdisplay=driver.findElement(locator).isDisplayed();
        return isdisplay;
    }

    protected void scrollDown(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    protected String getText (By locator){
        return find(locator).getText();
    }

    protected void checkText(By locator,String text){

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(50));
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

    protected void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    protected void clickSearchedValue(By locator, String text){
        List<WebElement> list= driver.findElements(locator);
        list.get(0).getText();
        driver.findElement(By.linkText(text)).click();
    }

 protected void selectMenu(By locator,String menuText){

        String subMenu="Profile";
        List<WebElement> list= driver.findElements(By.className("element-group"));
        for(WebElement element:list){
            if (element.getText().contains(menuText)){
                List<WebElement > menulist=driver.findElements(By.className("element-list"));
                for(WebElement menuElement:menulist){
                    if (menuElement.getText().contains(subMenu)){
                        menuElement.click();

                    }
                }

            }
        }
    }

    private String generateRandomUser(){
        return RandomStringUtils.random(4,true,true);
    }



}
