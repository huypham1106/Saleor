import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.windows.keyword.builtin.FindElementsKeyword as FindElementsKeyword
import huypd.Product as Product
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'addAppeleJuice.clickGroceriesLabel'()

CustomKeywords.'addAppeleJuice.addAppleJuice'()

priceApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_price 3.00'))
nameApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_Apple Juice'))
sizeApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Bottle-size'),'value')
quantityApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Quantity'),'value')

List<Product> productDetailInScreen = new ArrayList<Product>()
Product itemInScreen = new Product(priceApple, nameApple, sizeApple, quantityApple)
productDetailInScreen.add(itemInScreen)
  
WebUI.click(findTestObject('Object Repository/Banana Juice/a_Juices'))
CustomKeywords.'addAppeleJuice.addBananaJuice'()
nameApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_Apple Juice'))
priceApple = WebUI.getText(findTestObject('Object Repository/Apple Juice/title_price 3.00'))
sizeApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Bottle-size'),'value')
quantityApple = WebUI.getAttribute(findTestObject('Object Repository/Apple Juice/input_Quantity'),'value')

itemInScreen = new Product(priceApple, nameApple, sizeApple, quantityApple)
productDetailInScreen.add(itemInScreen)
 
   for (Product ob : productDetailInScreen) {
  	         println('the  title: ' + ob.price)
  	         println('the  title: ' + ob.name)
  	         println('the  title: ' + ob.size)
  	         println('the  title: ' + ob.quantity)
  	         println('========================')
  	    }

WebDriver driver = DriverFactory.getWebDriver()
//list product in cart
WebElement divUnit = driver.findElement(By.xpath('//div[@class=\'cart\']//ul[@class=\'cart__list\']'))
// cai nay phai dung tag name sau dung xpath no van chay
List<WebElement> productList = divUnit.findElements(By.xpath('li'))


List<Product> productDetailInCart = new ArrayList<Product>()

for (WebElement product : productList) {
    WebElement priceElement = product.findElement(By.xpath('.//p[@data-test=\'price\']'))
    String price = priceElement.getText()
    WebElement nameElement = product.findElement(By.xpath('.//p[@data-test=\'name\']'))
    String name = nameElement.getText()
    WebElement sizeElement = product.findElement(By.xpath('.//span[@class=\'cart__list__item__details__variant\']//span[1]'))
    String size = sizeElement.getText()
    WebElement quantityElement = product.findElement(By.xpath('.//span[@class=\'cart__list__item__details__variant\']//span[last()]'))
    String quantity = quantityElement.getText().replaceAll('\\D', '')

    Product itemInCart = new Product(price, name, size, quantity)
    productDetailInCart.add(itemInCart)

    for (Product ob : productDetailInCart) {
        println('the  title: ' + ob.price)
        println('the  title: ' + ob.name)
        println('the  title: ' + ob.size)
        println('the  title: ' + ob.quantity)
        println('========================')
    }
//    println(abc)
//    println('the total of title: ' + name)
//    println('the total of title: ' + price)
//    println('the total of title: ' + size)
//    println('the total of title: ' + quantity)
}
//CustomKeywords.'CompareListt.CompareProduct'(productDetailInCart, productDetailInScreen)

int flag=0;
if ( productDetailInCart.size() == productDetailInScreen.size()) 
		{
			for (Product Cartdata : productDetailInCart) 
			{
				for (Product Screendata : productDetailInScreen) 
				{
					if (Cartdata.getName().equals(Screendata.getName()) &&
					Cartdata.getPrice().equals(Screendata.getPrice()) &&
					Cartdata.getSize().equals(Screendata.getSize()) &&
					Cartdata.getQuantity().equals(Screendata.getQuantity())) 
					{ 
						flag = 1 
						break;
					} 
					
					else
					{
						flag = 0
					}
				}
			}
		}
		else
		{
			flag = 0
		}
	
	WebUI.verifyEqual(flag, 1)
