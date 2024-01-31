package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        List<WebElement> inputElements =  StaticUtils.webDriver.findElements(By.cssSelector("input"));

//        List<WebElement> buttons = StaticUtils.webDriver.findElements(By.xpath(
//                "//input[@type='button' ][@value='" + buttonName + "'] | //button[contains(text(), '" + buttonName + "')]"));

        boolean foundSendButton = false;
        for(WebElement element: inputElements) {
            String role = element.getAriaRole();
            if(role.equalsIgnoreCase("button")) {
                if(element.getAttribute("value").equalsIgnoreCase(buttonName)) {
                    foundSendButton = true;
                    element.click();
                }
            }
        }
        if(!foundSendButton)
            throw new RuntimeException("No button found with name: " + buttonName);

    }
    @Then("an alert window appears")
    public void an_alert_window_appears() {
        Alert alert = StaticUtils.webDriver.switchTo().alert();
        assertNotNull(alert, "There's not alter dialog");
    }



    @When("I dismiss the alert")
    public void i_dismiss_the_alert()  {
        Alert alert = StaticUtils.webDriver.switchTo().alert();
        assertNotNull(alert, "There's not alter dialog");
        alert.dismiss();
    }
    @Then("I am on the {string} page")
    public void i_am_on_the_contact_page(String pageTitle) {
        // Write code here that turns the phrase above into concrete actions
        String actualPageTitle = StaticUtils.webDriver.getTitle();
        assertEquals(pageTitle, actualPageTitle);
    }

}
