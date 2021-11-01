package com.epam.tc.hw3.tests.ex1;


import com.epam.tc.hw3.pages.Frame;
import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.pages.LoginPage;
import com.epam.tc.hw3.tests.BaseTest;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    private IndexPage indexPage;
    private String userName;
    private String password;


    @BeforeMethod
    public void navigateToIndexPage() {
        indexPage = new IndexPage(driver);
        setUserName();
        setPassword();
        setExpectedUserNameAtPage();

    }

    @AfterMethod
    public void assertAll() {
        softly.assertAll();
    }

    @Test
    public void exerciseOneTest() {

        //1. Assert that page is opened and downloaded
        indexPage.openPage();
        softly.assertThat(indexPage.getURL()).isEqualTo(url);

        //2. Assert that page title is 'Home Page'
        softly.assertThat(indexPage.getActualPageTitle()).isEqualTo(indexPage.title);

        //3. Assert that user is logged by given username and password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        softly.assertThat(loginPage.getUserNameText().isDisplayed()).isTrue();

        //4. Assert that user name is displayed and equals to expected result
        softly.assertThat(loginPage.getUserNameText().getText()).isEqualTo(expectedUserNameAtPage);

        //5. Assert that menu buttons on loginPage are displayed and have proper names
        softly.assertThat(expectedHeadersBtnsName).isEqualTo(indexPage.getHeadersBtnsText());

        //6. Assert that index page has 4 images
        softly.assertThat(indexPage.isIconsDisplayed()).isTrue();

        //7. Assert that texts under icons have proper text
        softly.assertThat(indexPage.getActualTextUnderIcons()).isEqualTo(expectedTextUnderIcons);

        //8. Assert that iframe with "Frame Button" exists
        softly.assertThat(indexPage.getIframe().isEnabled()).isTrue();

        //9. Assert that "Frame Button" in frame exists
        String indexPageHandle = indexPage.getWindowHandle();
        Frame frame = indexPage.switchTo(indexPage.getIframe());
        softly.assertThat(frame.getFrameButton().isEnabled()).isTrue();

        //10. Assert that driver switched to original window
        driver.switchTo().window(indexPageHandle);
        softly.assertThat(driver.getWindowHandle()).isEqualTo(indexPageHandle);

        //11. Assert that left sidebar menu has 5 items and they have proper names
        softly.assertThat(indexPage.getActualNavigationSidebarText()).isEqualTo(expectedNavigationSidebarText);

        //12. Assert that browser is closed
        driver.close();
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");
    }
}
