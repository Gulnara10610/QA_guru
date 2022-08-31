import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }



    @Test
    public void testHelloVasya(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        driver.findElement(By.className("start-screen__res")).getText();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResul = "Привет , Вася !";
        Assert.assertEquals(expectedResul, actualResult);


    }
    @Test
    public void testClickEnter(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResul = "Привет, !";
        Assert.assertEquals(expectedResul, actualResult);


    }
    @Test

    public void difficultSite(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResul = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResul, actualResult);

    }
    @Test
    public void positiveTest(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Настя");
        driver.findElement(By.name("email")).sendKeys("gulnara0706@yandex.ru");
        driver.findElement(By.name("phone")).sendKeys("+79818229949");
        driver.findElement(By.className("button")).click();


        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Настя.\n" +
                "На вашу почту (gulnara0706@yandex.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79818229949.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void negativeTest(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");

        driver.findElement(By.name("name")).sendKeys("2345678");
        driver.findElement(By.name("email")).sendKeys("1222222222");
        driver.findElement(By.name("phone")).sendKeys("dfghjjkk");
        driver.findElement(By.className("button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, 2345678.\n" +
                "На вашу почту (1222222222) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: dfghjjkk.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void hieroglyphsNegative(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");

        driver.findElement(By.name("name")).sendKeys("康熙字典");
        driver.findElement(By.name("email")).sendKeys("康熙字典");
        driver.findElement(By.name("phone")).sendKeys("康熙字典");

        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, 康熙字典.\n" +
                "На вашу почту (康熙字典) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 康熙字典.";

        Assert.assertEquals(expectedResult, actualResult);


    }
    @Test
    public void negativeEmail(){

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");

        driver.findElement(By.name("name")).sendKeys("ASDFVCXZ DFFFF");
        driver.findElement(By.name("email")).sendKeys("EV866_mjkjg@.lhkjk@kjhugjhk");
        driver.findElement(By.name("phone")).sendKeys("ASD45++++_)(");

        driver.findElement(By.className("button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, ASDFVCXZ DFFFF.\n" +
                "На вашу почту (EV866_mjkjg@.lhkjk@kjhugjhk) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: ASD45++++_)(.";

        Assert.assertEquals(expectedResult, actualResult);


    }








}
