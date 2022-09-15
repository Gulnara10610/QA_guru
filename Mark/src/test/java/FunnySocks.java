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

public class FunnySocks {
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
    public void testSocks() {
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


    private By inputEmail = By.cssSelector("[important ='']");
    private By inputPassword = By.cssSelector("[required='true']");
    private By clickButton = By.cssSelector("button#submit.form-submit");
    private By errorMessage = By.cssSelector("pre#error.form-error-password-email");

    private By headerWords = By.cssSelector("[for = 'main-header-page']");

    private By hrefMailto = By.cssSelector("a[href^='mailto']");

    private By header = By.cssSelector("[class$='header']");
    private By classEntrance = By.cssSelector("h3[class*='title']");


    @Test
    public void testByLocator() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(inputEmail).sendKeys("@");
        driver.findElement(inputPassword).sendKeys("123");
        driver.findElement(clickButton).click();
        Assert.assertTrue("Неправильно указан текст", driver.findElement(errorMessage).isDisplayed());
        Assert.assertEquals("Некорректный email или пароль", driver.findElement(errorMessage).getText());
    }


    private By aboutShop = By.cssSelector("[test-info='about-us']");
    private By emptyHref = By.cssSelector("a[href='']");

    private By bookPrice = By.cssSelector("div.book-price");
    private By book = By.cssSelector("button[class^='book']");
    private By endMain = By.cssSelector("[class$='main']");
    private By classMenu = By.cssSelector("a[class*='menu']");

    @Test
    public void booksShop() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(aboutShop);
        driver.findElement(emptyHref);

