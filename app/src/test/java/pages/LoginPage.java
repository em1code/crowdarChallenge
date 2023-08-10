package pages;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    private String url = "https://www.saucedemo.com/",
            titlePage = "//div[@class='login_logo']",
            usernameField = "//input[@id='user-name']",
            passwordField = "//input[@id='password']",
            loginButton = "//*[@id='login-button']",
            errorMessage ="//h3[@data-test='error']";

    public void navigateToLoginPage() {
        navigateTo(url);
    }

    public String getTextFromTitle(){
        return textFromElement(titlePage);
    }

    public void completeUsernameField(String valueToSend) {
        write(usernameField, valueToSend);
    }

    public void completePasswordField(String valueToSend) {
        write(passwordField, valueToSend);
    }

    public void clickOnLoginButton(){
        clickElement(loginButton);
    }

    public String validateErrorMessage(){
        return textFromElement(errorMessage);
    }

    public long getPageLoadTime(){
        long startTime = System.currentTimeMillis();
        BasePage.waitUntilPageLoaded(driver);
        long endTime = System.currentTimeMillis();
        long pageLoadTime = endTime - startTime;
        System.out.println("Start time: " + startTime);        
        System.out.println("End time: " + endTime);
        System.out.println("Load time: " + pageLoadTime);
        return pageLoadTime;
    }

}
