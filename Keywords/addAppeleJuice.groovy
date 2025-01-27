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

public class addAppeleJuice {

	private TestObject lab_Groceries = findTestObject('Common Header/MainMenu/MainMenu_Left/a_MainMenu')
	private TestObject div_AppleJuice = findTestObject('Main Menu/div_Apple Juice')
	private TestObject btn_AddToBasket = findTestObject('Product Detail Page (New)/Compononet Product/button_Add to basket')
	private TestObject svg_ClickSize = findTestObject('Product Detail Page (New)/Compononet Product/svg_Click size')
	private TestObject div_Size500ml = findTestObject('Product Detail Page (New)/Compononet Product/div_size 500ml')
	private TestObject inp_Quantity = findTestObject('Product Detail Page (New)/Compononet Product/div_Quantity_On_Screen')


	@Keyword
	public void clickGroceriesLabel () {
		WebUI.openBrowser(GlobalVariable.appUrl)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.waitForElementClickable(lab_Groceries, GlobalVariable.TimeOut)
		WebUI.click(lab_Groceries)
	}

	@Keyword
	public void addAppleJuice() {
		WebUI.waitForElementClickable(div_AppleJuice, GlobalVariable.TimeOut)
		WebUI.click(div_AppleJuice)
		WebUI.verifyElementNotClickable(btn_AddToBasket)
		WebUI.click(svg_ClickSize)
		WebUI.waitForElementClickable(div_Size500ml, GlobalVariable.TimeOut)
		WebUI.click(div_Size500ml)
		WebUI.setText(inp_Quantity, "2")
		WebUI.click(btn_AddToBasket)
		WebUI.waitForElementClickable(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'))
	}

	@Keyword
	public void addItem(String productName) {
	}

	@Keyword
	public void addBananaJuice() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/Banana Juice/div_Banana Juice1.50'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/Banana Juice/div_Banana Juice1.50'))
		WebUI.verifyElementNotClickable(btn_AddToBasket)
		WebUI.click(svg_ClickSize)
		WebUI.waitForElementClickable(div_Size500ml, GlobalVariable.TimeOut)
		WebUI.click(div_Size500ml)
		WebUI.setText(inp_Quantity, "1")
		WebUI.click(btn_AddToBasket)
	}
}




