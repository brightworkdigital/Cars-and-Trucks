package com.example.demo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebsiteTitleTest {

    @Test
    public void testWebsiteTitle() {
        // Initialize a new instance of the ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the desired web page
            driver.get("https://home.barclays/");

            // Get the title of the web page
            String title = driver.getTitle();

            // Assert that the title is what we expect
            assertEquals("Barclays | Official Website", title);

            // Your test logic here
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
