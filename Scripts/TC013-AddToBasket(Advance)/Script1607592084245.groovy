import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.stringtemplate.v4.compiler.STParser.namedArg_return

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import common.Model.Product
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.appUrl)
CustomKeywords.'page.CommonHeader.menuLeft.Menu.MainMenu.clickMainMenu'("Groceries")

CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Apple Juice")
WebUI.waitForElementClickable(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'))

List<Product> productDetailInScreen = new ArrayList<Product>()

CustomKeywords.'page.ProductDetail.product.ProductInformationObject.saveInforOfProductInScreenUpdate'(productDetailInScreen)

WebUI.click(findTestObject('Object Repository/Product Detail Page (New)/tab_SubMenu'))
CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Apple Juice")

CustomKeywords.'page.ProductDetail.product.ProductInformationObject.saveInforOfProductInScreenUpdate'(productDetailInScreen)
WebUI.waitForElementClickable(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'), GlobalVariable.TimeOut)
WebUI.click(findTestObject('Common Header/MainMenu/MainMenu_Right/Cart Form/svg_Close Button'))

CustomKeywords.'page.CommonHeader.menuLeft.Menu.MainMenu.clickSubMenu'("Groceries", "Alcohol")
CustomKeywords.'page.ProductDetail.product.CommonProduct.addProduct'("Red Wine")
CustomKeywords.'page.ProductDetail.product.ProductInformationObject.saveInforOfProductInScreenUpdate'(productDetailInScreen)

List<Product> productDetailInCart = new ArrayList<Product>()
CustomKeywords.'page.ProductDetail.product.ProductInformationObject.saveInforOfProductInCart'(productDetailInCart)

//for(int i=0; i<productDetailInScreen.size();i++)
//{
//	println("sizeScreen:" + productDetailInScreen[i].getSize())
//	println("nameScreen :" +productDetailInScreen[i].getName())
//	println("priceScreen :"+productDetailInScreen[i].getPrice())
//	println("quantityScrenn :"+productDetailInScreen[i].getQuantity())
//}
//for(int i=0; i<productDetailInCart.size();i++)
//{
//	println("sizeScreen:" + productDetailInCart[i].getSize())
//	println("nameScreen :" +productDetailInCart[i].getName())
//	println("priceScreen :"+productDetailInCart[i].getPrice())
//	println("quantityScrenn :"+productDetailInCart[i].getQuantity())
//}

int a = CustomKeywords.'common.Verify.CheckProductIn2List.compareProductInList'(productDetailInCart, productDetailInScreen)
WebUI.verifyEqual(a, 1)

//for(int i=0; i<productDetailInScreen.size();i++)
//{
//	println("size :" + productDetailInScreen[i].getSize())
//	println("name :" +productDetailInScreen[i].getName())
//	println("price :"+productDetailInScreen[i].getPrice())
//	println("quantity :"+productDetailInScreen[i].getQuantity())
//}
