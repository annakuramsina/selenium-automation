import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import lv.acodemy.page_object.AddStudentPage;
import lv.acodemy.page_object.MainPage;
import lv.acodemy.page_object.Notifications;
import lv.acodemy.utils.LocalDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StudentAppTest {

    Faker fakeData = new Faker();
    WebDriverWait wait = new WebDriverWait(LocalDriverManager.getInstance();
    MainPage mainPage = new MainPage();
    AddStudentPage addStudentPage = new AddStudentPage();
    Notifications notifications = new Notifications(wait);

    @Test
    public void createStudentTest() {

        mainPage.openAddStudentForm();

        addStudentPage.setNameField(fakeData.name().fullName());
        addStudentPage.setEmailField(fakeData.internet().emailAddress());
        addStudentPage.setGender("female");
        addStudentPage.submitStudent();

        assertThat(notifications.getNotificationSuccessMessage()).isEqualTo("Student successfully added");
    }


    @AfterMethod
    public void tearDown() {
        LocalDriverManager.closeDriver();
    }
}