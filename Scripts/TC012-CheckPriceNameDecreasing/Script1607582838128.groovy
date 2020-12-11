import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.ProductList.header.SortMenu.clickSortMenuItem'("Name Decreasing")
CustomKeywords.'page.ProductList.body.MoreProductButton.clickMoreButton'()
List<String> titleList = new ArrayList<String>()

WebDriver driver = DriverFactory.getWebDriver()
WebElement prodctListElement = driver.findElement(By.xpath("//div[@data-test='productList']"))
List<WebElement> productList = prodctListElement.findElements(By.tagName("a"))

for (WebElement product : productList) {
	WebElement priceElement = product.findElement(By.xpath(".//h4[@data-test='productTile']"))
	String title = priceElement.getText()
	KeywordUtil.logInfo(title)
	titleList.add(title)

}

println("list la : " +titleList)

int flag = CustomKeywords.'page.ProductList.commonVerify.SortItem.verifySortItemDecrease'(titleList)

WebUI.verifyEqual(flag,0)







