import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.CommonHeader.menuLeft.Menu.MainMenu.clickSubMenu'("Groceries", "Alcohol")
CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Red Wine")
WebUI.waitForElementVisible(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'))
WebUI.click(findTestObject('Product Detail Page (New)/tab_SubMenu'))
CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Seaman Beer")
CustomKeywords.'page.CommonHeader.menuRight.Cart.VerifyCart.verifyCartIsEmpty'()
WebUI.closeBrowser()






