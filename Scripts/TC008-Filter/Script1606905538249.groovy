import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

CustomKeywords.'addAppeleJuice.clickGroceriesLabel'()

//List<WebElement> productList = driver.findElements(By.xpath("//div[@data-test='productList']//a"))
String flavor = "Orange"

//List<Product> list = new List<Product>()

CustomKeywords.'filter_Function.Filter.selectFlavors'(flavor)
//CustomKeywords.'filter_Function.Filter.selectFlavors'(list)

//WebDriver driver = DriverFactory.getWebDriver()
//
//List<Product> productList = driver.findElements(By.xpath("//div[@data-test='productList']//a"))
//
//for (int i = 1; i <= productList.size(); i++) {
//    WebUI.click(findTestObject('Object Repository/Filter/div_Dynamic Pruduct List', [('no') : i]))
//
//    WebUI.click(findTestObject('Object Repository/Apple Juice/Attribute/div_ATTRIBUTES'))
//
//    String text = WebUI.getText(findTestObject('Object Repository/Apple Juice/Attribute/li_Flavor title Attribute'))
//
//    WebUI.verifyEqual(flavor, text)
//}

//CustomKeywords.'addAppeleJuice.addAppleJuice'()

