import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



CustomKeywords.'addAppeleJuice.clickGroceriesLabel'()

WebUI.waitForElementClickable(findTestObject('Object Repository/Groceries/div_Apple Juice'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/Groceries/div_Apple Juice'))
WebUI.verifyElementNotClickable(findTestObject('Object Repository/Apple Juice/button_Add to basket'))
WebUI.click(findTestObject('Object Repository/Apple Juice/svg_Click size'))

WebDriver driver = DriverFactory.getWebDriver()
//div[contains(@class,'iskUAR')]
//WebElement divUnit = driver.findElement(By.xpath('//div[@class=\'cart\']//ul[@class=\'cart__list\']'))
// cai nay phai dung tag name sau dung xpath no van chay
List<WebElement> sizeList = driver.findElements(By.xpath("//div[contains(@class,'iskUAR')]//div[contains(@class,'cDrDlU')]"))

for (int i=1; i<=sizeList.size() ; i++)
{
	WebUI.click(findTestObject('Object Repository/Apple Juice/div_size Common',['no': i]))
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/Apple Juice/p_Out of stock'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL))
		
	{
				WebUI.verifyElementNotClickable(findTestObject('Object Repository/Apple Juice/button_Add to basket'))
				WebUI.click(findTestObject('Object Repository/Apple Juice/svg_Remove Size'))
	}
	else if(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Apple Juice/p_Out of stock'), GlobalVariable.TimeOut,FailureHandling.OPTIONAL))
	{
		WebUI.verifyElementClickable(findTestObject('Object Repository/Apple Juice/button_Add to basket'))
		WebUI.click(findTestObject('Object Repository/Apple Juice/svg_Remove Size'))
	}

	WebUI.click(findTestObject('Object Repository/Apple Juice/svg_Click size'))
}

//println("size is : " +sizeList.size())

//if(WebUI.verifyElementNotPresent(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Apple Juice/p_Out of stock'), GlobalVariable.TimeOut))
//	{
//		println("no vo day ne  =======")
//		WebUI.verifyElementNotClickable(findTestObject('Object Repository/Apple Juice/button_Add to basket'))
//		WebUI.click(findTestObject('Object Repository/Apple Juice/svg_Remove Size'))
//		
//	}
//	else if(WebUI.verifyElementNotPresent(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Apple Juice/p_Out of stock'), GlobalVariable.TimeOut))
//	{
//		//WebUI.verifyElementClickable(findTestObject('Object Repository/Apple Juice/button_Add to basket'))
//		//WebUI.click(findTestObject('Object Repository/Apple Juice/svg_Remove Size'))
//	}


