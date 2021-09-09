package com.exercise.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private final WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;

        if (!("Login - My Store".equals(driver.getTitle()))){
            throw new IllegalStateException("This is not the login page.");
        }
    }

    public void enterEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("#create-account_form input[name=email_create]"));
        emailField.sendKeys(email);
    }

    public void clickCreateAnAccount(){
        WebElement createBtn = driver.findElement(By.cssSelector("#create-account_form button[name=SubmitCreate]"));
        createBtn.submit();
    }

    public void login(String email, String password){
        WebElement emailField = driver.findElement(By.cssSelector("#login_form input[name=email]"));
        WebElement passField = driver.findElement(By.cssSelector("#login_form input[name=passwd]"));
        WebElement submitBtn = driver.findElement(By.id("SubmitLogin"));

        emailField.sendKeys(email);
        passField.sendKeys(password);

        submitBtn.click();
    }
}
