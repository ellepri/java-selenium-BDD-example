package com.exercise.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterAccountPage {
    private final WebDriver driver;

    public RegisterAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectMrTitle(){
        WebElement titleMrBtn = driver.findElement(By.id("uniform-id_gender1"));
        titleMrBtn.click();
    }

    public void selectMrsTitle(){
        WebElement titleMrsBtn = driver.findElement(By.id("uniform-id_gender2"));
        titleMrsBtn.click();
    }

    public void enterFirstName(String firstName){
        WebElement firstNameField = driver.findElement(By.id("customer_firstname"));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        WebElement lastNameField = driver.findElement(By.id("customer_lastname"));
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email){
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement pswField = driver.findElement(By.id("passwd"));
        pswField.sendKeys(password);
    }

    public void enterAddressFirstName(String firstName){
        WebElement addressFirstNameField = driver.findElement(By.id("firstname"));
        addressFirstNameField.sendKeys(firstName);
    }

    public void enterAddressLastName(String lastName){
        WebElement addressLastNameField = driver.findElement(By.id("lastname"));
        addressLastNameField.sendKeys(lastName);
    }

    public void enterAddress(String address){
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys(address);
    }

    public void enterCity(String city){
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys(city);
    }

    public void selectState(String state){
        Select stateDropDown = new Select(driver.findElement(By.id("id_state")));
        stateDropDown.selectByVisibleText(state);
    }

    public void enterZip(String zip){
        WebElement zipField = driver.findElement(By.id("postcode"));
        zipField.sendKeys(zip);
    }

    public void enterMobilePhoneNr(String phoneNumber){
        WebElement mobilePhoneField = driver.findElement(By.id("phone_mobile"));
        mobilePhoneField.sendKeys(phoneNumber);
    }

    public void enterAddressAlias(String addressAlias){
        WebElement addressAliasField = driver.findElement(By.id("alias"));
        addressAliasField.sendKeys(addressAlias);
    }

    public void clickSubmit(){
        WebElement submitBtn = driver.findElement(By.id("submitAccount"));
        submitBtn.click();
    }
}
