import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.ProductList.header.SortMenu.clickSortMenuItem'("Price High-Low")
CustomKeywords.'page.ProductList.body.MoreProductButton.clickMoreButton'()

WebDriver driver = DriverFactory.getWebDriver()
WebElement prodctListElement = driver.findElement(By.xpath("//div[@data-test='productList']"))
List<WebElement> productList = prodctListElement.findElements(By.tagName("a"))

List<String> priceList = new ArrayList<String>();


for (WebElement product : productList) {
	WebElement priceElement = product.findElement(By.xpath(".//p[@data-test='productPrice']"))
	String priceTemp = priceElement.getText().replaceAll('\\D', '')
	KeywordUtil.logInfo(priceTemp)
	int price = Integer.parseInt(priceTemp)
	priceList.add(price)

}
println("list la : " + priceList)
int flag = CustomKeywords.'page.ProductList.commonVerify.SortItem.verifySortItemDecrease'(priceList)

//int flag=0
//for( int i=0; i < priceList.size()-1;i++) {
//	if (priceList[i] < priceList[i+1]) {
//		flag = 1
//		break;
//	}
//}
println("gia tri cua flag:" + flag)

WebUI.verifyEqual(flag,0)



