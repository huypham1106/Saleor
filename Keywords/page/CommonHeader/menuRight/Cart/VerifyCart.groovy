package page.CommonHeader.menuRight.Cart

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class VerifyCart {

	@Keyword
	public void verifyCartIsEmpty() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement productListElement = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))
		List<WebElement> productList = productListElement.findElements(By.tagName("li"))

		for(int i=0;i<productList.size();i++) {
			WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Remove',['no': i]))
		}

		WebUI.verifyElementText(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/lab_Your_bag_is_empty'), 'YOUR BAG IS EMPTY')
	}

	@Keyword
	public void verifyQuantityInCart() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement productListElement = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))

		List<WebElement> productList = productListElement.findElements(By.xpath("//span[@data-test='quantity']"))
		String tempTotalProduct = WebUI.getText(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/span_Total_product_in_cart')).replaceAll('\\D', '')
		int totalProduct = Integer.parseInt(tempTotalProduct)

		int sumProduct = 0

		List<Float> quantityList = new ArrayList<Float>()

		for (WebElement quantityOb : productList) {
			String tempQuantity = quantityOb.getText().replaceAll('\\D', '')
			float quantity = Float.parseFloat(tempQuantity)
			quantityList.add(quantity)
			sumProduct = (sumProduct + quantity)
		}
		WebUI.verifyEqual(totalProduct, sumProduct)
	}

	@Keyword
	public void verifyPriceInCart() {

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement productLisElement = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))

		List<WebElement> productList = productLisElement.findElements(By.xpath("//span[@data-test='quantity']"))

		List<Float> quantityList = new ArrayList<Float>()

		for (WebElement quantityOb : productList) {
			String tempQuantity = quantityOb.getText().replaceAll('\\D', '')
			float quantity = Float.parseFloat(tempQuantity)
			quantityList.add(quantity)
		}

		WebElement divPrice = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))

		List<WebElement> productPrice = divPrice.findElements(By.xpath("//p[@data-test='price']//span"))
		List<Float> priceList = new ArrayList<Float>()

		for (WebElement priceOb : productPrice) {
			String temp = priceOb.getText().replaceAll('\\D', '')
			float price = Float.parseFloat(temp)
			priceList.add(price)
		}

		float sumPrice=0
		for (int i = 0; i < productPrice.size(); i++) {
			sumPrice = sumPrice+(priceList[i] * quantityList[i])
		}

		String totalPriceWebElement= WebUI.getText(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/span_Total_price_in_cart'))
		String totalPriceText = totalPriceWebElement.replaceAll('\\D', '')
		int totalPrice = Float.parseFloat(totalPriceText)

		WebUI.verifyEqual(sumPrice,totalPrice)
	}
}
