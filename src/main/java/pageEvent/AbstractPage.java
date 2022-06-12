package pageEvent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractPage {
    private WebDriver driver = Driver.getWebDriver();
    public Logger log = LogManager.getLogger(getClass().getName());
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String productInfoText;
    String productPriceText;

    public void clickFunction(WebElement clickElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(clickElement));
            clickElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }

    public void waitSeconds(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickByJs(String element) {
        WebElement webElement = driver.findElement(By.xpath(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }
    public void assertUrlText(String text) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(text));
        log.info(currentUrl);
    }
    public void writeToFiles(String productInfoElement, String productPriceElement) {
        productInfoText = driver.findElement(By.xpath(productInfoElement)).getText();
        productPriceText = driver.findElement(By.xpath(productPriceElement)).getText();

        String idForTxtFile = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
        File file = new File("productInfoLogs/ProductInfo-" + idForTxtFile);
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("Product Title : " + productInfoText + "\n" + "Product Price :" + productPriceText);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getPriceText(String priceOnCartPage) {
        String priceOnCart = driver.findElement(By.xpath(priceOnCartPage)).getText();
        Assert.assertEquals(priceOnCart, productPriceText);
        log.info("Product price :" + productPriceText);
        log.info("Product price on cart page :" + priceOnCart);
    }
    public void getElementText(String textElement) {
        String text = driver.findElement(By.xpath(textElement)).getText();
        log.info("Element text count :" + text);
        Assert.assertTrue(text.contains("2 Adet"));
    }
    protected void isElementDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath(utilities.Variables.COMPLETE_SHOPPING_BUTTON)).isDisplayed());
    }
}

