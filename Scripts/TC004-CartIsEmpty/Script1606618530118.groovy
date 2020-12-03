import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'addProd.add2Product'()





//WebElement div = driver.findElement(By.xpath(""))
//List<WebElement> productList = div.findElements(By.tagName("li"))
WebUI.delay(5)
WebDriver driver = DriverFactory.getWebDriver()
WebElement div = driver.findElement(By.xpath("//div[@class='cart']//ul[@class='cart__list']"))
List<WebElement> productList = div.findElements(By.tagName("li"))


println('the total of products: '+productList.size())

for(int i=0;i<productList.size();i++)
{
	WebUI.click(findTestObject('Object Repository/MyBag/svg_Remove',['no': i]))
}

WebUI.verifyElementText(findTestObject('Object Repository/MyBag/h4_Your bag is empty'), 'YOUR BAG IS EMPTY')







