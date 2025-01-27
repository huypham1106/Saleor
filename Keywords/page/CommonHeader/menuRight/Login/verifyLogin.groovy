package page.CommonHeader.menuRight.Login

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

public class verifyLogin {
	private TestObject div_Profile_Icon = findTestObject('Common Header/MainMenu/MainMenu_Right/div_Profile_Icon')
	private TestObject lbl_My_Account = findTestObject('Common Header/MainMenu/MainMenu_Right/Logged In/label_My Account')
	private TestObject span_ErrorMess = findTestObject('Common Header/MainMenu/MainMenu_Right/Login Form/span_ErrorMess')
	
	
	@Keyword
	public void verifyLoginSuccess() {
		WebUI.waitForElementPresent(div_Profile_Icon, GlobalVariable.TimeOut)
		WebUI.mouseOver(div_Profile_Icon)
		WebUI.waitForElementClickable(lbl_My_Account, GlobalVariable.TimeOut)
		WebUI.verifyElementText(lbl_My_Account, "MY ACCOUNT")
	}

	@Keyword
	public void verifyLoginFail() {
		// bo get text ra no bi loi ko lay dc text
		//WebUI.getText(findTestObject('Common Header/MainMenu/MainMenu_Right/Login Form/span_ErrorMess'))
		WebUI.verifyElementText(span_ErrorMess, 'Please, enter valid credentials')
	}
}
