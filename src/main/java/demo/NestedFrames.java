package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class NestedFrames {
    ChromeDriver driver;
    public NestedFrames()
    {
        System.out.println("Constructor: NestedFrames");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        driver.close();
        driver.quit();
    }

    
    public  void frames() throws InterruptedException{
        System.out.println("Start Test case: NestedFrames");

        // Navigate to URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Locate parent frame Using Locator "Name" name="frame-top"
        driver.switchTo().frame("frame-top");

        // Locate frame 1 Using Locator "Name" name="frame-left"
        // switch to frame 1 Using Locator "Name" switchTo().frame(name="frame-left")
        driver.switchTo().frame("frame-left");
        Thread.sleep(2000);

        // get text of frame 1  Using Locator "XPath" //*[contains(text(),'LEFT')].getText()
        WebElement frame1Text = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        System.out.println("Frame 1 text is: " + frame1Text.getText());

        // switch back to parent frame Using Locator "Name" switchTo().frame(name="frame-top")
        driver.switchTo().parentFrame();

        // Locate frame 2 Using Locator "Name" name="frame-middle"
        // switch to frame 2 Using Locator "Name" switchTo().frame(name="frame-middle")
        driver.switchTo().frame("frame-middle");
        Thread.sleep(2000);

        // get text of frame 2 Using Locator "ID" id="content".getText()
        WebElement frame2Text = driver.findElement(By.id("content"));
        System.out.println("Frame 2 text is: " + frame2Text.getText());

        // switch back to parent frame Using Locator "Name" switchTo().frame(name="frame-top")
        driver.switchTo().parentFrame();

        // Locate frame 3 Using Locator "Name" name="frame-right"
        // switch to frame 3 Using Locator "Name" switchTo().frame(name="frame-right")
        driver.switchTo().frame("frame-right");
        Thread.sleep(2000);

        // get text of frame 3 Using Locator "XPath" //*[contains(text(),"RIGHT")].getText()
        WebElement frame3Text = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        System.out.println("Frame 3 text is: " + frame3Text.getText());

        // switch back to parent frame Using Locator "Name" switchTo().frame(name="frame-top")
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        // Locate frame 4 Using Locator "Name" name="frame-bottom"
        // switch to frame 4 Using Locator "Name" switchTo().frame(name="frame-bottom")
        driver.switchTo().frame("frame-bottom");
        Thread.sleep(2000);

        // get text of frame 4 Using Locator "XPath" //*[contains(text(),"BOTTOM")].getText()
        WebElement frame4Text = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        System.out.println("Frame 4 text is: " + frame4Text.getText());

        
        System.out.println("end Test case: NestedFrames");
    }


}
