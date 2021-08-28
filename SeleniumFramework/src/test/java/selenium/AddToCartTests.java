package selenium;

import PageObjects.*;
import Pojo.ProductsPrices;
import dataProviders.ProductPricesProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart it's working")
    @Test
    public void Test_Add_To_Cart_Functionality() {
        int quantity = 5;
        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String imageURL = "macbook_1-47x47.jpg";
        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(), quantity, "Quantity is not matching");
        Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");

    }
    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart(){
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().SetQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }
    @Description("Test Case #2: Validate product is added to the cart")
    @Test
    public void Test_Product_Added_To_The_Cart() {
        String searchTestCriteria = "MacBook Air ";
        String expectedMessageAddToCart = "Success: You have added MacBook Air to your shopping cart!";
        String expectedErrorToChekOut = "Products marked with *** are not available in the desired quantity or not in stock!";
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct(searchTestCriteria);
        SearchResultsPage searchResultsPage = new  SearchResultsPage(driver);
        searchResultsPage.clickAddToCart();
        Assert.assertTrue(searchResultsPage.catchProductAddedToCartMessage().contains(expectedMessageAddToCart));
        searchResultsPage.ShoppingCartPreview();
        searchResultsPage.clickCheckOutLink();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.checkOutMessage().contains(expectedErrorToChekOut));
        }

    @Description("Test Case #3: Check the price of a product in different currencies.")
    @Test(dataProvider = "getProductPricesDataFromJson", dataProviderClass = ProductPricesProvider.class)
    public void Test_Different_Currency_Values(ProductsPrices testProduct) {

        int quantity = 1;

        HomePage homePage =new HomePage(driver);
        homePage.searchForProduct(testProduct.getProduct());
        ProductPage productPage= new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String name = homePage.selectFirstProductAndGetName();
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        headerPage().clickOnCartButton();
        headerPage().changeCurrencyToDollar();
        String dollarTotalAmount = shoppingCartPage.catchProductPriceOnShoppingCart();
        headerPage().changeCurrencyToEuro();
        String euroTotalAmount =shoppingCartPage.catchProductPriceOnShoppingCart();
        headerPage().changeCurrencyToPound();
        String poundTotalAmount=shoppingCartPage.catchProductPriceOnShoppingCart();

        double dollar = Utils.returnDouble(dollarTotalAmount);
        double euro = Utils.returnDouble(euroTotalAmount);
        double pound = Utils.returnDouble(poundTotalAmount);
        Assert.assertEquals(dollar,testProduct.getDolarsPrice());
        Assert.assertEquals(euro,testProduct.getEuroPrice());
        Assert.assertEquals(pound,testProduct.getPoundsPrice());
    }
}
