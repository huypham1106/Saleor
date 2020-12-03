import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


CustomKeywords.'loginFunc.loginIntoApp'()
WebUI.click(findTestObject('Object Repository/Groceries/a_Groceries'))

temp = WebUI.getText(findTestObject('Object Repository/Groceries/span_Products found 13'))
String temp = temp.replaceAll("\\D","")
int totalPro = Integer.parseInt(temp)
for (int i = 1;i<=(totalPro/6); i++)
{
	WebUI.scrollToElement(findTestObject('Object Repository/Groceries/button_More'), GlobalVariable.TimeOut)
	WebUI.click(findTestObject('Object Repository/Groceries/button_More'))
	
}

WebDriver driver = DriverFactory.getWebDriver()
WebElement abc = driver.findElement(By.xpath("//div[@class='category']//div[@data-test='productList']"))
List<WebElement> rows_table = abc.findElements(By.tagName('a'))

//WebElement Table = driver.findElement(By.xpath("//div[@class='category']//div[@data-test='productList']"))
//List<WebElement> rows_table = Table.findElements(By.tagName('a'))

WebUI.verifyEqual(rows_table.size(), totalPro)
println('the total of products: '+rows_table.size())



