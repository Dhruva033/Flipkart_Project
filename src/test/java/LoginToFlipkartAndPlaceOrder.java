import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginToFlipkartAndPlaceOrder extends BaseTest {

    private Map<String, Object> testData;

    @Factory(dataProvider = "testDataProvider")
    public LoginToFlipkartAndPlaceOrder(Map<String,Object> testData){
        this.testData=testData;
    }

    @DataProvider
    public static Object[][] testDataProvider() {
        return  readDataFromExcel.getTestData("D:/FlipkartProject/FlipkartTestData.xlsx","Flipkart");
    }
    @Test
    public void LoginAndPlaceOrder() throws InterruptedException {
        driver.get(testData.get("URL").toString());
        FlipkartPage flipkartPage = new FlipkartPage(driver);
        flipkartPage.clickOnLoginButton();
        flipkartPage.EnterMobileNumber(testData.get("MobileNumber").toString());
        flipkartPage.clickOnRequestOtpButton();
        flipkartPage.EnterTheProductNameInSearchField(testData.get("productName").toString());
        flipkartPage.SelectTheProduct();
        flipkartPage.addToCart();
        flipkartPage.clcikOnPlaceOrder();
        flipkartPage.clickOnDeliverHere();
        flipkartPage.clickOnContinueButton();
        flipkartPage.EnterCardNumber(testData.get("CardNumber").toString());
        flipkartPage.SelectMonthAndYear(testData.get("Month").toString(),testData.get("Year").toString());
        flipkartPage.EnterCvv(testData.get("CVV").toString());
        flipkartPage.clickOnPay();


    }
}
