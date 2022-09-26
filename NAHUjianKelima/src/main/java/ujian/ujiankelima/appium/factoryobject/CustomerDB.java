package ujian.ujiankelima.appium.factoryobject;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomerDB {
	public AndroidDriver<MobileElement> driver;

	public CustomerDB(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Main Page
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement iAgree;
	
	// Add Customer
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/fabAdd")
	private MobileElement add;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextFirstName")
	private MobileElement firstName;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextLastName")
	private MobileElement lastName;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextPhoneMobile")
	private MobileElement phoneNum;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextEmail")
	private MobileElement emailAddress;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextStreet")
	private MobileElement address;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextZipcode")
	private MobileElement zipCode;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextCity")
	private MobileElement city;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextCountry")
	private MobileElement country;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextGroup")
	private MobileElement groupName;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextNotes")
	private MobileElement notes;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/checkBoxEditNewsletter")
	private MobileElement cekNewsLetter;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/buttonBirthday")
	private MobileElement dobSet;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"09 September 2022\"]")
	private MobileElement validDate;
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement okButton;
//	@AndroidFindBy(id = "android:id/date_picker_header_year")
//	private MobileElement setYear;
//	@AndroidFindBy(id = "android:id/date_picker_year_picker")
//	private MobileElement yearScroll;
	
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/action_edit_done")
	private MobileElement applyButton;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/textViewCustomerListItem1")
	private MobileElement valid;
	
	// Using Text
/*	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"Address\"))")
	private MobileElement element; */
	
	//Using ID
/*	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
			".scrollIntoView(new UiSelector().resourceIdMatches(\".*textViewAddress.*\"))")
	private MobileElement element; */

	
	// Method Cust
	public void agreeButton() {
		iAgree.click();
	}

	public void customerAdd() {
		add.click();
	}
	
	public void customerName(String first, String last) {
		firstName.sendKeys(first);
		lastName.sendKeys(last);
	}
	
	public void customerContact(String phone, String email) {
		phoneNum.sendKeys(phone);
		emailAddress.sendKeys(email);
	}
	
	public void customerAddress(String adr, String zip, String ct, String cntry) {
		// Using Text
//		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
//		        "new UiScrollable(new UiSelector().scrollable(true))" +
//		         ".scrollIntoView(new UiSelector().text(\"Address\"))"));
		
		//Using ID
//		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
//		        "new UiScrollable(new UiSelector().scrollable(true))" +
//		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*textViewAddress.*\"))"));
		
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()."
				+ "scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Address\").instance(0))").click();
		address.sendKeys(adr);
		zipCode.sendKeys(zip);
		city.sendKeys(ct);
		country.sendKeys(cntry);
	}
	
	public void customerGroup(String gr) {
		groupName.sendKeys(gr);
	}
	
	public void customerNotes(String note) {
		notes.sendKeys(note);
	}
	
	public void customerCekLetter() {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()."
				+ "scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Newsletter\").instance(0))").click();
		cekNewsLetter.click();
	}

	public void applyBtn() {
		applyButton.click();
	}
	
	public String validCust() {
		return valid.getText();
	}
	

	public void customerBirthSet() {
		dobSet.click();
		validDate.click();
		okButton.click();
//		setYear.click();
//		TouchActions action = new TouchActions(driver);
//		action.scroll(yearScroll, 350, 440);
//		action.perform();
	}
	

}
