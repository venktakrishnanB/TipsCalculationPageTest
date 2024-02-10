import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TipCalculationPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qatipcalc.ccbp.tech/");

        WebElement BillAmount = driver.findElement(By.cssSelector("input[id ^= bill]"));
        BillAmount.sendKeys("1000");

        WebElement tipPercentage = driver.findElement(By.cssSelector("input[id ^= percent]"));
        tipPercentage.sendKeys("12");

        WebElement calculateButton = driver.findElement(By.cssSelector("button[id *= calculate]"));
        calculateButton.click();

        WebElement tipAmount = driver.findElement(By.cssSelector("p[id *= tip]"));
        WebElement totalAmount = driver.findElement(By.cssSelector("p[id *= total]"));

        if(tipAmount.getText().equals("120.00") && totalAmount.getText().equals("1120.00")){
            System.out.println("Tip Calculated Correctly");
        }else{
            System.out.println("Tip Calculated Incorrectly");
        }

        tipPercentage.clear();

        calculateButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("p[id *= error]"));

        if(errorMessage.getText().equals("Please Enter a Valid Input.")){
            System.out.println("Error message displayed for no input");
        }else{
            System.out.println("Error message missing for no input");
        }

        tipPercentage.sendKeys("10f");

        calculateButton.click();

        if(errorMessage.getText().equals("Please Enter a Valid Input.")){
            System.out.println("Error message displayed for invalid input");
        }else{
            System.out.println("Error message missing for invalid input");
        }

        driver.quit();
    }
}
