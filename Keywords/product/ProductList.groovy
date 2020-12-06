package product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ProductList {

	@Keyword
	public void verifyTotalProduct() {
		String temp = WebUI.getText(findTestObject('Groceries/span_Products found')).replaceAll("\\D","")
		int totalProduct = Integer.parseInt(temp)
		for (int i = 1;i<=(totalProduct/6); i++) {
			WebUI.scrollToElement(findTestObject('Object Repository/Groceries/button_More'), GlobalVariable.TimeOut)
			WebUI.click(findTestObject('Object Repository/Groceries/button_More'))
		}

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement prodctListElement = driver.findElement(By.xpath("//div[@class='category']//div[@data-test='productList']"))
		List<WebElement> productList = prodctListElement.findElements(By.tagName("a"))
		WebUI.verifyEqual(productList.size(), totalProduct)
	}
}