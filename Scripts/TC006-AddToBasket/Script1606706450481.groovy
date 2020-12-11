import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.CommonHeader.menuLeft.Menu.MainMenu.clickMainMenu'("Groceries")

CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Apple Juice")
WebUI.waitForElementVisible(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'))

HashMap<String, HashMap<String,String>> productListInScreen = new HashMap<String, HashMap<String,String>>()
CustomKeywords.'page.ProductDetail.product.ProductInformationHaspMap.saveInforOfProductInScreenByHashMap'(productListInScreen)
CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Banana Juice")
CustomKeywords.'page.ProductDetail.product.ProductInformationHaspMap.saveInforOfProductInScreenByHashMap'(productListInScreen)



HashMap<String, HashMap<String,String>> productListInCart = new HashMap<String, HashMap<String,String>>()
CustomKeywords.'page.ProductDetail.product.ProductInformationHaspMap.saveInforOfProductInCartByHashMap'(productListInCart)
CustomKeywords.'common.Verify.CheckProductIn2List.compareProductInListByHashMap'(productListInScreen, productListInCart)
WebUI.closeBrowser()
//for (Map.Entry<String, HashMap<String,String>> entry1 : productListInScreen.entrySet()) {
//	String key = entry1.getKey()
//	String value1 = entry1.getValue()
//	String value2 = productListInCart.get(key)
//	WebUI.verifyEqual(value1, value2)
//  }

