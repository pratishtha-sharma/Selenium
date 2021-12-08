package snippet;

public class Snippet {
	 //get the value of credits for wicket keepers
	    List<WebElement> credits = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]"));
	   
	    float a[] = null;
	    for(float i=0; i<credits.size(); i++) {
	    String text = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]")).get((int) i).getText();
	    System.out.println(text);
	    float credit=Long.parseLong(text);  
	   
	    a[(int) i]=credit;
	   
	    System.out.println(a[(int) i]);
	    }
}

