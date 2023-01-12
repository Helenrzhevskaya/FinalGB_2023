import com.codeborne.selenide.Selenide;
import examination_selenide_tests.AuthorizationPage;
import examination_selenide_tests.Error_Block;
import examination_selenide_tests.Success_Block;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;


public class MyStepdefsForPostRequest {
    @Given("authorization page opened")
    public void authorizationPageOpened() {
        open("https://test-stand.gb.ru/login");
    }

    @When("enter {string}")
    public void enterValidUsername(String username) {
        new AuthorizationPage().enterUsername(username);
    }

    @And("enter also {string}")
    public void enterAlsoValidPassword(String password) {
        new AuthorizationPage().enterPassword(password);
    }

    @And("click on the login button")
    public void clickOnTheLoginButton() {
        new AuthorizationPage().enterButton();
    }

    @And("greeting field should be correct")
    public void greetingFieldShouldBeCorrect() {
        new Success_Block().checkCorrectAuthorization("Hello, GB202301271f49");
    }

    @Then("page contains a blog with posts")
    public void pageContainsABlogWithPosts() {
        new Success_Block().checkBlockDisplay("Blog");
    }

    @And("greeting field should be missing")
    public void greetingFieldShouldBeMissing() {
        new Success_Block().checkCorrectMissingAuthorization();
    }

    @Then("page contains error code {string}")
    public void pageContainsErrorCode(String arg0) {
        new Error_Block().checkCorrectErrorCode("401");
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }



}
