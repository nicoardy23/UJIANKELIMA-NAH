package ujian.ujiankelima.appium.runner;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ujian.ujiankelima.appium.factoryobject.CustomerDB;
import ujian.ujiankelima.appium.factoryobject.EditCustomerDB;
import ujian.ujiankelima.appium.factoryobject.VoucherDB;

public class CustomerSDRunner {
	private static AndroidDriver<MobileElement> driver;
	private CustomerDB cust;
	private VoucherDB vou;
	private EditCustomerDB edit;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21513");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "de.georgsieber.customerdb");
		capabilities.setCapability("appActivity", "de.georgsieber.customerdb.MainActivity");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("automationName", "UiAutomator2");
//		capabilities.setCapability("appWaitDuration", "600");
//		capabilities.setCapability("adbExecTimeout", "600");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		System.out.println("DRIVER : "+driver);
	}
	
	@BeforeMethod
	public void pageObject() {
		cust = new CustomerDB(driver);
		vou = new VoucherDB(driver);
		edit = new EditCustomerDB(driver);
	}
	
	@Test(priority = 0)
	public void CustAdd() {
//		cust.agreeButton();
		cust.customerAdd();
		cust.customerName("Nico", "Ardy");
		cust.customerContact("087874923715", "ardynico23@gmail.com");
		cust.customerAddress("Pesakih", "11750", "Duri Kosambi", "Jakarta");
		cust.customerGroup("Nexsoft");
		cust.customerCekLetter();
		cust.customerNotes("Makan");
		cust.customerBirthSet();
		
/*		nu such element karena belum dapat method untuk swipe layar */
//		cust.customerBirthSet();
//		cust.customerCekLetter();
		
		cust.applyBtn();
		assertTrue(cust.validCust().contains("Nico"));
		System.out.println("============ ADD CUSTOMER SUCCESS ============");
	}
	
	@Test(priority = 1)
	public void voucherAdd() {
//		vou.agreeButton();
		vou.voucherMenu();
		vou.voucherAdd();
		vou.voucherValue(2.0);
		vou.voucherNum(1);
		vou.addNotes("Voucher Makan");
//		vou.scrollValid();
//		vou.voucherValid();
		vou.applyBtn();
		assertTrue(vou.getVoucher().contains("2.0"));
		System.out.println("============ ADD VOUCHER SUCCESS ============");
	}
	
	@Test(priority = 2)
	public void CustEdit() {
		edit.customerMenu();
		edit.customerTap();
		edit.customerEdit();
		edit.customerName("Miki", "Momo");
		edit.customerContact("081280525192", "nicoardy23@gmail.com");
		edit.customerAddress("Pesakih", "11750", "Duri Kosambi", "Jakarta");
		edit.customerGroup("Nexsoft");
		edit.customerCekLetter();
		edit.customerNotes("Minum");
		cust.customerBirthSet();
		
/*		nu such element karena belum dapat method untuk swipe layar */
//		cust.customerBirthSet();
//		cust.customerCekLetter(); 
		
		edit.applyBtn();
		assertTrue(edit.validCust().contains("Miki"));
		System.out.println("============ EDIT CUSTOMER SUCCESS ============");
	}
}
