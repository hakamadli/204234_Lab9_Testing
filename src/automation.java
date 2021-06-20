import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class automation {

    public static void main(String args[]) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        // To hide advanced pad on app first launch
        MobileElement el1 = (MobileElement) androidDriver.findElementById("com.google.android.calculator:id/digit_0");
        el1.click();

        // Begin test
        MobileElement el2 = (MobileElement) androidDriver.findElementById("com.google.android.calculator:id/digit_5");
        el2.click();
        MobileElement el3 = (MobileElement) androidDriver.findElementById("com.google.android.calculator:id/digit_3");
        el3.click();
        MobileElement el4 = (MobileElement) androidDriver.findElementByAccessibilityId("plus");
        el4.click();
        MobileElement el5 = (MobileElement) androidDriver.findElementById("com.google.android.calculator:id/digit_1");
        el5.click();
        MobileElement el6 = (MobileElement) androidDriver.findElementById("com.google.android.calculator:id/digit_4");
        el6.click();
        MobileElement el7 = (MobileElement) androidDriver.findElementByAccessibilityId("equals");
        el7.click();

        Assert.assertEquals(androidDriver.findElementById("com.google.android.calculator:id/result_final").getText(), "70");

    }
}
