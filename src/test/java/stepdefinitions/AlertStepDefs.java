package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AlertStepDefs {


    @Given("I am on the page {string}")
    public void i_am_on_the_page(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        StaticUtils.webDriver = new ChromeDriver(options);
        StaticUtils.webDriver.get(url);
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {

    }
    @Then("an alert window appears")
    public void an_alert_window_appears() {
        // Write code here that turns the phrase above into concrete actions
    }

}
