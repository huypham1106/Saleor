import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CheckSearch {

	final  String results_div = "//div[contains(@class,'search__products')]//ul/descendant::li[@class='search__products__item']"

	public void checkSearchFucntion(String url) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)

		WebDriver driver = DriverFactory.getWebDriver()
		//WebElement
		List<WebElement> product = driver.findElement(By.xpath(results_div))
		println('number of product' + product)

		//		WebUI.

	}
}
