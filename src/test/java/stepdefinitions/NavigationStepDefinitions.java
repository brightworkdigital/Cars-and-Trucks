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


    @Given("I have a browser open")
    public void iHaveABrowserOpen() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        StaticUtils.webDriver = new ChromeDriver(options);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        StaticUtils.webDriver.get(url);
    }

    @Then("I see the {string} page")
    public void iSeeThePage(String pageTitle) {
        String tabTitle = StaticUtils.webDriver.getTitle();
        assertTrue(tabTitle.contains(pageTitle));
    }

    @After
    public void afterAll() {
        if(StaticUtils.webDriver == null )
            return;
        if(StaticUtils.webDriver.toString() != null)
            StaticUtils.webDriver.quit();
    }

}
