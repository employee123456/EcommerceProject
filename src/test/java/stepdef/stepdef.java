package stepdef;

import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class stepdef {

    WebDriver driver;
    String url = "https://parabank.parasoft.com/parabank/overview.htm";
    String username = "john";
    String password = "demo";
    Scenario scenario;

    @Before
    public void setUP(Scenario scenario) //dependency imjection
    {
        this.scenario =scenario;
        scenario.log("executed before each step");

    }
    @After
    public void cleanUp(){
        if(!(driver==null)) {
            driver.quit();
        }
        scenario.log("executed before each step");
    }
    @BeforeStep
    public  void beforeEachline(){
        scenario.log("executed before each step");

    }

    @AfterStep
    public void aftereachStep(){
        if(!(driver==null)){
            TakesScreenshot scrnShot =(TakesScreenshot) driver;
            byte[]data= scrnShot.getScreenshotAs(OutputType.BYTES);
            scenario.log(data, "image/png", "Failed step Name:" + scenario.getName());
        }
    }


    @Given("User opened the browser")
    public void user_opened_the_browser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // maximize browser window
        driver.manage().deleteAllCookies(); // delete all cookies
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @And("user is entered the Application Url")
    public void user_is_entered_the_application_url() {
        driver.get(url);

    }

    @When("user enter username as {string} and password as {string} and click on the login button")
    public void user_enter_username_as_and_password_as_and_click_on_the_login_button(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement((By.name("password"))).sendKeys(password);
        driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();

    }

    @Then("user is able to login to the Application")
    public void user_is_able_to_login_to_the_application() {
        Assert.assertEquals("ParaBank | Accounts Overview", driver.getTitle());
        boolean actualTableDisplayed = driver.findElement(By.id("accountTable")).isDisplayed();
        Assert.assertEquals(true, actualTableDisplayed);


    }

//test2

    @Given("User is looged In")
    public void user_is_looged_in() {
        user_opened_the_browser();
        user_is_entered_the_application_url();
        user_enter_username_as_and_password_as_and_click_on_the_login_button(username, password);

    }
    @And("User click on link as {string}")
    public void user_click_on_link_as(String linkName) {
        driver.findElement(By.xpath("//a[text()=\"Open New Account\"]")).click();
    }


    @When("User is select account as {string} and any account number")
    public void user_is_select_account_as_and_any_account_number(String type) {
        WebElement dropDownAccType= driver.findElement(By.id("type"));
        Select selectAccType = new Select(dropDownAccType);
        selectAccType.selectByVisibleText(type);

        WebElement dropDownAccountnumber = driver.findElement(By.id("fromAccountId"));
        Select selectAccountnumber =new Select(dropDownAccountnumber);
        selectAccountnumber.selectByIndex(0);
    }


    @And("user click on Button Open new Account")
    public void user_click_on_button_open_new_account() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@value='Open New Account']")).click();

    }

    @Then("Account opened message is Displayed")
    public void account_opened_message_is_displayed() {
        WebElement element = driver.findElement(By.xpath("//h1[text()=\"Account Opened!\"]"));
        Assert.assertEquals("Account Success Message", element.isDisplayed(), true);
    }

    @And("A new number is generated")
    public void a_new_number_is_generated() {
        WebElement element =driver.findElement(By.xpath("//a[@id=\"newAccountId\"]"));
        String accNumber = element.getText();
        Assert.assertEquals("New Account is Opened", element.isDisplayed(), true);
        scenario.log("New account number is generated as:" +accNumber);


    }

////test3
//    @Given("I want to do something")
//    public void i_want_to_do_something() {
//
//}
//    @When("I have a argument to send {string}")
//    public void i_have_a_argument_to_send(String arg) {
//        System.out.println("Printing the argument:"+arg);
//
//    }
//    @Then("something should happened")
//    public void something_should_happened() {
//
//    }
//
//    @When("I have a list of item to send")
//    public void i_have_a_list_of_item_to_send(List<String> list) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        System.out.println(list.toString());
//    }
//
//    @When("I have student and there mark to send")
//    public void i_have_student_and_there_mark_to_send(Map<String,String>map) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        System.out.println(map);
//    }
////test4
//    @Given("I am on the search page")
//    public void i_am_on_the_search_page() {
//
//    }
//    @When("I search for the product {string}")
//    public void i_search_for_the_product(String string) {
//        System.out.println("Product search:" +string);
//    }
//
//    @Then("Result should be displayed as {string}")
//    public void result_should_be_displayed_as(String string) {
//        System.out.println("Product search success:" +string);
//    }

}

}
