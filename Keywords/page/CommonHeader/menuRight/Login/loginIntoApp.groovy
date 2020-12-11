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

public class loginIntoApp {
	
	private TestObject div_Profile_Icon = findTestObject('Common Header/MainMenu/MainMenu_Right/div_Profile_Icon')
	private TestObject inp_Email = findTestObject('Common Header/MainMenu/MainMenu_Right/Login Form/input_Email')
	private TestObject ipu_Password = findTestObject('Common Header/MainMenu/MainMenu_Right/Login Form/input_Password')
	private TestObject btn_Email = findTestObject('Common Header/MainMenu/MainMenu_Right/Login Form/button_Sign_In')
	
	@Keyword
	public void loginWithAccount (String appUrl, String userName, String passWord) {
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)
		WebUI.waitForElementVisible(div_Profile_Icon, GlobalVariable.TimeOut)
		WebUI.click(div_Profile_Icon)
		WebUI.waitForElementVisible(inp_Email, GlobalVariable.TimeOut)
		WebUI.setText(inp_Email, userName)
		WebUI.setText(ipu_Password, passWord)
		WebUI.click(btn_Email)
	}

	@Keyword
	public void loginWithExistingAccount() {
		loginWithAccount(GlobalVariable.appUrl,GlobalVariable.userName ,GlobalVariable.passWord )
	}
}
