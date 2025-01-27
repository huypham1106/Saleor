import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import common.Model.Product
import internal.GlobalVariable

public class CompareListt {

	@Keyword
	public boolean CompareProduct (List<Product> productDetailInCart ,List<Product> productDetailInScreen) {
		if (productDetailInCart!=null && productDetailInScreen!=null && productDetailInCart.size() == productDetailInScreen.size()) {
			for (Product Cartdata : productDetailInCart) {
				for (Product Screendata : productDetailInScreen) {
					if (Cartdata.getName().equals(Screendata.getName()) &&
					Cartdata.getPrice().equals(Screendata.getPrice()) &&
					Cartdata.getSize().equals(Screendata.getSize()) &&
					Cartdata.getQuantity().equals(Screendata.getQuantity())) {
						return  true;
					}
				}
			}
		}
		else {
			return false;
		}
		return false;
	}
}
