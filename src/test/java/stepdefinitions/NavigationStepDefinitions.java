package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationStepDefinitions {

    WebDriver driver;

    @Given("I have a browser open")
    public void iHaveABrowserOpen() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver.get(url);
    }

    @Then("I see the {string} page")
    public void iSeeThePage(String pageTitle) {
        String tabTitle = driver.getTitle();
        assertTrue(tabTitle.contains(pageTitle));
    }

    @After
    public void afterAll() {
        if(driver == null )
            return;
        if(driver.toString() != null)
            this.driver.quit();
    }

}
