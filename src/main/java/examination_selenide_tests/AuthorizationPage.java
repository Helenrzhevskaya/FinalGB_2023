package examination_selenide_tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationPage  {

    private SelenideElement usernameField = $(By.xpath("//input[@type='text']"));

    private SelenideElement passwordField = $(By.xpath("//input[@type='password']"));

    private SelenideElement submitLoginButton = $(By.xpath("//button[@type='submit']"));


    public AuthorizationPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }
    public AuthorizationPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public My_account_page enterButton() {
        submitLoginButton.click();
        return page(My_account_page.class);
    }
}
