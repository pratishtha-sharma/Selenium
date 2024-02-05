package webDriverpkg;

public interface ZohoWebConnector extends webDriverConenctor {
	
	void logout(); 
	void validateTitle();
	
	void validateLogin();
	
	// as per interface rules we need to re write the methods of extending interface
	void openBrowser(String bName);
	// opening of browser will happen over here, although we have same function in interface ZohoNormal
	
	void navigate(String url);
	void quit();

}
