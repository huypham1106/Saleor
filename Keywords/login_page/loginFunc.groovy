package login_page
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

public class loginFunc {

	@Keyword
	public void loginWithAccount (String appUrl, String userName, String passWord) {
		WebUI.openBrowser(appUrl)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Login/svg_Profile'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/Login/svg_Profile'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Login/input_Email'), GlobalVariable.TimeOut)
		WebUI.setText(findTestObject('Object Repository/Login/input_Email'), userName)
		WebUI.setText(findTestObject('Object Repository/Login/input_Password'), passWord)
		WebUI.click(findTestObject('Object Repository/Login/button_Sign in'))
	}

	@Keyword
	public void loginWithExistingAccount() {
		loginWithAccount(GlobalVariable.appUrl,GlobalVariable.userName ,GlobalVariable.passWord )
	}

	@Keyword
	public void verifyLoginSuccess() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/Login/svg_Profile'), GlobalVariable.TimeOut)
		WebUI.mouseOver(findTestObject('Object Repository/Login/svg_Profile'))
		WebUI.waitForElementClickable(findTestObject('Object Repository/Login/label_My Account'), GlobalVariable.TimeOut)
		WebUI.verifyElementText(findTestObject('Object Repository/Login/label_My Account'), "MY ACCOUNT")
	}
	
	@Keyword
	public void verifyLoginFail()
	{
		WebUI.getText(findTestObject('Object Repository/Login/span_ErrorMess'))
		WebUI.verifyElementText(findTestObject('Object Repository/Login/span_ErrorMess'), 'Please, enter valid credentials')
	}
}
