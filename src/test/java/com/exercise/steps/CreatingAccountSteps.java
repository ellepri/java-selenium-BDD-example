package com.exercise.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.exercise.support.PageObjectManager;
import com.exercise.support.World;

public class CreatingAccountSteps {
    private final World world;
    private final PageObjectManager pageObjectManager;

    public CreatingAccountSteps (World world) {
        this.world = world;
        this.pageObjectManager = new PageObjectManager(world.getDriver());
    }

    @When("I enter an email")
    public void iEnterAnEmail () {
        pageObjectManager.getSignInPage().enterEmail("jane.doe@gmail.com");
    }

    @And("click Create an account")
    public void clickCreateAnAccount () {
        pageObjectManager.getSignInPage().clickCreateAnAccount();
    }

    @And("I fill in the form")
    public void iFillInTheForm () {
        pageObjectManager.getRegisterAccountPage().selectMrsTitle();
        pageObjectManager.getRegisterAccountPage().enterFirstName("Joe");
        pageObjectManager.getRegisterAccountPage().enterLastName("Doe");
        pageObjectManager.getRegisterAccountPage().enterEmail("jane.doe@gmail.com");
        pageObjectManager.getRegisterAccountPage().enterPassword("password");
        pageObjectManager.getRegisterAccountPage().enterAddressFirstName("Joe");
        pageObjectManager.getRegisterAccountPage().enterAddressLastName("Doe");
        pageObjectManager.getRegisterAccountPage().enterAddress("98 Far Away Lane");
        pageObjectManager.getRegisterAccountPage().enterCity("New York");
        pageObjectManager.getRegisterAccountPage().selectState("New York");
        pageObjectManager.getRegisterAccountPage().enterZip("00000");
        pageObjectManager.getRegisterAccountPage().enterMobilePhoneNr("0987654321");
        pageObjectManager.getRegisterAccountPage().enterAddressAlias("new york");
        pageObjectManager.getRegisterAccountPage().clickSubmit();
    }

    @Then("new account has been created")
    public void newAccountHasBeenCreated () {
//        pageObjectManager.getMyAccountPage().isMyAccountPageDisplayed();
    }
}
