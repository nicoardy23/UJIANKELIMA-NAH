package ujian.hukuman.appium.demoaplikasi.runner;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import ujian.hukuman.appium.Utils;
import ujian.hukuman.appium.demoaplikasi.factoryobject.DemoApk;

public class DemoApkRunner {
	private static AndroidDriver<MobileElement> driver;
	private static TouchAction action;
	private DemoApk demo;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21513");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.gcart.android.demov2");
		capabilities.setCapability("appActivity", "com.gcart.android.demov2.MainActivity");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", false);
//		capabilities.setCapability("automationName", "UiAutomator2");
//		capabilities.setCapability("appWaitDuration", "600");
//		capabilities.setCapability("adbExecTimeout", "600");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		action = new TouchAction<>(driver);
		demo = new DemoApk(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 0)
	public void orderProduct() {
		demo.toProduct();
		demo.toFashion();
		demo.selectProdTwo();
		demo.toOrderPage();
		demo.fillJumlah(1);
		demo.fillBerita("Haiii");
		/*Saran : karena ketika dijalankan tidak dapat scroll dan 
		 * swipe, jadi mungkin lebih baik menggunakan layar bertipe
		 * phone/portait*/
//		demo.scrollClickElement("Order");
//		demo.swipeMonth(7);
		demo.clickOrder();
		demo.goBack(3);
		demo.toOrderan();
		assertTrue(demo.getValidProduct().contains("Haii"));
	}
	
//	@Test(priority = 1)
	public void sendProduct() {
		demo.toOrderan();
		demo.checkOrder();
		demo.scrollClickElement("Pengiriman Ekspedisi");
		demo.expSelection(2);
		demo.stateSelection(3);
		demo.citySelection(5);
		demo.districtSelection(3);
		demo.btnSubmit();
		Utils.delay(2);
		demo.btnSubmit();
		demo.deliveryInformation("Nico", 87878789, "Koko", 90909777, "Jalan Lama");
		demo.btnSubmit();
		demo.toNota();
		assertTrue(demo.getValidOrder().contains("Nico") || demo.getValidOrder().contains("Koko"));
	}
	
//	@Test(priority = 2)
	public void payProduct() {
		demo.toNota();
		demo.payProd();
		demo.scrollClickElement("Konfirmasi Bayar");
		demo.payPrice();
		demo.yourBank("BCA");
		demo.yourRekening(2123412123);
		demo.transfersNotes("Bayar Pajak");
		demo.transfersBank("BCI");
		/*untuk swipe bisa pilih display tablet/ phone dengan metode global param*/
		demo.swipeDate(4);
		demo.swipeMonth(3);
		demo.swipeYear(1);
		demo.scrollClickElement("KONFIRMASI");
//		demo.btnSubmit();
		demo.toPembayaran();
		assertTrue(demo.getValidBayar().contains("2123412123"));
	}
}
