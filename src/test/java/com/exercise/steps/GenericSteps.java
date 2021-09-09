package com.exercise.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import com.exercise.support.PageObjectManager;
import com.exercise.support.World;

import java.util.List;

public class GenericSteps {
    private final World world;
    private final PageObjectManager pageObjectManager;

    public GenericSteps(World world){
        this.world = world;
        this.pageObjectManager = new PageObjectManager(world.getDriver());
    }

    @Given("I am on index page")
    public void iAmOnIndexPage () {
        world.getDriver().navigate().to(world.getBaseUrl());
        pageObjectManager.getIndexPage();
    }

    @Given("I am on authentication page")
    public void iAmOnAuthenticationPage () {
        world.getDriver().navigate().to(world.getBaseUrl() + "?controller=authentication&back=my-account");
        pageObjectManager.getSignInPage();
    }

    @Given("I am on category page")
    public void iAmOnCategoryPage () {
        world.getDriver().navigate().to(world.getBaseUrl() + "?id_category=8&controller=category");
        pageObjectManager.getCategoryDressesPage();
    }

    @Given("user is logged in with following details")
    public void userIsLoggedInWithFollowingDetails (DataTable table) {
        List<List<String>> rows = table.asLists(String.class);

        for (List<String> columns : rows) {
            pageObjectManager.getSignInPage().login(columns.get(0), columns.get(1));
        }
    }
}
