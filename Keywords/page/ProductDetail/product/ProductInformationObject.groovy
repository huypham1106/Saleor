package page.ProductDetail.product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.Model.Product
import internal.GlobalVariable

public class ProductInformationObject {



	@Keyword
	public void saveInforOfProductInScreen(ArrayList<Product> productDetailInScreen) {

		String priceApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_price 3.00'))
		String nameApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_Apple Juice'))
		String sizeApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Bottle-size'),'value')
		String quantityApple = WebUI.getAttribute(findTestObject('Product Detail Page (New)/Compononet Product/div_Quantity_On_Screen'),'value')

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

			Product itemInCart = new Product(price, name, quantity,size)
			productDetailInCart.add(itemInCart)
		}
	}
	
	@Keyword
	public void saveInforOfProductInScreenUpdate(ArrayList<Product> productDetailInScreen) {

		String priceApple = WebUI.getText(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_Price_On_Screen'))
		String nameApple = WebUI.getText(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_Title_On_Screen'))
		String sizeApple =""
		if(WebUI.verifyElementVisible(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_Size_On_Screen'), FailureHandling.OPTIONAL))
		{
		sizeApple = WebUI.getAttribute(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_Size_On_Screen'),'value')
		}
//		else if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_Size_On_Screen'),GlobalVariable.TimeOut ,FailureHandling.OPTIONAL))
//		{
//		sizeApple ="nulllll"
//		}

		String quantityApple = WebUI.getAttribute(findTestObject('Object Repository/Product Detail Page (New)/Compononet Product/div_Quantity_On_Screen'),'value')
		println("gia tri cua quantity la ===:" +quantityApple)
		println("gia tri cua title la ===:" + nameApple)

		int sumquantity = 0
		int quantityAppleOld = Integer.parseInt(quantityApple)
		if(productDetailInScreen.size()==0)
		{

			Product itemInScreen = new Product(priceApple, nameApple,quantityApple,sizeApple)
			productDetailInScreen.add(itemInScreen)
		}
		else if(productDetailInScreen.size()>0)
		{
			
			for(int i=0; i<productDetailInScreen.size();i++)
			{
				//println("nameApple"+nameApple +"nameInList"+productDetailInScreen[i].getName())
				if(nameApple.equals(productDetailInScreen[i].getName()))
				{
					sumquantity = Integer.parseInt(productDetailInScreen[i].getQuantity()) + quantityAppleOld
					quantityApple = String.valueOf(sumquantity)
					productDetailInScreen[i].setQuantity(quantityApple)
					break;
				}
				else
				{
					Product itemInScreen = new Product(priceApple, nameApple,quantityApple,sizeApple)
					productDetailInScreen.add(itemInScreen)
					break;
				}
			}

		}
		

	}
}








