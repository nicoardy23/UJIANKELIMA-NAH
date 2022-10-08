package ujian.hukuman.appium.catatankeuangan.runner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import ujian.hukuman.appium.catatankeuangan.factoryobject.MoneyTracker;

public class MoneyTrackerRunner {
	private static AndroidDriver<MobileElement> driver;
	private static TouchAction action;
	private MoneyTracker mTrack;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21513");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.asyncbyte.moneytracker");
		capabilities.setCapability("appActivity", "com.asyncbyte.moneytracker.TabViewPagerActivity");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("automationName", "UiAutomator2");
//		capabilities.setCapability("appWaitDuration", "600");
//		capabilities.setCapability("adbExecTimeout", "600");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mTrack = new MoneyTracker(driver);
		action = new TouchAction<>(driver);
	}
	
	@Test(priority = 0)
	public void addTransaction() {
		mTrack.addTrx();
		mTrack.addAmount(30000);
		mTrack.addTitleTransaction("Makan NasPad");
		mTrack.selectTypeDown(2);
		mTrack.selectCategoryDown(3);
		mTrack.btnSave();
		assertTrue(mTrack.getValidAddTrx().contains("Makan NasPad"));
	}
	
	@Test(priority = 1)
	public void editTransaction() {
		mTrack.editTrx();
		mTrack.btnEdit();
		mTrack.calculator();
		mTrack.editAmount();
		mTrack.useResult();
		mTrack.addTitleTransaction("+Cendol");
		mTrack.selectTypeUp(1);
		mTrack.selectCategoryDown(2);
		mTrack.btnSave();
		assertTrue(mTrack.getValidAddTrx().contains("+Cendol"));
	}
	
	@Test(priority = 2)
	public void deleteTransaction() {
		mTrack.editTrx();
		mTrack.btnDelete();
		assertFalse(mTrack.getValidAddTrx().contains("NasPad+Cendol"));
	}
}
