package seleniumE2E.Tests;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import seleniumE2E.Util.BaseTest;

/**
 * @author merve.sozen
 */
public class LogInExistedUser extends BaseTest { //to have common method of basetest class


    By userNameField =By.id("userName");
    By passwordField =By.id("password");
    By loginBtn=By.id("login");
    By logOutBtn=By.id("submit");
    By bookStoreBtn= By.id("gotoStore");
    By searchField= By.id("searchBox");
    By addNewRecordButton=By.id("addNewRecordButton");
    By listField=By.className("rt-tbody");
    By menulist=By.className("menu-list");
    By profileMenuBtn =By.id("item-3");
    By leftpannel =By.className("left-pannel");

    //input values;

    String username="mrv93";
    String passWord="Test1234!";
    String searchWord="Speaking JavaScript";
    String menuProfile="Book Store Application";

    @Test
    public void test1_LoginUser(){
        type(userNameField,username);
        type(passwordField,passWord);
        click(loginBtn);
        waitVisibility(bookStoreBtn);
        System.out.println("Login Successful!");
    }

    @Test
    public void test2_searchandAddBook(){
        click(bookStoreBtn);
        waitVisibility(searchField);
        type(searchField,searchWord);
        clickSearchedValue(listField,searchWord);
        scrollDown();
        waitVisibility(addNewRecordButton);
        click(addNewRecordButton);
    }

    @Test
    public void test3_deleteChart(){
        scrollDown();
        selectMenu(leftpannel,menuProfile);
    }


    @AfterClass
    public void test3_LogOut(){
        click(logOutBtn);
        waitVisibility(loginBtn);
        System.out.println("Logout Successful!");
    }

}
