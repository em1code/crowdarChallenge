package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


// @author emiliano.molina

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Documents\\BaseAutomationFramework");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * This method navigate to a given URL
     * 
     * @param url {@code String} URL
     */
    public static void navigateTo(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could NOT navigate to: " + url);
        }
    }

    /**
     * This method close the browser window
     */
    public static void closeBrowser() {
        driver.quit();
    }

    /**
     * This method maximize the window
     */
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * This method will search an web element till 10 seconds.
     * If found return the element, else return TimeoutException
     * 
     * 
     * @param locator {@code String} WebElement locator
     * @return {@code WebElement} webElement
     * @throws TimeoutException Throws TimeoutException if:
     *                          <ul>
     *                          <li>the function returns neither null nor false</li>
     *                          <li>the function throws an unignored exception</li>
     *                          <li>the timeout expires</li>
     *                          <li>the current thread is interrupted
     *                          <ul>
     */
    private WebElement find(String locator) throws TimeoutException {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Could NOT verify if the WebElement -> " + locator + " is visible");
            throw e;
        }
    }

    /**
     * This method click on a given web element
     * 
     * @param locator {@code String} locator of the web element
     * @throws StaleElementReferenceException If the element no longer exists as
     *                                        initially defined
     */
    public void clickElement(String locator) throws StaleElementReferenceException {
        try {
            find(locator).click();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            System.out.println("Could NOT click on WebElement -> " + locator);
            throw e;
        }
    }

    /**
     * This method write on an Input text field
     * 
     * @param locator     {@code String} Locator of the input web element
     * @param textToWrite {@code String} text to write on the given element
     * @throws IllegalArgumentException if keysToSend is null
     */
    public void write(String locator, String textToWrite) throws IllegalArgumentException {
        try {
            find(locator).clear();
            find(locator).sendKeys(textToWrite);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Could NOT send keys to WebElement -> " + locator + " becouse keys is: " + textToWrite);
            throw e;
        }
    }

    /**
     * This method select a dropdown option by value
     * 
     * @param locator       {@code String} Locator of the dropdown
     * @param valueToSelect {@code String} Option to be selected
     * @throws NoSuchElementException If no matching option elements are found
     */
    public void selectFromDropdownByValue(String locator, String valueToSelect)
            throws NoSuchElementException {
        try {
            Select dropdown = new Select(find(locator));
            dropdown.selectByValue(valueToSelect);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(
                    "Could NOT select option: " + valueToSelect + " becouse was not found in WebElement -> " + locator);
            throw e;
        }
    }

    /**
     * This method select a dropdown option by text
     * 
     * @param locator       {@code String} Locator of the dropdown
     * @param valueToSelect {@code String} Option to be selected
     * @throws NoSuchElementException If no matching option elements are found
     */
    public void selectFromDropdownByText(String locator, String valueToSelect)
            throws NoSuchElementException {
        try {
            Select dropdown = new Select(find(locator));
            dropdown.selectByVisibleText(valueToSelect);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(
                    "Could NOT select option: " + valueToSelect + " becouse was not found in WebElement -> " + locator);
            throw e;
        }

    }

    /**
     * This method select a dropdown option by index
     * 
     * @param locator       {@code String} Locator of the dropdown
     * @param indexToSelect {@code Integer} Option to be selected
     * @throws NoSuchElementException If no matching option elements are found
     */
    public void selectFromDropdownByIndex(String locator, int indexToSelect)
            throws NoSuchElementException {
        try {
            Select dropdown = new Select(find(locator));
            dropdown.selectByIndex(indexToSelect);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(
                    "Could NOT select option: " + indexToSelect + " becouse was not found in WebElement -> " + locator);
            throw e;
        }
    }

    /**
     * This method perform a Hover over action on a given web element
     * 
     * @param locator {@code String} locator of the web element
     */
    public void hoverHover(String locator) {
        try {
            action.moveToElement(find(locator));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could NOT perform move to WebElement -> " + locator);
        }
    }

    /**
     * This method perform a double click on a given web element
     * 
     * @param locator {@code String} locator of the web element
     */
    public void doubleClick(String locator) {
        try {
            action.doubleClick(find(locator));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could NOT double click on WebElement -> " + locator);
        }
    }

    /**
     * This method perform a right click on a given web element
     * 
     * @param locator {@code String} locator of the web element
     */
    public void rightClick(String locator) {
        try {
            action.contextClick(find(locator));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("right click on WebElement -> " + locator);
        }
    }

    /**
     * This method return the value matched of a given table row and column
     * 
     * @param locator {@code String} locator of the web element
     * @param row     {@code Integer} row
     * @param column  {@code Integer} column
     * @return
     */
    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        return find(cellINeed).getText();
    }

    /**
     * This method set a given value on a given table row and column
     * 
     * @param locator     {@code String} locator of the web element
     * @param row         {@code Integer} row
     * @param column      {@code Integer} column
     * @param valueToSend {@code String} Value to send
     */
    public void setValueOnTable(String locator, int row, int column, String valueToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        find(cellToFill).sendKeys(valueToSend);
    }

    /**
     * This method switch to given Frame
     * 
     * @param iframeIndex {@code Integer} Frame index
     * @throws TimeoutException Throws TimeoutException if:
     *                          <ul>
     *                          <li>the function returns neither null nor false</li>
     *                          <li>the function throws an unignored exception</li>
     *                          <li>the timeout expires</li>
     *                          <li>the current thread is interrupted
     *                          <ul>
     */
    public void switchToiFrame(int iframeIndex) throws TimeoutException {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeIndex));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Could NOT switch to Frame -> " + iframeIndex);
            throw e;
        }
    }

    /**
     * This method switch to given Frame
     * 
     * @param iFrame {@code String} Frame index
     * @throws TimeoutException Throws TimeoutException if:
     *                          <ul>
     *                          <li>the function returns neither null nor false</li>
     *                          <li>the function throws an unignored exception</li>
     *                          <li>the timeout expires</li>
     *                          <li>the current thread is interrupted
     *                          <ul>
     */
    public void switchToiFrame(String iFrame) throws TimeoutException {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Could NOT switch to Frame -> " + iFrame);
            throw e;
        }
    }

    /**
     * This method switch to parent frame
     */
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    /**
     * This method dismiss alert window
     * 
     * @throws TimeoutException Throws TimeoutException if:
     *                          <ul>
     *                          <li>the function returns neither null nor false</li>
     *                          <li>the function throws an unignored exception</li>
     *                          <li>the timeout expires</li>
     *                          <li>the current thread is interrupted
     *                          <ul>
     */
    public void dismissAlert() throws TimeoutException {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (TimeoutException e) {
            System.out.println("Could NOT dismiss alert becouse alert is not present");
            throw e;
        }
    }

    /**
     * This method accept alert window
     * 
     * @throws TimeoutException Throws TimeoutException if:
     *                          <ul>
     *                          <li>the function returns neither null nor false</li>
     *                          <li>the function throws an unignored exception</li>
     *                          <li>the timeout expires</li>
     *                          <li>the current thread is interrupted
     *                          <ul>
     */
    public void acceptAlert() throws TimeoutException {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("accept alert becouse alert is not present");
            throw e;
        }
    }

    /**
     * This method return text from alert
     * 
     * @return
     * @throws TimeoutException Throws TimeoutException if:
     *                          <ul>
     *                          <li>the function returns neither null nor false</li>
     *                          <li>the function throws an unignored exception</li>
     *                          <li>the timeout expires</li>
     *                          <li>the current thread is interrupted
     *                          <ul>
     */
    public String getAlertMessage() throws TimeoutException {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert().getText();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get alert message becouse alert is not present");
            throw e;
        }
    }

    /**
     * This method return a text from web element
     * 
     * @param locator {@code String} Locator of the web element
     * @return
     */
    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    /**
     * This method return the attribute's value of a given web element
     * 
     * @param locator   {@code String} Locator of the web element
     * @param attribute {@code String} Attribute of which we want its value
     * @return
     */
    public String getAttributeFromElement(String locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }

    /**
     * This method verify if element is enabled
     * 
     * @param locator {@code String} Locator of the web element
     * @return TRUE if the element is enabled, else return FALSE
     */
    public Boolean elementEnabled(String locator) {
        return find(locator).isEnabled();
    }

    /**
     * This method verify if element is displayed
     * 
     * @param locator {@code String} Locator of the web element
     * @return TRUE if the element is displayed, else return FALSE
     */
    public Boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    /**
     * This method verify if element is selected
     * 
     * @param locator {@code String} Locator of the web element
     * @return TRUE if the element is selected, else return FALSE
     */
    public Boolean elementIsSelected(String locator) {
        return find(locator).isSelected();
    }

    /**
     * This method return a list of web elements
     * 
     * @param locator {@code String} Locator of the web elements
     * @return
     */
    public List<WebElement> getAllElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    /**
     * This method return a list with the webElement's values
     * 
     * @param locator
     * @return
     */
    public List<String> getOptionsFromList(String locator) {
        List<WebElement> wElementList = getAllElements(locator);
        List<String> options = new ArrayList<String>();

        for (WebElement e : wElementList) {
            options.add(e.getText());
        }
        return options;
    }

    public static void waitUntilPageLoaded(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("return document.readyState").equals("complete");
    }
}
