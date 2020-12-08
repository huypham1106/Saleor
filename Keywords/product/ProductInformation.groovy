package product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import model.Product as Product

public class ProductInformation {



	@Keyword
	public void saveInforOfProductInScreen(ArrayList<Product> productDetailInScreen) {

		String priceApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_price 3.00'))
		String nameApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_Apple Juice'))
		String sizeApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Bottle-size'),'value')
		String quantityApple = WebUI.getAttribute(findTestObject('Product Detail Page (New)/Compononet Product/input_Quantity'),'value')

		Product itemInScreen = new Product(priceApple, nameApple, sizeApple, quantityApple)
		productDetailInScreen.add(itemInScreen)
	}

	@Keyword
	public void saveInforOfProductInCart(ArrayList<Product> productDetailInCart) {
		WebDriver driver = DriverFactory.getWebDriver()
		//list product in cart
		WebElement divUnit = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))
		List<WebElement> productList = divUnit.findElements(By.xpath('li'))

		for (WebElement product : productList) {
			WebElement priceElement = product.findElement(By.xpath('.//p[@data-test=\'price\']'))
			String price = priceElement.getText()
			WebElement nameElement = product.findElement(By.xpath('.//p[@data-test=\'name\']'))
			String name = nameElement.getText()
			WebElement sizeElement = product.findElement(By.xpath('.//span[@class=\'cart__list__item__details__variant\']//span[1]'))
			String size = sizeElement.getText()
			WebElement quantityElement = product.findElement(By.xpath('.//span[@class=\'cart__list__item__details__variant\']//span[last()]'))
			String quantity = quantityElement.getText().replaceAll('\\D', '')

			Product itemInCart = new Product(price, name, size, quantity)
			productDetailInCart.add(itemInCart)
		}
	}
}