        driver.findElement(bookPrice);
        driver.findElement(book);
        driver.findElement(endMain);
        driver.findElement(classMenu);
    }


    private By footerId = By.cssSelector("footer[id='footer'] > div");
    private By liGenres = By.cssSelector("li[id='genres'] +* ");

    @Test
    public void positiveBookShop() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(footerId);
        driver.findElement(liGenres);

    }

    private By filterContainer = By.cssSelector("div.filter-container > span ~*");
    private By selected = By.cssSelector("[selected='']");

    @Test
    public void searchBook() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        driver.findElement(filterContainer);
        driver.findElement(selected);
    }



    @Test
    public void testBookShop() {
        var h1First = By.cssSelector("section[for='main-header-page'] > h1:first-child");
        var pLast = By.cssSelector("form.form[id=login-form] > p:last-child");
        var child3 = By.cssSelector("body > *:nth-child(3)");
        var  menuList = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");
        var  fiveTask = By.cssSelector("div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)"); // находит все элементы ?

        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(h1First);
        driver.findElement(pLast);
        driver.findElement(child3);
        driver.findElement(menuList);
        driver.findElement(fiveTask);
    }


    @Test
    public void dailyTest() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var buttonPlus = By.cssSelector("button.pageCreate__sidebarHeaderAdd > svg:nth-of-type(1)");
        driver.findElement(buttonPlus).click();
        var lightBox = By.cssSelector("div.popup");
        wait.until(ExpectedConditions.presenceOfElementLocated(lightBox));
        driver.findElement(lightBox);
        var baseInput = By.cssSelector("div.baseInput.popup__baseInput > input:first-child");
        driver.findElement(baseInput).sendKeys("заголовок новой записи");
        var textarea = By.cssSelector("div.baseTextarea.popup__textarea textarea.baseTextarea__text");
        driver.findElement(textarea).sendKeys("текст новой записи");
        var addButton = By.cssSelector("div.popup__content button.baseButton.popup__baseButton");
        driver.findElement(addButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lightBox));
        var text1 = By.cssSelector("div.articlePreview.pageCreate__articlePreview:nth-child(1) > div.articlePreview__content > *:nth-child(2)");

        Assert.assertEquals("заголовок новой записи", driver.findElement(text1).getText());
        var textText = By.cssSelector("div.articlePreview.pageCreate__articlePreview:nth-child(1) > div.articlePreview__content > *:nth-child(3)");
        Assert.assertEquals("текст новой записи", driver.findElement(textText).getText());


    }

    @Test
    public void homeWorkLocator() {
        var locatorHomeWork = By.cssSelector("section.header p");
        var locatorHomeWorkP = By.cssSelector("div.mainText.text a");
        var locatorA = By.cssSelector("div.text a");
        var testLocatorHref = By.cssSelector("div.text a");


    }

    @Test
    public void testSecond() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        var secondTask = By.cssSelector("input[type='text']:not([id])");
        driver.findElement(secondTask);
        var errorLocator = By.cssSelector("p[class^='form']:not([class$='error'])");
        driver.findElement(errorLocator);
        var locatorForm = By.cssSelector("div.form-inner > form.form > p:nth-of-type(1)");
        driver.findElement(locatorForm);
    }

    @Test
    public void taskThird() {
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        var buttonLink = By.cssSelector("div.articlePreview.pageStatistic__article:nth-of-type(1) > button.articlePreview__link");
        driver.findElement(buttonLink).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        var allTexts = By.cssSelector("div.pageArticle__sidebarHeader.pageArticle__sidebarWrapper");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allTexts));

        Assert.assertEquals("Неправильный текст", "Все записи", driver.findElement(allTexts).getText());
        var basketClick = By.cssSelector("button.pageArticle__button:nth-of-type(2) > svg.pageArticle__icon");
        driver.findElement(basketClick).click();
        var firstText = By.cssSelector("div.articlePreview.pageArticle__articlePreview:nth-of-type(1) button.articlePreview__link");
        driver.findElement(firstText).click();
        driver.findElement(basketClick).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(firstText));


    }


    @Test
    public void onlineFeature() {
        driver.navigate().to("http://qa.skillbox.ru/module19/");
        var arrowsLeft = By.xpath("//span[@class='da-arrows-prev']");
        driver.findElement(arrowsLeft);

        var learnMore = By.xpath("//a[@class='da-link button']");
        driver.findElement(learnMore);

        var startsButton = By.xpath("//*[starts-with(@class,'butt')]");
        driver.findElement(startsButton);

        var writeToUs = By.xpath("(//a[@class='button'])[1]");
        driver.findElement(writeToUs);

        var photos = By.xpath("//div[@class='bx-viewport']");
        driver.findElement(photos);


        var pro = By.xpath("//div[@class='price-table row-fluid']//div[2]");
        driver.findElement(pro);

        var premium = By.xpath("//div[@class='price-table row-fluid']//div[2]");
        driver.findElement(premium);

    }
    @Test
    public void courses() {

        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        var theFiveCard = By.xpath("(//div[@class='baseCard__wrapper'])[5]");
        driver.findElement(theFiveCard);

        var theLastCard = By.xpath("(//div[@class='baseCard__conditions'])[last()]//p[text()='7 месяцев']");
        driver.findElement(theLastCard);

        var href = By.xpath("//*[@href='#']/parent::div");
        driver.findElement(href);

        var divNumberFive = By.xpath("(//*[@href='#']/parent::div)[5]");
        driver.findElement(divNumberFive);

        var allCourses = By.xpath("//*[@class='pageCreate__title']/ancestor::*");
        driver.findElement(allCourses);
    }
    @Test
    public void bookShopOnline(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        var aboutShop = By.xpath("//a[@test-info='about-us']");
        driver.findElement(aboutShop);

        var bestSellers = By.xpath("(//*[text()='Бестселлеры'])[2]");
        driver.findElement(bestSellers);

        var searchRaw = By.xpath("//input[@id='search-input']");
        driver.findElement(searchRaw);








    }
    @Test
    public void basket(){
        driver.navigate().to("http://qajava.skillbox.ru/checkout.html");
        var total = By.xpath("//div[@class='order-info']/div[1]");
        driver.findElement(total);

        var yourOrder = By.xpath("//div[@id='order-info']//div[1]");
        driver.findElement(yourOrder);


    }
    @Test
    public void searchPage(){
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        var buttonChange = By.xpath("//button[@class='filter-button']");
        driver.findElement(buttonChange);
    }
}












