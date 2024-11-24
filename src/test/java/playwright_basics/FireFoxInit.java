package playwright_basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FireFoxInit {


    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    void openBrowser() {
        playwright = Playwright.create();
        browserType = playwright.firefox();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions());
        page = context.newPage();
    }

    @Test
    public void openUrlFirefox(){
        page.navigate("https://www.rokomari.com/book");
        System.out.println(page.title());
        System.out.println("Browser Version: "+browser.version());
    }

    @AfterSuite
    public void closeBrowser(){
        page.close();
        browser.close();
        playwright.close();
    }
}
