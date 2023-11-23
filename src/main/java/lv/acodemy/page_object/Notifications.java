package lv.acodemy.page_object;

import lv.acodemy.utils.LocalDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Notifications {

    ChromeDriver driver = LocalDriverManager.getInstance();
    WebDriver waiter;

    public Notifications(ChromeDriver driver, WebDriver wait) {
        this.driver = driver;
        this.waiter = waiter;
    }

    private final By notificationMessage = By.className("ant-notification-notice-message");

    public static WebElement getNotificationLocator() {
       return driver.findElement(notificationMessage);
    }
}
