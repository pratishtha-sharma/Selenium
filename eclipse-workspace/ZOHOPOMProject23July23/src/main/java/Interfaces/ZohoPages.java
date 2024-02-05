package Interfaces;

public interface ZohoPages extends ZohoNormalPages, ZohoSessionPages {
	
	//normal browser operations
	void openBrowser(String Browser);
	void quit();
	void getTotalWindows();
	
	//zoho page based normal
	void goToHomePage();
	void goToRegisterPage();
	void submitUsername(String userId);
	void validator();
	
	//zoho Session based
	void createDeal();
	void logout();

}
