package common.Verify

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

public class CheckProductIn2List {

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
	public void checkFlavorInAttribute(String flavor) {
		WebDriver driver = DriverFactory.getWebDriver()

		List<WebElement> productList = driver.findElements(By.xpath("//div[@data-test='productList']//a"))

		for (int i = 1; i <= productList.size(); i++) {
			WebUI.click(findTestObject('Product List Page (New)/Filter/div_Dynamic Pruduct List', [('no') : i]))

			WebUI.click(findTestObject('Product Detail Page (New)/Attribute/div_ATTRIBUTES'))

			String tempFlavor = WebUI.getText(findTestObject('Product Detail Page (New)/Attribute/li_Flavor title Attribute'))
			String flavorInAttribute =tempFlavor.substring(tempFlavor.lastIndexOf(": ") +2)
			WebUI.verifyEqual(flavor, flavorInAttribute)
		}
	}

}
