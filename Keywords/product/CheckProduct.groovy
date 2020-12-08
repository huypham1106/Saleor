package product

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import model.Product as Product

public class CheckProduct {

	@Keyword
	public int compareProductInList(ArrayList<Product> productDetailInScreen,ArrayList<Product> productDetailInCart) {

		int flag=0;
		if ( productDetailInCart.size() == productDetailInScreen.size()) {
			for (Product Cartdata : productDetailInCart) {
				for (Product Screendata : productDetailInScreen) {
					if (Cartdata.getName().equals(Screendata.getName()) &&
					Cartdata.getPrice().equals(Screendata.getPrice()) &&
					Cartdata.getSize().equals(Screendata.getSize()) &&
					Cartdata.getQuantity().equals(Screendata.getQuantity())) {
						flag = 1
						break;
					}

					else {
						flag = 0
					}
				}
			}
		}
		else {
			flag = 0
		}
		return flag
	}

	@Keyword
	public void compareProductInListByHashMap(HashMap<String, HashMap<String,String>> productListInScreen,HashMap<String, HashMap<String,String>> productListInCart) {
		for (Map.Entry<String, HashMap<String,String>> entry1 : productListInScreen.entrySet()) {
			String key = entry1.getKey()
			String value1 = entry1.getValue()
			String value2 = productListInCart.get(key)
			WebUI.verifyEqual(value1, value2)
		}
	}

	@Keyword
	public void checkAddButton() {
		// mo 1 cai div de lay list size
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> sizeList = driver.findElements(By.xpath("//div[contains(@class,'iskUAR')]//div[contains(@class,'cDrDlU')]"))

		for (int i=1; i<=sizeList.size() ; i++)
		{
			WebUI.click(findTestObject('Product Detail Page (New)/div_size Common',['no': i]))
			if(WebUI.verifyElementPresent(findTestObject('Product Detail Page (New)/p_Out of stock'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL))

			{
				WebUI.verifyElementNotClickable(findTestObject('Product Detail Page (New)/button_Add to basket'))
				WebUI.click(findTestObject('Product Detail Page (New)/svg_Remove Size'))
			}
			else if(WebUI.verifyElementNotPresent(findTestObject('Product Detail Page (New)/p_Out of stock'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL))
			{
				WebUI.verifyElementClickable(findTestObject('Product Detail Page (New)/button_Add to basket'))
				WebUI.click(findTestObject('Product Detail Page (New)/svg_Remove Size'))
			}

			WebUI.click(findTestObject('Product Detail Page (New)/svg_Click size'))
		}
	}
	@Keyword
	public void checkFlavorInAttribute(String flavor) {
		WebDriver driver = DriverFactory.getWebDriver()

		List<WebElement> productList = driver.findElements(By.xpath("//div[@data-test='productList']//a"))

		for (int i = 1; i <= productList.size(); i++) {
			WebUI.click(findTestObject('Object Repository/Filter/div_Dynamic Pruduct List', [('no') : i]))

			WebUI.click(findTestObject('Object Repository/Apple Juice/Attribute/div_ATTRIBUTES'))

			String tempFlavor = WebUI.getText(findTestObject('Object Repository/Apple Juice/Attribute/li_Flavor title Attribute'))
			String flavorInAttribute =tempFlavor.substring(tempFlavor.lastIndexOf(": ") +2)
			WebUI.verifyEqual(flavor, flavorInAttribute)
		}
	}

}

