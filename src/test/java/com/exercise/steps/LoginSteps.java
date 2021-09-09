package com.exercise.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.exercise.support.PageObjectManager;
import com.exercise.support.World;

import java.util.List;

public class LoginSteps {
    private final World world;
    private final PageObjectManager pageObjectManager;

    public LoginSteps (World world) {
        this.world = world;
        this.pageObjectManager = new PageObjectManager(world.getDriver());
    }

    @When("I login in with details")
    public void iEnterUserDetails (DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> columns : rows) {
            pageObjectManager.getSignInPage().login(columns.get(0), columns.get(1));
        }
    }

    @Then("user is signed in")
    public void userIsSignedIn () {
//        pageObjectManager.getMyAccountPage().isMyAccountPageDisplayed();
    }

    @When("I navigate to login page")
    public void iNavigateToLoginPage () {
        pageObjectManager.getIndexPage().clickSignIn();
    }
}
