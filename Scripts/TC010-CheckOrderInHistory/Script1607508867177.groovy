import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser("http://saleor-storefront.testing.coe.com/")
//CustomKeywords.'page.CommonHeader.menuRight.Login.loginIntoApp.loginWithExistingAccount'()
CustomKeywords.'page.CommonHeader.menuRight.Login.loginIntoApp.loginWithAccount'("http://saleor-storefront.testing.coe.com/", "huybd@example.com", "Admin@1234")
WebUI.waitForElementPresent(findTestObject('Common Header/MainMenu/MainMenu_Right/div_Profile_Icon'), GlobalVariable.TimeOut)
WebUI.mouseOver(findTestObject('Common Header/MainMenu/MainMenu_Right/div_Profile_Icon'))
WebUI.click(findTestObject('Object Repository/TC010/Order History/a_Order history'))


WebDriver driver = DriverFactory.getWebDriver()
WebElement prodctListElement = driver.findElement(By.xpath("//div[@class='category']//div[@data-test='productList']"))
List<WebElement> productList = prodctListElement.findElements(By.tagName("a"))