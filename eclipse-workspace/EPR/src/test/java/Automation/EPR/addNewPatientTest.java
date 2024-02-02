package Automation.EPR;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjects.addNewPatientObject;

public class addNewPatientTest extends baseClass{
	generateRandomData random = new generateRandomData();
	addNewPatientObject an;
	
	@Test(priority=2)
	public void addPatient() throws InterruptedException {
		an = new addNewPatientObject(driver);
		Thread.sleep(2000);
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		WebElement addNewP = driver.findElement(By.xpath("//span[contains(text(),'Add New Animal')]"));
//		je.executeScript("arguments[0].scrollIntoView(true);",addNewP);  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		an.addNewPatient().click();
		
		Thread.sleep(2000);
		an.confirm().click();
		Thread.sleep(2000);
		
		//click on dashboard, search new patient activity and then click on the one with no animal name
		an.dashboard().click();
		Thread.sleep(2000);
		
		//click on search
		//an.search().sendKeys(keysToSend);
		Actions a = new Actions(driver);
		a.moveToElement(an.search()).click().sendKeys("New patient").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		//click on first new patient activity
		an.newPatientactivity().click();
		Thread.sleep(2000);
		//click on submit without filling anything to check validations
		an.verifyNSubmit().click();
		//click on submit intake without filling
		an.submitIntake().click();
		//click on previous to go back to intake page
		an.previous().click();
		
		//start intake form filling
		//street
		an.street().sendKeys(random.generateRandomString(5));
		//city
		an.city().sendKeys(random.generateRandomString(5));
		//state
//		an.state().sendKeys(random.generateRandomString(5)); //now it is a dropdown
		an.stateClick().click();
		//select state
		List<WebElement> states = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (int i=0; i<an.stateCount(); i++) {
			String text = states.get(i).getText();
			
			if(text.equalsIgnoreCase("Alabama")) {
				states.get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		//code
		an.postalCode().sendKeys(random.generateRandomNumber(5));
		//same as client
		an.sameAsClient().click();
		//first name
		an.FirstName().sendKeys("Test"+random.generateRandomNumber(4));
		//last name
		an.LastName().sendKeys("Test"+random.generateRandomNumber(4));
				
		//select species
		Select species = new Select(an.speciesId());
		species.selectByValue("2");
		
		//select breed
		Select breed = new Select(an.breedId());
		breed.selectByValue("2");
		
        //age
		an.age().click();
		//weight
		an.weight().sendKeys(random.generateRandomNumber(2));
		//primary vet
		an.primaryVet().sendKeys(random.generateRandomString(5));
		//clinic
		an.clinic().sendKeys(random.generateRandomString(5));
		//vet email
		an.vetEmail().sendKeys(random.generateEmail(10));
		//vet phone
		an.vetPhone().sendKeys(random.generateRandomNumber(10));
		//medication
		an.medication().sendKeys(random.generateRandomAlphaNumeric(300));
		//background
		an.answer1().sendKeys(random.generateRandomString(10));
		an.answer2().sendKeys(random.generateRandomString(10));
		an.answer3().sendKeys(random.generateRandomString(10));
		an.answer4().sendKeys(random.generateRandomString(10));
		an.answer5().sendKeys(random.generateRandomString(10));
		//next
		an.nextPage().click();
		//submit
		an.submitIntake().click();
		
	}

}
