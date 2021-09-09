package com.exercise.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.exercise.support.PageObjectManager;
import com.exercise.support.World;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingSteps {
    private final World world;
    private final PageObjectManager pageObjectManager;
    private int dressPosition;

    public ShoppingSteps(World world){
        this.world = world;
        this.pageObjectManager = new PageObjectManager(world.getDriver());
    }

    @When("I navigate to {string} page")
    public void iNavigateToDressesPage (String menuItem) {
//        pageObjectManager.getMyAccountPage().clickMenuItem(menuItem);
    }

    @And("I sort by {string}")
    public void iSortBy (String sortByCategory) {
        pageObjectManager.getCategoryDressesPage().sortBy(sortByCategory);
    }

    @And("I select the first dress")
    public void iSelectTheFirstDress () {
        pageObjectManager.getCategoryDressesPage().addItemToCartByPosition(0);
    }

    @And("I click on most expensive dress")
    public void iClickOnMostExpensiveDress () {
        List<String> listOfProductPrices = pageObjectManager.getCategoryDressesPage().getListOfProductPrices();

        List<Double> prices = listOfProductPrices.stream().map(dress -> Double.parseDouble(
                dress.replaceAll("\\$", ""))).collect(Collectors.toList());

        int position = prices.indexOf(prices.stream().max(Double::compare).get()) - 1;
        pageObjectManager.getCategoryDressesPage().addItemToCartByPosition(position);
    }

    @Then("my item is added to the cart")
    public void myItemIsAddedToTheCart () {
        Map<String, String> productDescFromPage = pageObjectManager.getCategoryDressesPage().productDescByPosition(dressPosition);
        Map<String, String> productDescFromFrame = pageObjectManager.getCategoryDressesPage().getItemDescFromAddedToCartFrame();

        Assert.assertEquals(productDescFromFrame.get("productName"), productDescFromPage.get("productName"));
        Assert.assertEquals(productDescFromFrame.get("price"), productDescFromPage.get("price"));
    }

    @And("the {string} heading is displayed")
    public void theHeadingIsDisplayed (String headingText) {
        Assert.assertEquals(pageObjectManager.getCategoryDressesPage().getHeadingFromAddedToCartFrame(), headingText);
    }
}
