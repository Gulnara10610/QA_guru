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
    private By emailLocator = By.className("email");
    private By writeToMeLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("notification-email");
    @Test
    public void testKitten(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        var resultEmailElement = driver.findElement(By.className("notification-email"));
        Assert.assertTrue("Не отобразился текст ", driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Не отобразился текст ", email, resultEmailElement.getText());

    }

    @Test
    public void testKittensEmptyEmail(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/changed.html");
        driver.findElement(writeToMeLocator).click();

        Assert.assertEquals("Не отобразился текст ", "", driver.findElement(resultEmailLocator).getText());
    }

    private By radioButtonBoy = By.id("boy");
    private By radioButtonGirl = By.id("girl");
    private By inputEmail = By.name("email");
    private By button = By.id("sendMe");
    private By resultText = By.className("your-email");
    private By anotherEmail = By.id("anotherEmail");

    @Test
    public void testDogName() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(radioButtonBoy).click();
        var email = "testing@test.ru";
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(button).click();
        Assert.assertTrue("не отображается текст", driver.findElement(resultText).isDisplayed());
        Assert.assertEquals("неправильный текст", email, driver.findElement(resultText).getText());
    }
    @Test
    public void testDogAnotherEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(radioButtonGirl).click();
        var email2 ="Admin";
        driver.findElement(inputEmail).sendKeys(email2);
        driver.findElement(button).click();
        Assert.assertEquals("не отображается емаил", email2, driver.findElement(resultText).getText());


    }


    @Test
    public void testFeedBack(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var nameLocator = By.cssSelector(".data.text");
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");
        driver.findElement(nameLocator).sendKeys("Ivan");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("не отобразился текст", driver.findElement(messageLocator).isDisplayed());
    }
    @Test
    public void testFeedBackEmail(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var inputEmailLocator = By.cssSelector(".data.field");
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");
        driver.findElement(inputEmailLocator).sendKeys("qwert@test.ru");
        var textFieldLocator = By.cssSelector(".field.text");
        driver.findElement(textFieldLocator).sendKeys("something");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("не указана почта", driver.findElement(messageLocator).isDisplayed());

    }


    @Test
    public void testHomeWork(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var inputName = By.cssSelector(".form-input.fio");
        var inputStreet = By.cssSelector(".data.form-input.street");
        var inputHouse = By.cssSelector(".form-input.house");
        var inputFlat = By.cssSelector(".form-input.flat");
        var inputDate = By.cssSelector(".form-input.date");
        var buttonCallMaster = By.cssSelector(".form-submit");

        }
}






