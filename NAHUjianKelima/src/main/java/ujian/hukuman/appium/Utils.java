package ujian.hukuman.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Utils {
	public static final String GLOB_PARAM_DISPLAY = "n";
	
	public static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String filterDigit(String message) {
		 String res;
		 int len=0, i=0;
		 boolean isDigit;
		 
		 char[] data = message.toCharArray();
		 
		 while(i<data.length){
		 isDigit = Character.isDigit(data[i]);
		 if(isDigit==true){
		 data[len] = data[i];
		 len++;
		 }
		 i++;
		 }
		 StringBuffer strBuf = new StringBuffer();
		 strBuf.append(data, 0, len);
		 return res = strBuf.toString();
	}
}
