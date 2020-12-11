package page.ProductList.commonVerify

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class TotalProduct {

	@Keyword
	public void verifyTotalProduct() {
		String temp = WebUI.getText(findTestObject('Product List Page (New)/span_Products found')).replaceAll("\\D","")
		int totalProduct = Integer.parseInt(temp)
		for (int i = 1;i<=(totalProduct/6); i++) {
			WebUI.scrollToElement(findTestObject('Product List Page (New)/button_More'), GlobalVariable.TimeOut)
			WebUI.waitForElementClickable(findTestObject('Product List Page (New)/button_More'), GlobalVariable.TimeOut)
			WebUI.click(findTestObject('Product List Page (New)/button_More'))
		}
		WebUI.scrollToElement(findTestObject('Object Repository/Common Footer/div_Facebook_Icon'), GlobalVariable.TimeOut)
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement prodctListElement = driver.findElement(By.xpath("//div[@class='category']//div[@data-test='productList']"))
		List<WebElement> productList = prodctListElement.findElements(By.tagName("a"))
		WebUI.verifyEqual(productList.size(), totalProduct)
	}
}
