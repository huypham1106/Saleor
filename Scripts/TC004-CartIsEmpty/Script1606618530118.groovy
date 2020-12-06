import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'menu_bar.MainMenu.clickSubMenu'("Groceries", "Alcohol")
CustomKeywords.'product.AlcoholProduct.addProduct'("Red Wine")
WebUI.click(findTestObject('Object Repository/MyBag/svg_Close Button'))
WebUI.click(findTestObject('Object Repository/Alcohol/a_Alcohol(2)'))
CustomKeywords.'product.AlcoholProduct.addProduct'("Seaman Beer")
CustomKeywords.'cart.CartInHomePage.verifyCartIsEmpty'()
WebUI.closeBrowser()






