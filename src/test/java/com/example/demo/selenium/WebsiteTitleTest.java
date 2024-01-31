package com.example.demo.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


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
            driver.get("https://www.thetestroom.com/webapp/adoption.html");

            boolean animalFound = false;
            List<WebElement> elements = driver.findElements(By.className("record"));
            for (WebElement element : elements) {
                String elementText = element.getText();
                System.out.println(elementText);
                if(elementText.contains("Lion")) {
                    animalFound = true;
                }
            }

            if(!animalFound) throw new RuntimeException("No animal to adopt");

            // Your test logic here
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
