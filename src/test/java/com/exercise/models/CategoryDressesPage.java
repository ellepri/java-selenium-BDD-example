package com.exercise.models;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryDressesPage {
    private final WebDriver driver;
    private final By productContainer = By.cssSelector(".product-container");
    private final By addToCartButton = By.cssSelector(".ajax_add_to_cart_button");

    public CategoryDressesPage(WebDriver driver){
        this.driver = driver;

        if (!("Dresses - My Store".equals(driver.getTitle()))){
            throw new IllegalStateException("This is not the Dresses category page.");
        }
    }

    public void sortBy(String sortBy){
        Select dressesMenuItem = new Select(driver.findElement(By.id("selectProductSort")));
        dressesMenuItem.selectByVisibleText(sortBy);
    }

    public void addItemToCartByPosition(int position){
        List<WebElement> containers = driver.findElements(productContainer);

        // Hover over the container for the button to be visible
        Actions builder = new Actions(driver);
        builder.moveToElement(containers.get(position));
        builder.perform();

        containers.get(position).findElement(addToCartButton).click();
    }

    public void isCartEmpty() {
        WebElement cartQuantity = driver.findElement(By.cssSelector(".ajax_cart_quantity.unvisible"));
    }

    public void clickContinueShopping(){
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    public List<String> getListOfProductPrices(){
        return driver.findElements(By.cssSelector(".price.product-price"))
                .stream().map(WebElement::getText).filter(value -> value != null && value.length() > 0)
                .collect(Collectors.toList());
    }

    public Map<String, String> productDescByPosition(int position){
        Map<String, String> map = new HashMap<>();
        WebElement productContainerElement = driver.findElements(productContainer).get(position);
        String productName = productContainerElement.findElement(By.cssSelector(".product-name")).getText();

        WebElement priceElement = productContainerElement.findElement(By.cssSelector(".price"));
        String price = priceElement.getText();

        map.put("productName", productName);
        map.put("price", price);

        return map;
    }

    public Map<String, String> getItemDescFromAddedToCartFrame(){
        Map<String, String> map = new HashMap<>();
        By productInfoElement = By.cssSelector(".layer_cart_product_info");
        WebElement productInfoFrame = driver.findElement(productInfoElement);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(productInfoFrame));

        if (!productInfoFrame.isDisplayed()) throw new ElementNotVisibleException("Frame is not visible!");

        String productName = productInfoFrame.findElement(By.cssSelector(".product-name")).getText();
        String price = productInfoFrame.findElement(By.id("layer_cart_product_price")).getText();
        int quantity = Integer.parseInt(productInfoFrame.findElement(By.id("layer_cart_product_quantity")).getText());

        if (quantity > 1) {
            double priceConverted = Double.parseDouble(price.replace("$", ""));
            priceConverted = priceConverted / quantity;
            price = "$" + priceConverted;
        }

        map.put("productName", productName);
        map.put("price", price);

        return map;
    }

    public String getHeadingFromAddedToCartFrame(){
        WebElement cartProductFrame = driver.findElement(By.cssSelector(".layer_cart_product h2"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cartProductFrame));

        if (!cartProductFrame.isDisplayed()) throw new ElementNotVisibleException("Frame is not visible!");

        return cartProductFrame.getText();
    }
}
