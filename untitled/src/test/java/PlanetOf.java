import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PlanetOf {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws IOException {
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        driver.quit();
    }

    @Test
    public void premiumBuyMonth(){
        driver.navigate().to("https://planetofloves.com/");
        var logIn = By.xpath("//button[@class='main-header__button button login-button']");
        driver.findElement(logIn).click();
        var popupLogIn = By.cssSelector("button.main-header__button.button.login-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(popupLogIn));

        var inputEmail = By.cssSelector("label.form-input.form-input--login:nth-of-type(1) input.form-field");
        driver.findElement(inputEmail).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var inputPassword = By.cssSelector("label.form-input.form-input--login:nth-of-type(2) input.form-field");
        driver.findElement(inputPassword).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var logInButton = By.cssSelector("button.popup__button.button");
        driver.findElement(logInButton).click();

        var premiumFooter = By.cssSelector("div.menu > a:nth-of-type(4)");
        driver.findElement(premiumFooter).click();

        var premiumOneMonth = By.xpath("//div[@data-premium='13']");
        driver.findElement(premiumOneMonth).click();

        var checkBox = By.xpath("//input[@id='accept']");
        driver.findElement(checkBox).click();

        var buttonBuy = By.xpath("//div[@id='pay-btn']");
        driver.findElement(buttonBuy).click();

        var pageOfMoney = By.xpath("//span[@class='money_amount']");
        Assert.assertEquals("неправильная стоимость", "35.00", driver.findElement(pageOfMoney).getText());
    }

    @Test
    public void premiumBuyThreeMonths() {
        driver.navigate().to("https://planetofloves.com/");
        var logIn = By.xpath("//button[@class='main-header__button button login-button']");
        driver.findElement(logIn).click();
        var popupLogIn = By.cssSelector("button.main-header__button.button.login-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(popupLogIn));

        var inputEmail = By.cssSelector("label.form-input.form-input--login:nth-of-type(1) input.form-field");
        driver.findElement(inputEmail).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var inputPassword = By.cssSelector("label.form-input.form-input--login:nth-of-type(2) input.form-field");
        driver.findElement(inputPassword).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var logInButton = By.cssSelector("button.popup__button.button");
        driver.findElement(logInButton).click();

        var premiumLeft = By.xpath("(//a[@class='premium__button button'])[1]");
        driver.findElement(premiumLeft).click();

        var premiumFreeMonths = By.xpath("//div[@data-premium='12']");
        driver.findElement(premiumFreeMonths).click();

        var checkBox = By.xpath("//input[@id='accept']");
        driver.findElement(checkBox).click();

        var buttonBuy = By.xpath("//div[@id='pay-btn']");
        driver.findElement(buttonBuy).click();

        var pageOfMoney = By.xpath("//span[@class='money_amount']");
        Assert.assertEquals("неправильная стоимость", "65.00", driver.findElement(pageOfMoney).getText());


    }

    @Test
    public void premiumBuySixMonths() {
        driver.navigate().to("https://planetofloves.com/");
        var logIn = By.xpath("//button[@class='main-header__button button login-button']");
        driver.findElement(logIn).click();
        var popupLogIn = By.cssSelector("button.main-header__button.button.login-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(popupLogIn));

        var inputEmail = By.cssSelector("label.form-input.form-input--login:nth-of-type(1) input.form-field");
        driver.findElement(inputEmail).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var inputPassword = By.cssSelector("label.form-input.form-input--login:nth-of-type(2) input.form-field");
        driver.findElement(inputPassword).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var logInButton = By.cssSelector("button.popup__button.button");
        driver.findElement(logInButton).click();

        var premiumUnderName = By.xpath("//a[@class='user__novip']");
        driver.findElement(premiumUnderName).click();

        var premiumSixMonths = By.xpath("//div[@data-premium='14']");
        driver.findElement(premiumSixMonths).click();

        var checkBox = By.xpath("//input[@id='accept']");
        driver.findElement(checkBox).click();

        var buttonBuy = By.xpath("//div[@id='pay-btn']");
        driver.findElement(buttonBuy).click();

        var pageOfMoney = By.xpath("//span[@class='money_amount']");
        Assert.assertEquals("неправильная стоимость", "100.00", driver.findElement(pageOfMoney).getText());


    }


    @Test
    public void sendARealGiftAtCredits(){
        driver.navigate().to("https://planetofloves.com/");
        var logIn = By.xpath("//button[@class='main-header__button button login-button']");
        driver.findElement(logIn).click();
        var popupLogIn = By.cssSelector("button.main-header__button.button.login-button");

        wait.until(ExpectedConditions.presenceOfElementLocated(popupLogIn));

        var inputEmail = By.cssSelector("label.form-input.form-input--login:nth-of-type(1) input.form-field");
        driver.findElement(inputEmail).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var inputPassword = By.cssSelector("label.form-input.form-input--login:nth-of-type(2) input.form-field");
        driver.findElement(inputPassword).sendKeys("cfsdffsdgdfgs@dfgh.ru");

        var dialogs = By.xpath("//span[@data-svg='message']");
        driver.findElement(dialogs).click();

        var firstDialog = By.xpath("//div[@class='chat__list--item active']");
        driver.findElement(firstDialog).click();

        var imgRealGift = By.xpath("//a[@class='chat__user--but real-gift tooltipstered svgEl']");
        driver.findElement(imgRealGift).click();



        var firstElement = By.xpath("//div[@data-gift-id='61e69367632ba8010d4d1597']");
        driver.findElement(firstElement).click();






    }



}
