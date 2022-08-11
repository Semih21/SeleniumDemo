package com.example.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://eaapp.somee.com/
public class EALoginPage {
    @FindBy(xpath = "//a[contains(@class, \"gb_1\")]")
    public WebElement inloggen;

    @FindBy(xpath = "//input[@data-ved=\"0ahUKEwjls__U4b75AhWQNewKHVj6B8sQ19QECA4\"]")
    public WebElement ahUkEwjlsUNew;

    @FindBy(css = "input[data-ved='0ahUKEwjls__U4b75AhWQNewKHVj6B8sQ4dUDCA0']")
    public WebElement ahUkEwjlsUNew2;

    @FindBy(css = "input.gNO89b")
    public WebElement ahUkEwjlsUNew3;

    @FindBy(name = "btnK")
    public WebElement ahUkEwjlsUNew4;

    


    public EALoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}