import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SkillsPageTest {
    public static void main(String[]args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qamarkskills.ccbp.tech/");

            WebElement box1 = driver.findElement(By.cssSelector("input[id *= 'checkbox1']"));
            box1.click();

            WebElement label1 = driver.findElement(By.cssSelector("label[for $= 'box1']"));
            String res1 = label1.getText();
            System.out.println("Selected: "+"<"+res1+">");

            WebElement box2 = driver.findElement(By.cssSelector("input[id *= 'checkbox2']"));
            box2.click();

            WebElement label2 = driver.findElement(By.cssSelector("label[for $= 'box2']"));
            String res2 = label2.getText();
            System.out.println("Selected: "+"<"+res2+">");

            WebElement box3 = driver.findElement(By.cssSelector("input[id *= 'checkbox3']"));
            box3.click();

            WebElement label3 = driver.findElement(By.cssSelector("label[for $= 'box3']"));
            String res3 = label3.getText();
            System.out.println("Selected: "+"<"+res3+">");

            Thread.sleep(4000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
