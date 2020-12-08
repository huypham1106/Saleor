import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable



public class SearchF_saleor {


	private TestObject Search_icon = findTestObject('Common Header/MainMenu/MainMenu_Right/div_Search_Icon')

	private TestObject Search_input = findTestObject('Object Repository/Home page/Search_input')


	private  TestObject results_div = findTestObject('//div[contains(@class,"search__products")]//ul/descendant::li[@class="search__products__item"]')
	@Keyword
	public void checkSearchFucntion(String url) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.TimeOut)

		//WebUI.waitForElementVisible(Search_icon, GlobalVariable.TimeOut)
		WebUI.click(Search_icon)
		WebUI.waitForElementVisible(Search_input, 6)
		WebUI.setText(Search_input, "hoo")


		WebDriver driver = DriverFactory.getWebDriver()
		//WebElement

		WebUI.delay(5)
		List<WebElement> list = driver.findElements(By.xpath('//div[contains(@class,"search__products")]//ul/descendant::li[@class="search__products__item"]'))
		println('number of product : ' + list.size())

		//		WebUI.

	}
}










