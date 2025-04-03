import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlipkartPage {

    WebDriver driver;
    public FlipkartPage(WebDriver driver){
        this.driver=driver;
    }


    /**
     * This Method is used to click on the Login Button
     */
    public void clickOnLoginButton(){
        driver.findElement(By.xpath(ObjectRepository.Login_Title)).click();
    }

    /**
     * This Method is used to enter the Mobile number
     * @param Number<Number as String>
     */
    public void EnterMobileNumber(String Number){
        driver.findElement(By.xpath(ObjectRepository.Mobile_Number_Field)).sendKeys(Number);
    }

    /**
     * This Method is used to click on the Request Otp Button
     */
    public void clickOnRequestOtpButton() throws InterruptedException {
        driver.findElement(By.xpath(ObjectRepository.Mobile_Number_Field)).click();
        Thread.sleep(30000);
    }

    /**
     * This Method is used to enter the product number
     * @param productName<productName as String>
     */
    public void EnterTheProductNameInSearchField(String productName){
        driver.findElement(By.xpath(ObjectRepository.Search_Field)).sendKeys(productName, Keys.ENTER);
    }

    /**
     * This Method is used to Select The Product
     */
    public void SelectTheProduct(){
        driver.findElement(By.xpath(ObjectRepository.Select_product)).click();
    }

    /**
     * This Method is used to click on Add to cart
     */
    public void addToCart(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepository.go_to_cart_button))).click();
    }

    /**
     *This Method is used to click on place order
     */
    public void clcikOnPlaceOrder(){
        driver.findElement(By.xpath(ObjectRepository.Place_Order_button)).click();
    }

    /**
     *This Method is used to click on Delivery Here Button
     */
    public void clickOnDeliverHere(){
        driver.findElement(By.xpath(ObjectRepository.Delivery_Button)).click();
    }

    /**
     *This Method is used to click on Continue Button
     */
    public void clickOnContinueButton(){
        driver.findElement(By.xpath(ObjectRepository.Continue_Button)).click();
    } /**

     /**
     *This Method is used to click on  Credit card radio button
     */
    public void clickOnCreditCardRadioButton(){
        driver.findElement(By.xpath(ObjectRepository.Credit_Radio)).click();
    }

    /**
     *This Method is used to click on  Credit card radio button
     */
    public void EnterCardNumber(String cardnumber){
        driver.findElement(By.xpath(ObjectRepository.CARD_Number)).sendKeys(cardnumber);
    }

    /**
     *This Method is used to enter CVV
     */
    public void EnterCvv(String CVV){
        driver.findElement(By.xpath(ObjectRepository.CVV)).sendKeys(CVV);
    }

    /**
     *This Method is used to click on pay
     */
    public void clickOnPay(){
        driver.findElement(By.xpath(ObjectRepository.Pay_Button)).click();
    }

    /**
     * This method is used to select month and year
     */

    public void  SelectMonthAndYear(String Month,String Year){
        Select selectMonth = new Select(driver.findElement(By.xpath(ObjectRepository.Select_Month)));
        selectMonth.selectByVisibleText(Month);
        Select selectYear = new Select(driver.findElement(By.xpath(ObjectRepository.Select_Year)));
        selectYear.selectByVisibleText(Year);
    }



}
