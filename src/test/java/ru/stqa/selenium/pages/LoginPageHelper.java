package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement userField;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "#error>p")
    WebElement noLoginNoPasswordError;


    public LoginPageHelper(WebDriver driver){
        super(driver);
    }

    public LoginPageHelper openLoginPage(){
        logInIcon.click();
        waitUntilElementIsClickable(loginButton,10);
        return this;
    }
        public LoginPageHelper enterLoginAtlassianAndClickLogin(String login) {

        userField.sendKeys(login);
        waitUntilAttributeValueIs(loginButton, "value", "Log in with Atlassian",10);
        loginButton.click();
        waitUntilElementIsClickable(loginSubmitButton, 15);
        return this;

    }

//    public void enterLoginAtlassianAndClickLogin(String login) {
//        userField.sendKeys(login);
//        waitUntilAttributeValueIs(loginButton,"value","Log in with Atlassian",10);
//        loginButton.click();
//        waitUntilElementIsClickable(loginSubmitButton,15);
//    }

    public LoginPageHelper enterPasswordAtlassionAndClickLogin(String password) {

        passwordField.sendKeys(password);
        loginSubmitButton.click();
        return this;

    }

    public LoginPageHelper loginAsAtlassian(String login, String password){
        this.enterLoginAtlassianAndClickLogin(login);
        this.enterPasswordAtlassionAndClickLogin(password);
        return this;
    }


    public LoginPageHelper pressLoginButton() {
        //driver.findElement(By.id("login")).click();
        loginButton.click();
        return this;
    }

    public LoginPageHelper waitErrorMessage() {
        waitUntilElementIsVisible(noLoginNoPasswordError,10);
        return this;

    }

    public String getErrorMessage(){
        //WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        return noLoginNoPasswordError.getText();
    }

    public LoginPageHelper enterLoginNormal(String login) {
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.sendKeys(login);
        loginField.sendKeys(Keys.ENTER);
        return this;
    }

    public LoginPageHelper clickLoginButtonNormal() {
        waitUntilElementIsClickable(loginButton,15);
        //System.out.println("Is loginButton is clickable: " + loginButton.isEnabled());
        loginButton.click();
        return this;
    }

    public LoginPageHelper waitErrorMessageLoginIncorrect() {
        waitUntilElementIsVisible(By.xpath("(//*[@class= 'error-message'])[1]"),30);
        WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        System.out.println("Error message: " + errorMessage.getText());
        return this;
    }

    public String getErrorMessageloginIncorrect() {
        WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        return errorMessage.getText();
    }

    public LoginPageHelper waitErrorMessagePasswordIncorrect() {
        WebElement errorMessageIncorrectPassword;
        waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"),15);
        return this;
    }

    public String getIncorrectPassswordMessage(){
        WebElement errorMessageIncorrectPassword = driver.findElement(By.xpath("//div[@id='login-error']/span"));
        return errorMessageIncorrectPassword.getText();
    }

    public LoginPageHelper enterPasswordNormal(String password) {
        fillField(passwordField,password);
        return this;

    }

    public void enterPasswordAtlassianAndClickLogin(String login) {

        userField.sendKeys(login);
        waitUntilAttributeValueIs(loginButton,"value","Log in with Atlassian",20);
        loginButton.click();
        waitUntilElementIsClickable(loginSubmitButton,25);

    }

//    @FindBy(linkText ="Log In")
//    WebElement logInIcon;
//
//    @FindBy(id="login")
//    WebElement loginButton;
//
//    @FindBy(id="user")
//    WebElement userField;
//
//    @FindBy(id="login-submit")
//    WebElement loginSubmitButton;
//
//    @FindBy(id="password")
//    WebElement passwordField;
//
//    @FindBy(css = "#error>p")
//    WebElement noLoginNoPasswordError;
//
//    @FindBy(xpath = "//div[@id ='error']/p")// "(//*[@class='error-message'])[1]")
//            WebElement noLoginError;
//
//    @FindBy(xpath = "//div[@id='login-error']/span")
//    WebElement noPasswordError;
//
//
//
//    public LoginPageHelper(WebDriver driver){
//        super(driver);
//    }
//
//    public void openLoginPage(){
//
//        logInIcon.click();
//        waitUntilElementIsClickable(loginButton,10);
//    }
//
//    public void enterLoginAtlassianAndClickLogin(String login) {
//
//        userField.sendKeys(login);
//        waitUntilAttributValuesIs(loginButton, "value", "Log in with Atlassian",10);
//        loginButton.click();
//        waitUntilElementIsClickable(loginSubmitButton, 15);
//
//    }
//
//    public LoginPageHelper enterPasswordAtlassianAndClickLogin(String password) {
//
//        fillField(userField, password);
//        passwordField.sendKeys(password);
//        loginSubmitButton.click();
//        return this;
//
//    }
//
//    public void loginAsAtlassian(String login, String password){
//        this.enterLoginAtlassianAndClickLogin(login);
//        this.enterPasswordAtlassianAndClickLogin(password);
//
//    }
//
//    public void pressLoginButton() {
//
//        loginButton.click();
//    }
//
//    public LoginPageHelper waitErrorMessage() {
//
//       waitUntilElementIsVisible(noLoginNoPasswordError, 40);
//       return  this;
//
//    }
//    public String getErrorMessage(){
//
//        return  noLoginNoPasswordError.getText();
//    }
//
//    public LoginPageHelper enterLoginIncorrect(String login){
//
//        userField.sendKeys(login);
//        waitUntilElementIsVisible(noLoginError,30);
//        return this;
//
//    }
//    public LoginPageHelper clickLoginButton()
//    {
//        loginButton.click();
//        return this;
//    }
//    public void waitErrorMessageLoginIncorrect() {
//
//        waitUntilElementIsVisible(noLoginError,30);
//
//    }
//
//    public String getErrorMessageLoginIncorrect(){
//        System.out.println(noLoginError.getText());
//        return  noLoginError.getText();
//    }
//
//    public void enterPasswordIncorrectAndClickLogin() {
//        passwordField.sendKeys("error");
//        loginSubmitButton.click();
//        waitUntilElementIsVisible(noPasswordError,15);
//
//    }
//
//    public void waitErrorMessagePasswordIncorrect() {
//
//        waitUntilAttributValuesIs(noPasswordError, "value",
//                "Log in with Atlassian",20);
//    }
//    public String getErrorMessagePasswordIncorrect(){
//
//        return  noPasswordError.getText();
//    }
//    public LoginPageHelper enterPasswordNormal(String password){
//        fillField(passwordField, password);
//        return this;
//    }
//


}
