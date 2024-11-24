package playwright_basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HeadLessTestBrowser {
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void startBrowser(){
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions());
        page = context.newPage();
    }

    @Test
    public void openUrl() throws InterruptedException {
        page.navigate("https://www.google.com/");
        Thread.sleep(3000);
        System.out.println(page.title());
        System.out.println("Browser Version: "+ browser.version());
    }

    @AfterSuite
    public void closeBrowser(){
        page.close();
        browser.close();
        playwright.close();
    }

}
