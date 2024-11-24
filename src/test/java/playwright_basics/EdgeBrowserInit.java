package playwright_basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EdgeBrowserInit {


    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void openBrowser() {
        playwright = Playwright.create();
        browserType = playwright.webkit();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions());
        page = context.newPage();
    }

    @Test
    public void openUrlEdge() throws InterruptedException {
        page.navigate("https://www.google.com/");
        System.out.println(page.title());
        System.out.println("Version of firefox: "+browser.version());
        Thread.sleep(3000);
    }

    @AfterSuite
    public void closeBrowser(){
        page.close();
        browser.close();
        playwright.close();
    }



}
