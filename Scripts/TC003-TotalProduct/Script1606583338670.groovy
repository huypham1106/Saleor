import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'common_Header.loginFunc.loginWithExistingAccount'()
CustomKeywords.'menu_bar.MainMenu.clickMainMenu'("Groceries")
CustomKeywords.'product.ProductList.verifyTotalProduct'()

// web bi loi khi click auto nhanh qua thi tu dong sinh ra dublicate san pham

