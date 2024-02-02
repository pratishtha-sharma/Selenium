package webDriverpkg;

public interface webDriverConenctor {
	// this will have all driver based commands
	
	void openBrowser(String bName);
	// opening of browser will happen over here, although we have same function in interface ZohoNormal
	
	void navigate(String url);
	void quit();

}
