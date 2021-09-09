package com.exercise.support;

import com.exercise.models.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private CategoryDressesPage categoryDressesPage;
    private IndexPage indexPage;
    private MyAccountPage myAccountPage;
    private RegisterAccountPage registerAccountPage;
    private SignInPage signInPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public CategoryDressesPage getCategoryDressesPage(){
        return (categoryDressesPage == null) ? categoryDressesPage = new CategoryDressesPage(driver) : categoryDressesPage;
    }

    public IndexPage getIndexPage(){
        return (indexPage == null) ? indexPage = new IndexPage(driver) : indexPage;
    }

    public MyAccountPage getMyAccountPage(){
        return (myAccountPage == null) ? myAccountPage = new MyAccountPage(driver) : myAccountPage;
    }

    public RegisterAccountPage getRegisterAccountPage(){
        return (registerAccountPage == null) ? registerAccountPage = new RegisterAccountPage(driver) : registerAccountPage;
    }

    public SignInPage getSignInPage(){
        return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
    }
}
