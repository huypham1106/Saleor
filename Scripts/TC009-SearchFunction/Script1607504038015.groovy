import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser(GlobalVariable.appUrl)
WebUI.waitForPageLoad(GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/div_Search_Icon'))
//WebUI.setText(findTestObject('Common Header/MainMenu/MainMenu_Right/Search Form/input_Search_Keyword'), "hoo")
WebUI.sendKeys(findTestObject('Common Header/MainMenu/MainMenu_Right/Search Form/input_Search_Keyword'), "hoo")
WebUI.click(findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/Search Form/button_Show all results'))
WebDriver driver = DriverFactory.getWebDriver()
WebElement CartElement = driver.findElement(By.xpath("//div[@data-test='productList']"))
List<WebElement> productList = CartElement.findElements(By.tagName("a"))

List<String> titleProductList = new List<String>()

//for(int i=0; i<productList.size();i++)
//{
//	String temp = WebUI.getText(findTestObject('Object Repository/Result Search Page/h4_Black Hoodie'))
//	
//}

for (WebElement product : productList) 
{
	WebElement titleElement = product.findElement(By.xpath(".//h4[@data-test='productTile']"))
	String titleProduct = titleElement.getText()
	//tiffff
}










