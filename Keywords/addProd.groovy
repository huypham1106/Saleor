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

public class addProd {

	private TestObject lab_Groceries = findTestObject('Object Repository/Groceries/a_Groceries')
	private TestObject lab_Alcohol = findTestObject('Object Repository/Alcohol/a_Alcohol')
	private TestObject div_RebW = findTestObject('Object Repository/Alcohol/div_Red Wine13.50')
	private TestObject btn_AddBasket = findTestObject('Object Repository/Alcohol/button_Add to basket')
	private TestObject btn_Close = findTestObject('Object Repository/MyBag/svg_Close Button')
	private TestObject tab_Alcohol = findTestObject('Object Repository/Alcohol/a_Alcohol(2)')
	private TestObject div_SeaB = findTestObject('Object Repository/Alcohol/div_Seaman Beer2.24')
	private TestObject txb_pid = findTestObject('Object Repository/Alcohol/button_Add to basket')


	@Keyword
	public void add2Product() {
		WebUI.openBrowser(GlobalVariable.appUrl)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.waitForElementClickable(lab_Groceries, GlobalVariable.TimeOut)
		WebUI.mouseOver(lab_Groceries)
		WebUI.waitForElementClickable(lab_Alcohol, GlobalVariable.TimeOut)
		WebUI.click(lab_Alcohol)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.waitForElementClickable(div_RebW, GlobalVariable.TimeOut)
		WebUI.click(div_RebW)
		WebUI.setText(findTestObject('Object Repository/Alcohol/input_Quantity'), "2")

		WebUI.click(btn_AddBasket)
		WebUI.waitForElementClickable(btn_Close, GlobalVariable.TimeOut)
		WebUI.click(btn_Close)

		WebUI.click(tab_Alcohol)
		WebUI.click(div_SeaB)
		WebUI.click(btn_AddBasket)
	}
}
