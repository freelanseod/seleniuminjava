import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.impl.HomePage;
import pages.impl.SearchResultPage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    private static final String SEARCH_PHRASE = "selenium";

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeAll
    public static void setUpWait() {
        wait = new WebDriverWait(driver, 15);
    }

    public static void switchOffImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void checkGitHubSearch() {
        driver.get("https://github.com/");
        HomePage homePageGitHub = new HomePage(driver);
        SearchResultPage searchResultGitHubPage = new SearchResultPage(driver);

        homePageGitHub.performSearch(SEARCH_PHRASE);
        List<String> actualItems = searchResultGitHubPage.searchResultsItems();
        List<String> expectedItems = searchResultGitHubPage.searchResultsItemsWithText(SEARCH_PHRASE);

        assertEquals(expectedItems, actualItems);
    }

    @AfterAll
    public static void tearDownDriver() {
        System.out.println(LocalDateTime.now());
        driver.quit();
    }

}
