package pageEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Variables;

public class AddProductToCard extends AbstractPage {
    WebDriver driver;
    @FindBy(xpath = Variables.SEARCH)
    private WebElement search;

    @FindBy(xpath = Variables.SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath =Variables.PRODUCT)
    private WebElement product;

    @FindBy(xpath = Variables.COOKIE)
    private WebElement acceptCookie;

    @FindBy(xpath = Variables.PRODUCT_TITLE)
    private WebElement productTitle;

    @FindBy(xpath = Variables.PRODUCT_PRICE)
    private WebElement productPrice;

    @FindBy(xpath = Variables.ADD_TO_CART)
    private WebElement addToCartButton;

    @FindBy(xpath = Variables.CART_TEXT)
    private WebElement cartText;

    @FindBy(xpath = Variables.CartPageButton)
    private WebElement cartPageButton;

    @FindBy(xpath = Variables.PriceOnCartPage)
    private WebElement priceOnCartPage;

    @FindBy(xpath = Variables.INCREASE_BUTTON)
    private WebElement increaseButton;
    @FindBy(xpath = Variables.INCREASE_COUNT_TO_TWO)
    private WebElement increaseCountToTwo;

    @FindBy(xpath = Variables.PRODUCT_COUNT)
    private WebElement productCount;

    @FindBy(xpath = Variables.DELETE_BUTTON)
    private WebElement deleteButton;

    @FindBy(xpath = Variables.COMPLETE_SHOPPING_BUTTON)
    private WebElement completeShopping;

    public AddProductToCard() {
        driver = Driver.getWebDriver();
        PageFactory.initElements(driver, this);
    }
    public void searchKeyword(){
        clickFunction(search);
        sendKeysFunction(search,"Bilgisayar");
    }
    public void clickSearchButton(){
        clickFunction(searchButton);
    }
    public void clickProduct(){
        clickFunction(product);
    }
    public void acceptCookie(){
        clickFunction(acceptCookie);
    }
    public void writeToFile(){
        writeToFiles(Variables.PRODUCT_TITLE,Variables.PRODUCT_PRICE);
    }
    public void clickAddProductButton(){
        clickFunction(addToCartButton);
    }
    public void clickGoToCartButton(){
        clickFunction(cartPageButton);
    }
    public void priceCompare(){
        getPriceText(Variables.PriceOnCartPage);
    }
    public void increasesProductCount(){
        clickFunction(increaseCountToTwo);
        waitSeconds(3);
        getElementText(Variables.PRODUCT_COUNT);
    }
    public void clickDeleteButton(){
        clickFunction(deleteButton);
    }
    public void isEmptyBasketCart(){
        isElementDisplayed();
    }
}