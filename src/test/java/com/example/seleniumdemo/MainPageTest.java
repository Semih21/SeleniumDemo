package com.example.seleniumdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void initializeBrowser(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[data-test='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test='search-input']"));
        assertEquals(searchPageField.getAttribute("value"), "Selenium");
    }

    @Test
    public void toolsMenu() {
        new Actions(driver)
                .moveToElement(mainPage.toolsMenu)
                .perform();

        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='menu-main-popup-content']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");
    }
}
