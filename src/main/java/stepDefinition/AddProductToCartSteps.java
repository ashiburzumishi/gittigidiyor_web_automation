package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageEvent.AddProductToCard;
import utilities.Driver;
import utilities.Variables;
import java.util.concurrent.TimeUnit;

public class AddProductToCartSteps {
    private WebDriver driver;
    AddProductToCard addProductToCard = new AddProductToCard();
    @Given("^user opens page$")
    public void goToHomepage() {
        driver = Driver.getWebDriver();
        driver.get(Variables.HOMEPAGE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        addProductToCard.acceptCookie();
    }
    @When("^user types the keyword$")
    public void searchKeyword() {
        addProductToCard.searchKeyword();
    }

    @When("^user clicks on search button$")
    public void userClicksOnSearchButton() {
        addProductToCard.clickSearchButton();
    }
    @When("^user clicks second page$")
    public void userClicksSecondPage() {
        addProductToCard.clickByJs(Variables.SECOND_PAGE);
        addProductToCard.assertUrlText("sf=2");
    }
    @When("^user clicks product$")
    public void userClicksProduct()  {
        addProductToCard.waitSeconds(3);
        addProductToCard.clickProduct();
    }

    @When("^user saves product info to file$")
    public void userSavesProductInfoToFile() {
        addProductToCard.writeToFile();
    }

    @When("^user add product to cart$")
    public void userAddProductToCart() {
    addProductToCard.clickAddProductButton();
    }

    @When("^user goes to cart page$")
    public void userGoesToCartPage() {
        addProductToCard.clickGoToCartButton();
    }

    @When("^user compares prices$")
    public void userComparesPrices() {
        addProductToCard.priceCompare();
    }

    @When("^user increases the product count$")
    public void userIncreasesTheProductCount() {
        addProductToCard.increasesProductCount();
    }

    @When("^user clicks to delete button$")
    public void userClicksToDeleteButton() {
        addProductToCard.clickDeleteButton();
    }

    @Then("^user must be seen the cart is empty$")
    public void userMustBeSeenTheCartIsEmpty() {
        addProductToCard.isEmptyBasketCart();

    }

}
