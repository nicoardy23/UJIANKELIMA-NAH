package ujian.ujiankelima.appium.factoryobject;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VoucherDB {
	public AndroidDriver<MobileElement> driver;

	public VoucherDB(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Agreement
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement iAgree;

	// Voucher
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Vouchers\"]/android.widget.ImageView")
	private MobileElement menuVoucher;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/fabAdd")
	private MobileElement add;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextValue")
	private MobileElement voucherValue;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextVoucherNo")
	private MobileElement voucherNum;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/editTextNotes")
	private MobileElement notes;
	
	// Valid Date
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/buttonValidUntil")
	private MobileElement voucherValid;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"28 September 2022\"]")
	private MobileElement validDate;
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement okButton;
	
	// Apply and Validation
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/action_edit_done")
	private MobileElement applyButton;
	@AndroidFindBy(id = "de.georgsieber.customerdb:id/textViewCustomerListItem1")
	private MobileElement valid;
 
	// Method voucher
	public void agreeButton() {
		iAgree.click();
	}
	
	public void voucherMenu() {
		menuVoucher.click();
	}
	
	public void voucherAdd() {
		add.click();
	}
	
	public void voucherValue(Double value) {
		voucherValue.sendKeys(value.toString());
	}
	
	public void voucherNum(Integer num) {
		voucherNum.sendKeys(num.toString());
	}
	
	public void voucherNotes(String note) {
		notes.sendKeys(note);
	}
	
	public void voucherValid() {
		voucherValid.click();
		validDate.click();
		okButton.click();
	}
	
	public void applyBtn() {
		applyButton.click();
	}
	
	public String getVoucher() {
		return valid.getText();
	}

}
