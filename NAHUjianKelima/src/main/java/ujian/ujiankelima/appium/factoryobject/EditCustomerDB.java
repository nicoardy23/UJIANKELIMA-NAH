package ujian.ujiankelima.appium.factoryobject;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditCustomerDB {
	public AndroidDriver<MobileElement> driver;

	public EditCustomerDB(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Main Page
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement iAgree;
	
	//Edit
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Customers\"]/android.widget.ImageView")
	private MobileElement customerMenu;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.GridLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement tapCustomer;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/fabEdit")
	private MobileElement customerEdit;
	
	// Add Customer
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
	
	// No Such Element karena blum bisa scroll page
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/buttonBirthday")
	private MobileElement dobSet;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"23 September 2022\"]")
	private MobileElement validDate;
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement okButton;
//	@AndroidFindBy(id = "android:id/date_picker_header_year")
//	private MobileElement setYear;
//	@AndroidFindBy(id = "android:id/date_picker_year_picker")
//	private MobileElement yearScroll;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/checkBoxEditNewsletter")
	private MobileElement cekNewsLetter;
	
	// Apply and Validation
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/action_edit_done")
	private MobileElement applyButton;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/textViewName")
	private MobileElement valid;

	
	// Method Cust
	public void agreeButton() {
		iAgree.click();
	}
	
	public void customerMenu() {
		customerMenu.click();
	}
	
	public void customerTap() {
		tapCustomer.click();
	}

	public void customerEdit() {
		customerEdit.click();
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

	// Apply and Validation Method
	public void applyBtn() {
		applyButton.click();
	}
	
	public String validCust() {
		return valid.getText();
	}
	
	
	// Still error method
	public void customerCekLetter() {
		cekNewsLetter.click();
	}
	
	public void customerBirthSet() throws InterruptedException {
		dobSet.click();
		validDate.click();
		okButton.click();
//		setYear.click();
//		TouchActions action = new TouchActions(driver);
//		action.scroll(yearScroll, 350, 440);
//		action.perform();
	}
	

}
