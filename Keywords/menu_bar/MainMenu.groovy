package menu_bar

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

public class MainMenu {

	@Keyword
	public void clickMainMenu(String mainMenu) {
		WebUI.waitForElementClickable(findTestObject('Object Repository/Groceries/a_Groceries',['name': mainMenu]), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/Groceries/a_Groceries',['name': mainMenu]))
	}

	@Keyword
	public void clickSubMenu( String mainMenu,String subMenu) {
		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Groceries/a_Groceries',['name':mainMenu]), GlobalVariable.TimeOut)
		WebUI.mouseOver(findTestObject('Object Repository/Groceries/a_Groceries',['name':mainMenu]))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Alcohol/a_Alcohol',['name':subMenu]),GlobalVariable.TimeOut )
		WebUI.click(findTestObject('Object Repository/Alcohol/a_Alcohol',['name':subMenu]))
	}
}
