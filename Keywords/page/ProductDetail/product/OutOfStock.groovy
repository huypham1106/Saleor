package page.ProductDetail.product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class OutOfStock {

	private TestObject div_SizeDynamic = findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_size Common')
	private TestObject btn_AddToBasket=	findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/button_Add to basket')
	private TestObject p_OutOfStock = findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/p_Out of stock')
	private TestObject svg_RemoveSize = findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/svg_Remove Size')
	private TestObject svg_ClickSize = findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/svg_Click size')

	@Keyword
	public void verifyOutOfStock() {
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> sizeList = driver.findElements(By.xpath("//div[contains(@class,'iskUAR')]//div[contains(@class,'cDrDlU')]"))

		for (int i=1; i<=sizeList.size() ; i++) {
			WebUI.click(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_size Common',['no': i]))
			if(WebUI.verifyElementPresent(p_OutOfStock, GlobalVariable.TimeOut,FailureHandling.OPTIONAL)) {
				WebUI.verifyElementNotClickable(btn_AddToBasket)
				WebUI.click(svg_RemoveSize)
			}
			else if(WebUI.verifyElementNotPresent(p_OutOfStock, GlobalVariable.TimeOut,FailureHandling.OPTIONAL)) {
				WebUI.verifyElementClickable(btn_AddToBasket)
				WebUI.click(svg_RemoveSize)
			}

			WebUI.click(svg_ClickSize)
		}
	}
}
