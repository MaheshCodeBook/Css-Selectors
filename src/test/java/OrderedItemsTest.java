import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderedItemsTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qaorderitems.ccbp.tech/");

            List<WebElement> orderList = driver.findElements(By.cssSelector("li.ordered-item"));
            int count = orderList.size();
            int expectedCount = 3;
            if (count == expectedCount){
                System.out.println("Ordered Item count is correct");
            }else {
                System.out.println("Ordered Item count is incorrect");
            }

            WebElement cancel1 = driver.findElement(By.cssSelector("button#button1"));
            cancel1.click();

            WebElement cancel2 = driver.findElement(By.cssSelector("button#button2"));
            cancel2.click();

            WebElement cancel3 = driver.findElement(By.cssSelector("button#button3"));
            cancel3.click();

            WebElement emptyCart = driver.findElement(By.cssSelector(" p.text-secondary"));
            String emptyText = emptyCart.getText();
            String expectedText = "Cart is empty";

            if (emptyText.equals(expectedText)){
                System.out.println("Empty Cart Text Displayed");
            }else {
                System.out.println("Empty Cart Text Missing");
            }

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is : "+e);
        }
    }
}
