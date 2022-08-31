import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework {
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
    public void positiveShoes(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");

        var sizeElement = driver.findElement(By.id("size"));
        var textSize = driver.findElement(By.className("subtitle"));
        var textInfo = driver.findElement(By.className("instruction-text"));
        var buttonSize = driver.findElement(By.id("check-size-button"));

    }
    @Test
    public  void negativeTestShoes(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("qwer");
        driver.findElement(By.id("check-size-button")).click();
        var expectedResult = "Введите размер обуви!";
        var actualResult =  driver.findElement(By.id("size-error")).getText();
        Assert.assertEquals("неправильный текст", expectedResult,actualResult);
    }

    @Test
    public void bookShop(){
        driver.navigate().to("http://qajava.skillbox.ru/");
        var feedback = driver.findElement(By.linkText("Обратная связь"));
        var preOrders = driver.findElement(By.linkText("Предзаказы"));
        var addBasket = driver.findElement(By.className("book-add"));
        var countCart = driver.findElement(By.id("cart_count"));
        var genresBooks = driver.findElement(By.id("genres"));
        var search = driver.findElement(By.name("search-input-form"));

    }

    @Test
    public void shopBook(){
        driver.navigate().to("http://qajava.skillbox.ru/");
        var bookInfo = driver.findElements(By.className("book-info"));
        Assert.assertEquals("неправильный текст", 15, bookInfo.size());

    }
    
    @Test

    public void onlineCinema(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys("Троя");
        driver.findElement(By.id("serials")).sendKeys("Девчонки");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var actualText = driver.findElement(By.id("best_films")).getText();
        var expectedText = "Троя";

        var actualResultText = driver.findElement(By.id("best_serials")).getText();
        var expectedResultText = "Девчонки";
        Assert.assertEquals("Неправильный текст",  expectedText, actualText);
        Assert.assertEquals("Неправильный текст",  expectedResultText, actualResultText);
    }


    @Test
    public void cinemaOnline(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys("Friends");
        driver.findElement(By.id("serials")).sendKeys("Tor");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        var checkBox =   driver.findElements(By.className("fake-checkbox"));
        Assert.assertEquals("Неправильный текст", 4, checkBox.size());
    }

    @Test
    public void clickCheckBox(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        var radioButton =  driver.findElements(By.className("fake-radiobutton"));
        Assert.assertEquals("Неправильный текст", 5, radioButton.size());
    }



}
