package page.CommonHeader.menuLeft.Menu

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
	private TestObject div_Profile_Icon = findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/div_Profile_Icon')

	@Keyword
	public void clickMainMenu(String mainMenu) {
		WebUI.waitForElementPresent(div_Profile_Icon, GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Left/a_MainMenu',['name': mainMenu]))
	}

	@Keyword
	public void clickSubMenu( String mainMenu,String subMenu) {
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.waitForElementPresent(findTestObject('Common Header/MainMenu/MainMenu_Left/a_MainMenu',['name':mainMenu]), GlobalVariable.TimeOut)
		WebUI.mouseOver(findTestObject('Common Header/MainMenu/MainMenu_Left/a_MainMenu',['name':mainMenu]))
		WebUI.waitForElementClickable(findTestObject('Common Header/MainMenu/MainMenu_Left/SubMenu_Left/a_SubMenu',['name':subMenu]),GlobalVariable.TimeOut )
		WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Left/SubMenu_Left/a_SubMenu',['name':subMenu]))
	}
}
