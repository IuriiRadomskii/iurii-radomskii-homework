package com.epam.tc.hw3.tests.ex1;

import com.epam.tc.hw3.pages.Frame;
import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.tests.BaseTest;
import com.epam.tc.hw3.tests.data.Expected;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

public class ExerciseOneTest extends BaseTest {

    @Test
    public void exerciseOneTest() {

        //1. Assert that page is opened and downloaded
        indexPage.openPage(Expected.indexURL);
        softly.assertThat(indexPage.getCurrentURL()).isEqualTo(Expected.indexURL);

        //2. Assert that page title is 'Home Page'
        softly.assertThat(indexPage.getTitle()).isEqualTo(Expected.indexTitle);

        //3. Assert that user is logged by given username and password
        indexPage.login(userName, password);
        softly.assertThat(indexPage.getUserNameText().isDisplayed()).isTrue();

        //4. Assert that user name is displayed and equals to expected result
        softly.assertThat(indexPage.getActualUserNameAtPage()).isEqualTo(Expected.userNameAtPage);

        //5. Assert that menu buttons on loginPage are displayed and have proper names
        softly.assertThat(indexPage.getHeadersBtnsName()).isEqualTo(Expected.headersBtnsName);

        //6. Assert that index page has 4 images
        softly.assertThat(indexPage.isIconsDisplayed()).isTrue();

        //7. Assert that texts under icons have proper text
        softly.assertThat(indexPage.getActualTextUnderIcons()).isEqualTo(Expected.textUnderIcons);

        //8. Assert that iframe with "Frame Button" exists
        softly.assertThat(indexPage.getIframe().isEnabled()).isTrue();

        //9. Assert that "Frame Button" in frame exists
        Frame frame = indexPage.switchToFrame(indexPage.getIframe());
        softly.assertThat(frame.getFrameButton().isEnabled()).isTrue();

        //10. Assert that driver switched to original window
        indexPage = (IndexPage) frame.switchBackTo();
        softly.assertThat(driver.getWindowHandle()).isEqualTo(indexPage.getHandle());

        //11. Assert that left sidebar menu has 5 items and they have proper names
        softly.assertThat(indexPage.getActualNavigationSidebarText()).isEqualTo(Expected.navigationSidebarText);

        //12. Assert that browser is closed
        driver.close();
        softly.assertThatThrownBy(() -> driver.getWindowHandle())
              .isInstanceOf(NoSuchSessionException.class)
              .hasMessageContaining("invalid session id");
        softly.assertAll();
    }
}
