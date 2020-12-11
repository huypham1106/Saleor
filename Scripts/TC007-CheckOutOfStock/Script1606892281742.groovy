import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.CommonHeader.menuLeft.Menu.MainMenu.clickMainMenu'("Groceries")
CustomKeywords.'page.ProductDetail.product.CommonProduct.clickDivProduct'("Apple Juice")
CustomKeywords.'common.Verify.CheckProductIn2List.checkAddButton'()
WebUI.closeBrowser()



