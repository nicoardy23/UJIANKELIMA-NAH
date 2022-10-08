package ujian.hukuman.appium.catatankeuangan.factoryobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ujian.hukuman.appium.Utils;

public class MoneyTracker {
	public AndroidDriver<MobileElement> driver;
	public TouchAction action;
	private String strDisplay = Utils.GLOB_PARAM_DISPLAY;

	public MoneyTracker(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.action = new TouchAction<>(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/*--- Tambah ---*/
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btnAdd")
	private MobileElement btnAdd;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Spinner[1]/android.widget.TextView")
	private MobileElement selectType;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Spinner[2]/android.widget.TextView")
	private MobileElement selectCategory;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/etTxAmount")
	private MobileElement moneyAmount;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/etTvTitle")
	private MobileElement trxTitle;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btnSave")
	private MobileElement btnSave;
	
	/*--- Edit ---*/
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/tvTitle")
	private MobileElement trxList;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btnEdit")
	private MobileElement btnEdit;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btnCalc")
	private MobileElement btnCalc;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btn_one")
	private MobileElement btnOne;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btn_three")
	private MobileElement btnThree;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btn_zero_2")
	private MobileElement btnDoubZero;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btn_add")
	private MobileElement btnPlus;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btn_equal")
	private MobileElement btnEquals;
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btn_use_result")
	private MobileElement useResult;

	/*--- Delete ---*/
	@AndroidFindBy(id = "com.asyncbyte.moneytracker:id/btnDelete")
	private MobileElement btnDelete;
	
	/*--- Method ---*/
	public void addTrx() {
		this.btnAdd.click();
	}
	public void selectTypeDown(int opt) {
		this.selectType.click();
		selectOptionDown(opt);
	}
	public void selectCategoryDown(int opt) {
		this.selectCategory.click();
		selectOptionDown(opt);
	}
	public void addAmount(Integer amount) {
//		this.moneyAmount.clear();
		this.moneyAmount.sendKeys(amount.toString());
	}
	public void addTitleTransaction(String title) {
//		this.moneyAmount.clear();
		this.trxTitle.sendKeys(title);
	}
	public void btnSave() {
		this.btnSave.click();
	}
	
	public void editTrx() {
		this.trxList.click();
	}
	public void btnEdit() {
		this.btnEdit.click();
	}
	public void calculator() {
		this.btnCalc.click();
	}
	public void editAmount() {
		this.btnThree.click();
		this.btnDoubZero.click();
		this.btnDoubZero.click();
		this.btnPlus.click();
		this.btnOne.click();
		this.btnDoubZero.click();
		this.btnDoubZero.click();
		this.btnEquals.click();
	}
	public void useResult() {
		this.useResult.click();
	}
	public void selectTypeUp(int opt) {
		this.selectType.click();
		selectOptionUp(opt);
	}
	public void selectCategoryUp(int opt) {
		this.selectCategory.click();
		selectOptionUp(opt);
	}
	
	public void btnDelete() {
		this.btnDelete.click();
	}
	
	public void scrollClickElement(String text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()."
				+ "scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
	}
	public void selectOptionDown(int option) {
		for (int i = 0; i < option; i++) {
			Utils.delay(1);
			driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		}
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	public void selectOptionUp(int option) {
		for (int i = 0; i < option; i++) {
			Utils.delay(1);
			driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
		}
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	/*--- Validaasi ---*/
	public String getValidAddTrx() {
		Utils.delay(2);
		return this.trxList.getText();
	}
}
