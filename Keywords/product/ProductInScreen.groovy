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
import huypd.Product as Product
import internal.GlobalVariable

public class ProductInScreen {

	@Keyword
	public void saveInforOfProductInScreen(ArrayList<Product> productDetailInScreen) {
		String nameApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title Apple Juice'))
		String priceApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title price 3.00'))
		String sizeApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Bottle-size'),'value')
		String quantityApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Quantity'),'value')

		Product itemInScreen = new Product(priceApple, nameApple, sizeApple, quantityApple)
		productDetailInScreen.add(itemInScreen)
	}
}
