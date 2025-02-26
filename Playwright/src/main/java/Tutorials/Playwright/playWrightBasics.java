package Tutorials.Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playWrightBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");  // check for msedge, chrome-beta, msedge-dev, msedge-beta
		lp.setHeadless(false);
		Browser browser = playwright.chromium().launch(lp); // browser context headless mode
		//Browser browser = playwright.firefox().launch(); // browser context
		//Browser browser = playwright.webkit().launch(); // browser context
		
		//Browser browser = playwright.webkit ().launch(new BrowserType.LaunchOptions().setHeadless(false)); // browser context
		
		Page page = browser.newPage(); // page context
		page.navigate("https://ecommercemarketplace.24livehost.com/");
		
		String title = page.title();
		System.out.println("The title of page is :"+ title);
		
		String url = page.url();
		System.out.println("The url of page is :"+ url);
		browser.close();
		playwright.close();

	}

}
