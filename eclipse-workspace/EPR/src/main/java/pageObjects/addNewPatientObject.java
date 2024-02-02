package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addNewPatientObject {
	
WebDriver driver;
	
	public addNewPatientObject(WebDriver driver) {
           this.driver = driver;
           PageFactory.initElements(driver, this); //Initialize the page factory method when we are using the FindBy Annotation.
	}
	
	//add new patient
	@FindBy(xpath="//a[@id='addnewanimal']//span[contains(text(),'Add New Animal')]")
	WebElement addNew;
	public WebElement addNewPatient() {
		return addNew;
	}
	
	//confirm of add new patient
	@FindBy(xpath="//button[@id='btn-submit']")
	WebElement yes;
	public WebElement confirm() {
		return yes;
	}
		
	//verify and submit tab
	@FindBy(xpath="//a[@id='lifinalfrm']")
	WebElement verify;
	public WebElement verifyNSubmit() {
		return verify;
	}
	
	//street
	@FindBy(xpath="//input[@id='Street']")
	WebElement streetField;
	public WebElement street() {
		return streetField;
	}
	
	//city
	@FindBy(xpath="//input[@id='City']")
	WebElement cityField;
	public WebElement city() {
		return cityField;
	}
	
	//state
	@FindBy(xpath="//span[@id='select2-StateId-container']")
	WebElement stateField;
	public WebElement stateClick() {
		return stateField;
	}
	
	//state Selection
	@FindBy(xpath="//li[@class='select2-results__option']")
	List<WebElement> states;
	public int stateCount() {
		return states.size();
	}
	
	//postalCode
	@FindBy(xpath="//input[@id='PostalCode']")
	WebElement postalCodeField;
	public WebElement postalCode() {
		return postalCodeField;
	}
	
	//same as client checkbox
	@FindBy(xpath="//input[@id='checkbox2']")
	WebElement checkbox;
	public WebElement sameAsClient() {
		return checkbox;
	}
	
	//first name
	@FindBy(xpath="//input[@id='PetName']")
	WebElement petName;
	public WebElement FirstName() {
		return petName;
	}
	
	//last name
	@FindBy(xpath="//input[@id='PetLastName']")
	WebElement petLastName;
	public WebElement LastName() {
		return petLastName;
	}
	
	//species
	@FindBy(xpath="//select[@id='SpecieId']")
	WebElement speciesField;
	public WebElement speciesId() {
		return speciesField;
	}
	
	//breed
	@FindBy(xpath="//select[@id='BreedId']")
	WebElement breedField;
	public WebElement breedId() {
		return breedField;
	}
	
	//age
	@FindBy(xpath="//input[@id='AgeNotSure']")
	WebElement ageField;
	public WebElement age() {
		return ageField;
	}
	
	//weight
	@FindBy(xpath="//input[@id='PetWeight']")
	WebElement weightField;
	public WebElement weight() {
		return weightField;
	}
	
	//primary vet
	@FindBy(xpath="//input[@id='PrimaryVet']")
	WebElement primaryvetField;
	public WebElement primaryVet() {
		return primaryvetField;
	}
	
	//clinic
	@FindBy(xpath="//input[@id='Clinic']")
	WebElement clinicField;
	public WebElement clinic() {
		return clinicField;
	}
	
	//vet email
	@FindBy(xpath="//input[@id='VetEmail']")
	WebElement vetemailField;
	public WebElement vetEmail() {
		return vetemailField;
	}
	
	//vet phone number
	@FindBy(xpath="//input[@id='ClinicPhone']")
	WebElement vetphoneField;
	public WebElement vetPhone() {
		return vetphoneField;
	}
	
	//Medications and Supplements
	@FindBy(xpath="//textarea[@id='MedicationAndSuppliments']")
	WebElement medicationField;
	public WebElement medication() {
		return medicationField;
	}
	
	//background answer1
	@FindBy(xpath="//textarea[@id='Answer1']")
	WebElement answer1Field;
	public WebElement answer1() {
		return answer1Field;
	}
	
	//background answer2
	@FindBy(xpath="//textarea[@id='Answer2']")
	WebElement answer2Field;
	public WebElement answer2() {
		return answer2Field;
	}
	
	//background answer3
	@FindBy(xpath="//textarea[@id='Answer3']")
	WebElement answer3Field;
	public WebElement answer3() {
		return answer3Field;
	}
	
	//background answer4
	@FindBy(xpath="//textarea[@id='Answer4']")
	WebElement answer4Field;
	public WebElement answer4() {
		return answer4Field;
	}
	
	//background answer5
	@FindBy(xpath="//textarea[@id='Answer5']")
	WebElement answer5Field;
	public WebElement answer5() {
		return answer5Field	;
	}
	
	//save as draft
	@FindBy(xpath="//a[@id='lisaveasdraft']")
	WebElement draft;
	public WebElement saveAsDraft() {
		return draft;
	}
	
	//next page
	@FindBy(xpath="//a[@id='nextStep']")
	WebElement next;
	public WebElement nextPage() {
		return next;
	}
	
	//submit intake
	@FindBy(xpath="//button[@id='finalsubmit']")
	WebElement submit;
	public WebElement submitIntake() {
		return submit;
	}
	
	//prvious button click to go back to intake form page
	@FindBy(xpath="//a[@id='prevStep']")
	WebElement prev;
	public WebElement previous() {
		return prev;
	}
	
	//dashboard
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	WebElement dashboardClick;
	public WebElement dashboard() {
		return dashboardClick;
	}
	
	//search
	@FindBy(xpath="//input[@type='search' and @class='form-control input-sm']")
	WebElement searchClick;
	public WebElement search() {
		return searchClick;
	}
	
	//click on new patient activity
	@FindBy(xpath="//tr[@id=\"rowId1\"]//td[4]")
	WebElement act;
	public WebElement newPatientactivity() {
		return act;
	}

}
