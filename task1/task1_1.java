package task1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class task1_1 {

    public static void main(String[] arg) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("rozetka ua\n");
        element.submit();

        WebElement findElements = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        String link = findElements.get(0).getAttribute("href");
        driver.navigate().to(link);

        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("termos\n");
        search.submit();

        Thread.sleep(2000);

        link = driver.findElements(By.className("goods-title__inner")).get(0).getAttribute("href");
        driver.navigate().to(link);

        Thread.sleep(2000);

        driver.findElement(By.className("buy-button button button--with-icon button--green button--medium ng-star-inserted")).click();

    }

}
