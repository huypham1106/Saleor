package product
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CommonProduct {

	private TestObject lab_Groceries = findTestObject('Common Header/MainMenu/MainMenu_Left/a_MainMenu')
	private TestObject lab_Alcohol = findTestObject('Common Header/MainMenu/MainMenu_Left/SubMenu_Left/a_SubMenu')
	private TestObject div_RebW = findTestObject('Product List Page (New)/div_Product')
	private TestObject btn_AddBasket = findTestObject('Product/button_Add to basket')
	private TestObject btn_Close = findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button')
	private TestObject tab_Alcohol = findTestObject('Product Detail Page (New)/tab_SubMenu')
	private TestObject div_SeaB = findTestObject('Product/div_Seaman Beer2.24')
	private TestObject txb_pid = findTestObject('Product/button_Add to basket')


	@Keyword
	public void addProduct(String productName) {
		WebUI.waitForElementClickable(findTestObject('Product List Page (New)/div_Product',['name': productName]), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Product List Page (New)/div_Product',['name': productName]))

		if(WebUI.verifyElementPresent(findTestObject('Product Detail Page (New)/svg_Click size'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Product Detail Page (New)/svg_Click size'))
			WebUI.waitForElementClickable(findTestObject('Product Detail Page (New)/div_size 500ml'), GlobalVariable.TimeOut)
			WebUI.click(findTestObject('Product Detail Page (New)/div_size 500ml'))
		}

		WebUI.setText(findTestObject('Product/input_Quantity'), "2")
		WebUI.click(btn_AddBasket)
		WebUI.waitForElementClickable(btn_Close, GlobalVariable.TimeOut)
	}

	@Keyword
	public void clickDivProduct(String productName) {
		WebUI.waitForElementClickable(findTestObject('Product List Page (New)/div_Product',['name': productName]), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Product List Page (New)/div_Product',['name': productName]))

		if(WebUI.verifyElementPresent(findTestObject('Product Detail Page (New)/svg_Click size'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Product Detail Page (New)/svg_Click size'))
		}
	}
}
