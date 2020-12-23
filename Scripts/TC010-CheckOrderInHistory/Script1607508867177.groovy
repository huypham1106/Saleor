import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser("https://demo.saleor.io/")
//CustomKeywords.'page.CommonHeader.menuRight.Login.loginIntoApp.loginWithExistingAccount'()
WebUI.waitForPageLoad(GlobalVariable.TimeOut)
CustomKeywords.'page.CommonHeader.menuRight.Login.loginIntoApp.loginWithAccount'("https://demo.saleor.io", "admin@example.com", "admin")
WebUI.waitForElementVisible(findTestObject('Common Header/MainMenu/MainMenu_Right/div_Profile_Icon'), GlobalVariable.TimeOut)
WebUI.mouseOver(findTestObject('Common Header/MainMenu/MainMenu_Right/div_Profile_Icon'))
WebUI.waitForElementClickable(findTestObject('Object Repository/TC010/Order History/a_Order history'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/TC010/Order History/a_Order history'))

HashMap<String, HashMap<String,String>> orderInOrderHistory = new HashMap<String, HashMap<String,String>>()
CustomKeywords.'page.MyAccount.OrderHistory.Order.selectOrderAtLeast2Items'(orderInOrderHistory)
//WebUI.click(findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/div_Store_Dashboard'))
WebUI.navigateToUrl("https://demo.saleor.io/dashboard/")
WebUI.waitForPageLoad(GlobalVariable.TimeOut)
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboard page/btn_Login'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/Dashboard page/btn_Login'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboard Logged page/Left Menu/lbl_Order_LeftMenu'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/Dashboard Logged page/Left Menu/lbl_Order_LeftMenu'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboard Logged page/Left Menu/lbl_Order_Submenu'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/Dashboard Logged page/Left Menu/lbl_Order_Submenu'))

HashMap<String, HashMap<String,String>> orderInOrderDashBoard = new HashMap<String, HashMap<String,String>>()
CustomKeywords.'page.MyAccount.OrderHistory.Order.compareOrderAtLeast2Product'( orderInOrderDashBoard,orderInOrderHistory)
CustomKeywords.'common.Verify.CheckProductIn2List.compareProductInListByHashMap'(orderInOrderHistory,orderInOrderDashBoard)

	for (String key : orderInOrderHistory.values()) {
		println("gia tri trong History" +key)
	}
	
	for (String key : orderInOrderDashBoard.values()) {
		println("gia tri trong Dashboard" +key)
	}






