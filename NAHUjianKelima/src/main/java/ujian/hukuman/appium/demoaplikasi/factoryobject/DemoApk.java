package ujian.hukuman.appium.demoaplikasi.factoryobject;
import ujian.hukuman.appium.Utils;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class DemoApk {
	public AndroidDriver<MobileElement> driver;
	public TouchAction action;
	private String strDisplay = Utils.GLOB_PARAM_DISPLAY;

	public DemoApk(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.action = new TouchAction<>(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/*--- Main Page ---*/
//	@AndroidFindBy(id = "android:id/message")
//	private MobileElement loadPage;
	@AndroidFindBy(id = "com.gcart.android.demov2:id/btnHomeProduct")
	private MobileElement toProduct;
	@AndroidFindBy(id = "com.gcart.android.demov2:id/btnHomeOrder")
	private MobileElement toOrderan;
	@AndroidFindBy(id = "com.gcart.android.demov2:id/btnHomeNota")
	private MobileElement toNota;
	@AndroidFindBy(id = "com.gcart.android.demov2:id/btnHomePaymentNota")
	private MobileElement toPembayaran;

	/*--- Product ---*/
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
	private MobileElement btnFashion;
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"tes\"])[2]")
	private MobileElement prodTwo;
	@AndroidFindBy(id = "com.gcart.android.demov2:id/btnOrderProduct")
	private MobileElement btnToOrder;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[1]")
	private MobileElement isiJumlah;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[2]")
	private MobileElement isiBerita;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
	private MobileElement btnOrder;
	
	/*--- Orderan ---*/
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckBox[2]")
	private MobileElement listOrder;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
	private MobileElement sendExp;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Spinner[1]/android.widget.CheckedTextView")
	private MobileElement selectExp;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Spinner[2]/android.widget.CheckedTextView")
	private MobileElement selectProv;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Spinner[3]")
	private MobileElement selectKotKab;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Spinner[4]")
	private MobileElement selectKec;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Spinner/android.widget.CheckedTextView")
	private MobileElement expMethod;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[1]")
	private MobileElement senderName;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[2]")
	private MobileElement senderContact;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[3]")
	private MobileElement receverName;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[4]")
	private MobileElement receiverContact;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[5]")
	private MobileElement receiverAddress;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
	private MobileElement btnSubmit;
	
	/*--- Nota ---*/
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckBox[1]")
	private MobileElement listNota;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
	private MobileElement btnPay;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	private MobileElement textPrice;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[1]")
	private MobileElement paymentPrice;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[2]")
	private MobileElement bankName;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[3]")
	private MobileElement noRekening;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[4]")
	private MobileElement notes;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText[5]")
	private MobileElement transferedBank;
	
	/*--- Pembayaran ---*/
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement listBayar;
	
	
	// Static Select
//	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
//	private MobileElement expJNE;
	
	/*--- Method ---*/
	public void toProduct() {
		this.toProduct.click();
	}
	public void toOrderan() {
		this.toOrderan.click();
	}
	public void toNota() {
		this.toNota.click();
	}
	
	//Product
	public void toFashion() {
		this.btnFashion.click();
	}
	public void selectProdTwo() {
		this.prodTwo.click();
	}
	public void toOrderPage() {
		this.btnToOrder.click();
	}
	public void fillJumlah(Integer jml) {
		this.isiJumlah.sendKeys(jml.toString());
	}
	public void fillBerita(String brt) {
		this.isiBerita.sendKeys(brt);
	}
	public void clickOrder() {
		this.btnOrder.click();
	}
	public void checkOrder() {
		this.listOrder.click();
	}
	
	//Order
	public void expSelection(int option) {
		this.selectExp.click();
		Utils.delay(2);
		selectOption(option);
	}
	public void stateSelection(int option) {
		this.selectProv.click();
		Utils.delay(2);
		selectOption(option);
	}
	public void citySelection(int option) {
		this.selectKotKab.click();
		Utils.delay(2);
		selectOption(option);
	}
	public void districtSelection(int option) {
		this.selectKec.click();
		Utils.delay(2);
		selectOption(option);
	}
	public void expeditionMethodSelection(int option) {
		this.expMethod.click();
		Utils.delay(2);
		selectOption(option);
	}
	public void deliveryInformation(String senderName, Integer senderContact, String receiverName, Integer receiverContact, String receiverAddress) {
		this.senderName.sendKeys(senderName);
		this.senderContact.sendKeys(senderContact.toString());
		this.receverName.sendKeys(receiverName);
		this.receiverContact.sendKeys(receiverContact.toString());
		this.receiverAddress.sendKeys(receiverAddress);
	}
	public void btnSubmit() {
		this.btnSubmit.click();
	}
	
	//Nota
	public void payProd() {
		this.listNota.click();
	}
	public void payPrice() {
		String val = this.textPrice.getText();
		this.paymentPrice.sendKeys(Utils.filterDigit(val));
	}
	public void yourBank(String bank) {
		this.bankName.sendKeys(bank);
	}
	public void yourRekening(Integer norek) {
		this.noRekening.sendKeys(norek.toString());
	}
	public void transfersNotes(String note) {
		this.notes.sendKeys(note);
	}
	public void transfersBank(String bank) {
		this.transferedBank.sendKeys(bank);
	}
	public void swipeMonth(int totalSwipe) {
		for (int i = 0; i < totalSwipe; i++) {
			if (strDisplay.equals("y")) {
				action.press(PointOption.point(65, 666)).waitAction().moveTo(PointOption.point(65, 577)).release().perform();
			} else {				
				action.press(PointOption.point(300, 666)).waitAction().moveTo(PointOption.point(300, 577)).release().perform();
			}
		}
	}
	public void swipeDate(int totalSwipe) {
		for (int i = 0; i < totalSwipe; i++) {
			if (strDisplay.equals("y")) {				
				action.press(PointOption.point(170, 666)).waitAction().moveTo(PointOption.point(170, 577)).release().perform();
			} else {				
				action.press(PointOption.point(420, 666)).waitAction().moveTo(PointOption.point(420, 577)).release().perform();
			}
		}
	}
	public void swipeYear(int totalSwipe) {
		for (int i = 0; i < totalSwipe; i++) {
			if (strDisplay.equals("y")) {				
				action.press(PointOption.point(285, 666)).waitAction().moveTo(PointOption.point(285, 577)).release().perform();
			} else {				
				action.press(PointOption.point(550, 666)).waitAction().moveTo(PointOption.point(550, 577)).release().perform();
			}
		}
	}
	
	//Pembayaran
	public void toPembayaran() {
		this.toPembayaran.click();
	}
	
	// Static Select Method
//	public void selectJNE() {
//		this.expJNE.click();
//	}
	
	
	public void scrollClickElement(String text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()."
				+ "scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
	}
	
	public void goBack(int nilai) {
		for (int i = 0; i <= nilai; i++) {			
			driver.navigate().back();
		}
	}
	
	public void selectOption(int option) {
		for (int i = 0; i < option; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		}
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	/*--- Validasi ---*/
	public String getValidProduct() {
		return this.listOrder.getText();
	}
	public String getValidOrder() {
		return this.listNota.getText();
	}
	public String getValidBayar() {
		return this.listBayar.getText();
	}
}
