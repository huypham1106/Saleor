import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser(GlobalVariable.appUrl)
WebUI.waitForPageLoad(GlobalVariable.TimeOut)
WebUI.waitForElementClickable(findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/div_Search_Icon'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/div_Search_Icon'))
WebUI.sendKeys(findTestObject('Common Header/MainMenu/MainMenu_Right/Search Form/input_Search_Keyword'), "hoo")
WebUI.click(findTestObject('Object Repository/Common Header/MainMenu/MainMenu_Right/Search Form/button_Show all results'))

WebDriver driver = DriverFactory.getWebDriver()
WebUI.waitForElementPresent(findTestObject('Object Repository/Result Search Page/div_Proudct_to_wait'), GlobalVariable.TimeOut)

List<WebElement> productList = driver.findElements(By.xpath("//div[@data-test='productList']/a"))
List<String> titleProductList = new ArrayList<String>()

for (WebElement product : productList) 
{
	WebElement titleElement = product.findElement(By.xpath(".//h4[@data-test='productTile']"))
	String titleProduct = titleElement.getText()
	KeywordUtil.logInfo(titleProduct)
	WebUI.verifyMatch(titleProduct,"(?i).*hoo.*", true)
	
}










