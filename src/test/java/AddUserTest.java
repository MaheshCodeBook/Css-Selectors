import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddUserTest {
    public static void main(String[] args){
     try {
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://qausersignup.ccbp.tech/");

         WebElement nameInput = driver.findElement(By.cssSelector("input#name"));
         nameInput.sendKeys("rahul");
         WebElement emailInput = driver.findElement(By.cssSelector("input#email"));
         emailInput.sendKeys("rahul@example.com");

         WebElement submitButton = driver.findElement(By.cssSelector(" button[id *= 'submit-button']"));
         submitButton.click();

         WebElement addUserConfirm = driver.findElement(By.cssSelector("p[class ^= 'success-message']"));
         String successMsg = addUserConfirm.getText();
         String expectedMsg = "New user added successfully!";

         if (successMsg.equals(expectedMsg)){
             System.out.println("New user added successfully!");
         }else {
             System.out.println("Success Message Missing");
         }

         WebElement clearAddUser = driver.findElement(By.cssSelector("span[class ^= 'cancel-button']"));
         clearAddUser.click();

         submitButton.click();
         WebElement errorMsgEle = driver.findElement(By.cssSelector("p[class ^= 'error-messa']"));
         String errorMsg = errorMsgEle.getText();
         String expectedErrormsg = "Required*";
         if (errorMsg.equals(expectedErrormsg)){
             System.out.println("Errors displayed correctly");
         }else {
             System.out.println("Errors not displayed correctly");

         }












         Thread.sleep(4000);
         driver.quit();
     }catch (Exception e){
         System.out.println("The Exception is: "+e);
     }
    }
}
