package page.MyAccount.OrderHistory
import common.Verify.Convert as Convert
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Order {
	
	@Keyword
	public void selectOrderAtLeast2Items(HashMap<String, HashMap<String,String>> orderInOrderHistory) 
	{
		WebDriver driver = DriverFactory.getWebDriver()
		//WebElement prodctListElement = driver.findElement(By.xpath("//div[@class='account__content']"))
		//List<WebElement> orderList = driver.findElements(By.xpath("//div[@class='account__content']//following-sibling::div[@data-test='orderEntry']"))
		
		//List<WebElement> ItemInOrderList = prodctListElement.findElements(By.xpath("//div[@data-test-id='4268']/div[2]/span"))
		
		String indexNumber=""
		String dateOfOrder=""
		String value=""
		String status=""
		
		String xpath = "//div[@class='account__content']//div[@data-test='orderEntry'][num]/div[2]/span"
		boolean flag = true
		int count=1
		while(flag)
		{
			
		WebUI.delay(5)
		List<WebElement> orderList = driver.findElements(By.xpath("//div[@class='account__content']//following-sibling::div[@data-test='orderEntry']"))
		WebUI.waitForElementPresent(findTestObject('Object Repository/My Account Page/Order history/div_Item_Last'),GlobalVariable.TimeOut)
		println("orderList size la :"+orderList.size())
			for(int i=count; i<=orderList.size();i++)
			{
				//String xpath = "//div[@data-test-id='4268']/div[2]/span"
				String replaceXpath = xpath.replace('num', String.valueOf(i))
				List<WebElement> ItemInOrderList = driver.findElements(By.xpath(replaceXpath))
				if(ItemInOrderList.size()>=2)
				{
					indexNumber=WebUI.getText(findTestObject('Object Repository/My Account Page/Order history/div_4124',['no': i]))
					dateOfOrder=WebUI.getText(findTestObject('Object Repository/My Account Page/Order history/div_1292020',['no': i]))
					value=WebUI.getText(findTestObject('Object Repository/My Account Page/Order history/span_163.97',['no': i]))
					status=WebUI.getText(findTestObject('Object Repository/My Account Page/Order history/div_Unfulfilled',['no': i]))
					
					WebUI.click(findTestObject('Object Repository/My Account Page/Order history/div_item_common',['no':i]))
					flag = false
					break;
					
				}
			}
				if(flag==true)
				{
				WebUI.scrollToElement(findTestObject('Object Repository/My Account Page/Order history/btn_LoadMore'), GlobalVariable.TimeOut)
				WebUI.click(findTestObject('Object Repository/My Account Page/Order history/btn_LoadMore'))
				
				count+=5
				}
		}
		HashMap<String,String> innermap = new HashMap<String,String>()
		innermap.put("date",dateOfOrder)
		innermap.put("value",value)
		innermap.put("status",status)
		orderInOrderHistory.put(indexNumber,innermap)
	}
	
	@Keyword
	public void compareOrderAtLeast2Product(HashMap<String, HashMap<String,String>> orderInOrderDashboard,HashMap<String, HashMap<String,String>> orderInOrderHistory)
	{
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(5)
		List<WebElement> orderList = driver.findElements(By.xpath("//tbody[@class='MuiTableBody-root']/tr"))
		println("gia tri cua orderList la :"+orderList.size())
		for (Map.Entry<String, String> entry : orderInOrderHistory.entrySet()) {
				String idOrder = entry.getKey();
				println("gia tri id in Order"+idOrder)
			
			//WebElement priceElement = product.findElement(By.xpath(".//p[@data-test='price']//span"))
			//String price = priceElement.getText()
		for(int i=1 ;i<=orderList.size();i++)
		{
			String idDashBoard = WebUI.getText(findTestObject('Object Repository/Dashboard Logged page/Oder page/lbl_Id_Dynamic',['no':i])).replaceAll('\\D','')
			println("gia tri id in Dashboard"+idDashBoard)
			if (idOrder.equals(idDashBoard))
			{
				println("no vo day ne ==========")
				String dateOfOrderTemp = WebUI.getAttribute(findTestObject('Object Repository/Dashboard Logged page/Oder page/lbl_Date',['no':i]), 'title')
				println("in dateoforder =========="+dateOfOrderTemp)
				Convert check = new Convert()
				String dateOfOrder = check.ConvertTime(dateOfOrderTemp)
				String status = WebUI.getText(findTestObject('Object Repository/Dashboard Logged page/Oder page/lbl_Status',['no':i]))
				String value = WebUI.getText(findTestObject('Object Repository/Dashboard Logged page/Oder page/lbl_Price',['no':i]))
				HashMap<String,String> innermap = new HashMap<String,String>()
				innermap.put("date",dateOfOrder)
				innermap.put("value",value)
				innermap.put("status",status)
				orderInOrderDashboard.put(idDashBoard,innermap)
				break;
			}
		
		}
			}
	}
	
}
