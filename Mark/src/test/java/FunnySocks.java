import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunnySocks {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver =  new ChromeDriver();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testSocks(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        var inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("@");
        var inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys("123");
        var inputButton = driver.findElement(By.tagName("button"));
        inputButton.click();
        var errorClick = By.className("form-error-password-email");


        Assert.assertTrue("Неправильно указан текст", driver.findElement(errorClick).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", driver.findElement(errorClick).getText());


    }


    private By inputEmail = By.cssSelector(".form-input.input-data");
    private By inputPassword = By.cssSelector("input#password.form-input.password");
    private By clickButton = By.cssSelector("button#submit.form-submit");
    private  By errorMessage = By.cssSelector(" pre#error.form-error-password-email");



    @Test
    public void testByLocator(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(inputEmail).sendKeys("@");
        driver.findElement(inputPassword).sendKeys("123");
        driver.findElement(clickButton).click();
        Assert.assertTrue("Неправильно указан текст", driver.findElement(errorMessage).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage).getText());




    }





}

