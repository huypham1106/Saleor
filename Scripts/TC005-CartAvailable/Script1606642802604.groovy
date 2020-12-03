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

CustomKeywords.'addProd.add2Product'()

WebUI.delay(5)

WebDriver driver = DriverFactory.getWebDriver()

//get list unit element
WebElement divUnit = driver.findElement(By.xpath('//div[@class=\'cart\']//ul[@class=\'cart__list\']'))

List<WebElement> productList = divUnit.findElements(By.xpath('//span[@data-test=\'quantity\']'))

//get list price element
WebElement divPrice = driver.findElement(By.xpath('//div[@class=\'cart\']//ul[@class=\'cart__list\']'))

List<WebElement> productPrice = divPrice.findElements(By.xpath('//p[@data-test=\'price\']//span'))

//Get total product in cart
totalProElement = WebUI.getText(findTestObject('Object Repository/MyBag/span_13 items'))
String totalProText = totalProElement.replaceAll('\\D', '')
int totalProduct = Integer.parseInt(totalProText)

int sumProduct = 0

List<Float> unitList = new ArrayList<Float>()

for (WebElement quantityOb : productList) {
	String actual_Text = quantityOb.getText()
	String temp = actual_Text.replaceAll('\\D', '')
	float quantity = Float.parseFloat(temp)
	unitList.add(quantity)
	sumProduct = (sumProduct + quantity)
}
WebUI.verifyEqual(totalProduct, sumProduct)

List<Float> priceList = new ArrayList<Float>()

for (WebElement priceOb : productPrice) {
    String actual_Text = priceOb.getText()
    String temp = actual_Text.replaceAll('\\D', '')
    float price = Float.parseFloat(temp)
    priceList.add(price)
}

float sumPrice=0
for (int i = 0; i < productPrice.size(); i++) {
	sumPrice = sumPrice+(priceList[i] * unitList[i])
}

totalPriceWebElement= WebUI.getText(findTestObject('Object Repository/MyBag/span_TotalPrice'))
String totalPriceText = totalPriceWebElement.replaceAll('\\D', '')
int totalPrice = Float.parseFloat(totalPriceText)

WebUI.verifyEqual(sumPrice,totalPrice)

println('the total of price: ' + totalPrice)
println('the total of price: ' + sumPrice)
println('the total of products: ' + sumProduct)
println('the total of products: ' + totalProduct)