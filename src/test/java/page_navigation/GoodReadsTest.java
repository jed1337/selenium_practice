package page_navigation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class GoodReadsTest {
    private static final String BOOK_TITLE = "Meditations Marcus Aurelius";

    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/browser_drivers/chromedriver.exe");

        webDriver = new ChromeDriver();

        webDriver.get("https://www.goodreads.com/");
    }

    @After
    public void tearDown() {
		webDriver.quit();
    }

    @Test
    public void testSearch() {
        WebElement searchField = webDriver.findElement(By.id("sitesearch_field"));
        searchField.sendKeys(BOOK_TITLE);
        searchField.submit();

        assertThat(webDriver.getTitle(), containsString("Search results for"));
        assertThat(webDriver.getTitle(), containsString(BOOK_TITLE));
    }
}
