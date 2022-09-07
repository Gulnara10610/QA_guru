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


    private By inputEmail = By.cssSelector("[important ='']");
    private By inputPassword = By.cssSelector("[required='true']");
    private By clickButton = By.cssSelector("button#submit.form-submit");
    private  By errorMessage = By.cssSelector("pre#error.form-error-password-email");

    private By headerWords = By.cssSelector("[for = 'main-header-page']");

    private  By hrefMailto = By.cssSelector("a[href^='mailto']");

    private By header = By.cssSelector("[class$='header']");
    private By classEntrance = By.cssSelector("h3[class*='title']");






    @Test
    public void testByLocator(){
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
    public void booksShop(){
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
    public void positiveBookShop(){
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(footerId);
        driver.findElement(liGenres);

    }

    private By filterContainer = By.cssSelector("div.filter-container > span ~*");
    private By selected = By.cssSelector("[selected='']");
    @Test
    public void searchBook(){
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        driver.findElement(filterContainer);
        driver.findElement(selected);
    }




    private By h1First = By.cssSelector("section[for='main-header-page'] > h1:first-child");
    private By pLast = By.cssSelector("form.form[id=login-form] > p:last-child");
    private By child3 = By.cssSelector("body > *:nth-child(3)");
    private By menuList = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");
    private By fiveTask = By.cssSelector("div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)"); // находит все элементы ?
    @Test
    public void testBookShop(){
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(h1First);
        driver.findElement(pLast);
        driver.findElement(child3);
        driver.findElement(menuList);
        driver.findElement(fiveTask);
    }





}

