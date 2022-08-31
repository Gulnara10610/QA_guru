import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cinema {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void positiveTest(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Ира");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();

        var actualResult = driver.findElement(By.className("form-header")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";

        Assert.assertEquals("Неправильный текст",expectedResult, actualResult);

    }

    @Test
    public void negativeTest(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();

        var actualResult = driver.findElement(By.className("form-error")).getText();
        var expectedResult = "Введите имя";
        Assert.assertEquals("Неправильный текст",expectedResult, actualResult);
    }

    @Test
    public void testLocators(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));
        var headerResultElement = driver.findElement(By.tagName("h3"));
        var buttonElement = driver.findElement(By.tagName("button"));
        var password = "1234";
        var email = "gulnara0706@yandex.ru";

        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);
        buttonElement.click();
        var emailResultElement = driver.findElement(By.linkText(email));
        var emailResultElement2 = driver.findElement(By.partialLinkText(email));

        Assert.assertEquals("неверный текст при успешной регистрации", "Спасибо за регистрацию !",headerResultElement.getText());
        Assert.assertEquals("неверный email при успешной регистрации", email, emailResultElement.getText());
    }






}
