import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TipCalculatorTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qatipcalc.ccbp.tech/");

            WebElement billInput = driver.findElement(By.cssSelector("input[id^= 'billAmou']"));
            billInput.sendKeys("1000");

            WebElement percenInput = driver.findElement(By.cssSelector("input[id^= 'percentage']"));
            percenInput.sendKeys("12");

            WebElement calculateBtn = driver.findElement(By.cssSelector("button[id*= calculateButton]"));
            calculateBtn.click();

            List<WebElement>tipAndAmount = driver.findElements(By.cssSelector("p[class *= user-input]"));
            ArrayList<String> arryList = new ArrayList<String>();

            for (WebElement i : tipAndAmount){
                String res = i.getText();
                arryList.add(res);
            }
            String[] expectedArrayList = {"120.00","1120.00"};
            if (arryList.equals(expectedArrayList)){
                System.out.println("Tip Calculated Correctly");
            }else{
                System.out.println("Tip Calculated Incorrectly");
            }



            percenInput.clear();
            calculateBtn.click();

            WebElement errorMsg = driver.findElement(By.cssSelector("p[id*= 'errorMessage']"));
            String errorMsges = errorMsg.getText();
            String expectedErroMsg = "Please Enter a Valid Input.";
            if (expectedErroMsg.equals(errorMsges)){
                System.out.println("Error message displayed for no input");
            }else{
                System.out.println("Error message missing for no input");
            }



            percenInput.sendKeys("10f");
            calculateBtn.click();
            if (expectedErroMsg.equals(errorMsges)){
                System.out.println("Error message displayed for invalid input");
            }else{
                System.out.println("Error message missing for invalid input");
            }

            Thread.sleep(4000);
            driver.quit();

            }catch (Exception e){
            System.out.println("The Excpetion is: "+e);
        }
    }
}
