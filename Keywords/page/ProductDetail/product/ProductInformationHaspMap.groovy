package page.ProductDetail.product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.Model.Product

public class ProductInformationHaspMap {
	private TestObject div_PriceOnScreen = findTestObject('Product Detail Page (New)/Compononet Product/div_Price_On_Screen')
	private TestObject div_TitleOnScreen = findTestObject('Product Detail Page (New)/Compononet Product/div_Title_On_Screen')
	private TestObject div_SizeOnScreen = findTestObject('Product Detail Page (New)/Compononet Product/div_Size_On_Screen')
	private TestObject div_QuantityOnScreen = findTestObject('Product Detail Page (New)/Compononet Product/div_Quantity_On_Screen')

	@Keyword
	public void saveInforOfProductInScreenByHashMap(HashMap<String, HashMap<String,String>> productListInScreen) {

		String price = WebUI.getText(div_PriceOnScreen)
		String name = WebUI.getText(div_TitleOnScreen)
		String size = WebUI.getAttribute(div_SizeOnScreen,'value')
		String quantity = WebUI.getAttribute(div_QuantityOnScreen,'value')
		HashMap<String,String> innermap = new HashMap<String,String>()
		innermap.put("size",size)
		innermap.put("price",price)
		innermap.put("quantity",quantity)
		productListInScreen.put(name,innermap)
	}

	@Keyword
	public void saveInforOfProductInCartByHashMap(HashMap<String, HashMap<String,String>> productListInCart) {

		WebDriver driver = DriverFactory.getWebDriver()
		//list product in cart
		WebElement divUnit = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))
		List<WebElement> productList = divUnit.findElements(By.tagName("li"))
		//HashMap<String,String> innermap = new HashMap<String,String>()

		for (WebElement product : productList) {
			WebElement priceElement = product.findElement(By.xpath(".//p[@data-test='price']//span"))
			String price = priceElement.getText()
			WebElement nameElement = product.findElement(By.xpath('.//p[@data-test=\'name\']'))
			String name = nameElement.getText()
			WebElement sizeElement = product.findElement(By.xpath('.//span[@class=\'cart__list__item__details__variant\']//span[1]'))
			String size = sizeElement.getText()
			WebElement quantityElement = product.findElement(By.xpath('.//span[@class=\'cart__list__item__details__variant\']//span[last()]'))
			String quantity = quantityElement.getText().replaceAll('\\D', '')
			HashMap<String,String> innermap = new HashMap<String,String>()
			innermap.put("size",size)
			innermap.put("price",price)
			innermap.put("quantity",quantity)
			productListInCart.put(name,innermap)

		}


	}
}
