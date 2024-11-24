package playwright_basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DriverSetup {
    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void startBrowser() {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions());
        page = context.newPage();
        System.out.println("Browser Version: "+ browser.version());

    }

    @Test
    public void openUrlChrome() throws InterruptedException {
        page.navigate("https://playwright.dev/java/docs/intro");
        Thread.sleep(3000);
    }

    @AfterSuite
    public void closeBrowser(){
        page.close();
        browser.close();
        playwright.close();
    }


}
