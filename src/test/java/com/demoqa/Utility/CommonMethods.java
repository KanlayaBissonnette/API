package com.demoqa.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {

	/*
	 * // commondmethod Class is reusable and can be recall Method that clear and
	 * send key
	 * 
	 */

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * this method will click only the value that pass in String value
	 * 
	 */
	public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBox, String value) {

		String actualValue;
		for (WebElement ele : radioOrCheckBox) {
			actualValue = ele.getAttribute("value").trim();
			if (ele.isEnabled() && actualValue.equals(value))
				;
			ele.click();
			break;
		}
	}

	// select dropdown by value
	public static void selectDropDownValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement ele : options) {
				if (ele.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();

		}

	}

	// select dropdown by index
	public static void selectDropDownByIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();

		}

	}

	/*
	 * ALERT
	 */

	// dismiss alert
	public static void dismissAlert() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}

	}

	public static void getAlertText() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();

			alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}

	}

	public static String getAlertText2() {

		String alertText = null;

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	public static void getAceptAlert() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();

			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}

	}

	public static void sendAlertText() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();

			alert.sendKeys("Whatever");

			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}

	}

	public static void switchToframeByName(String nameOrID) {

		try {

			BaseClass.getDriver().switchTo().frame(nameOrID);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}

	}

	public static void switchToframeByElement(WebElement element) {

		try {

			BaseClass.getDriver().switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}

	}

	public static void switchToframeByIndex(int index) {

		try {

			BaseClass.getDriver().switchTo().frame(index);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}

	}

	public static void switchToChildWindow() {

		String mainWindow = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();

		// each window : set of window
		for (String eachWindow : windows) {
			if (!eachWindow.equals(mainWindow)) {
				BaseClass.getDriver().switchTo().window(eachWindow);
				break;

			}
		}

	}

	// IMPLICIT/EXPLICIT WAIT

	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.explicit_wait_time);

		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	// JavaScript Executor
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;

	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);

	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollInToView(true);", element);
	}

	public static void scrollDownByPixel(int pixel) {
		// scroll down pixel = positive number
		// scroll up pixel = negative number
		getJSObject().executeScript("window.scrollBy(0", 500);

	}

	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM-dd_HH_mm_ss");

		return sdf.format(date.getTime());

	}

	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	public static void wait(int second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				pickDate.click();
				break;
			}
		}
	}

	public static void hover(WebElement element) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.moveToElement(element).perform();

	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.dragAndDrop(source, target).perform();
	}

	public static void doubleClick(WebElement source) {
		Actions actions = new Actions(BaseClass.getDriver());
		actions.doubleClick(source).perform();
	}

	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elementTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elementTexts.add(el.getText());
			}
		}
		return elementTexts;
	}
	
	public static String randomsString(int size) {
        String generateString = RandomStringUtils.randomAlphabetic(size);
        return generateString;
    }

}
