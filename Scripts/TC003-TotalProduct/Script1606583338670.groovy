import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.CommonHeader.menuRight.Login.loginIntoApp.loginWithExistingAccount'()
CustomKeywords.'page.CommonHeader.menuLeft.Menu.MainMenu.clickMainMenu'("Groceries")
CustomKeywords.'page.ProductList.commonVerify.TotalProduct.verifyTotalProduct'()

// web bi loi khi click auto nhanh qua thi tu dong sinh ra dublicate san pham

