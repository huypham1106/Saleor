package common.Verify

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

import internal.GlobalVariable
import java.util.regex.Matcher
import java.util.regex.Pattern

public class Convert {
	
	@Keyword
	public String ConvertTime(String mydata)
	{
		//String mydata = "Dec 17, 2020 7:53 AM";//12/17/2020
		
			Pattern pattern = Pattern.compile("(^[a-zA-Z]{3})\\s(\\d[0-9])\\,\\s(\\d{1,4})");
			Matcher matcher = pattern.matcher(mydata);
			
			if(matcher.find())
			{
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			}
			
			String month="";
			switch (matcher.group(1)) {
			case "Jan": 
				month="1";
			
			case "Feb": 
				month="2";
			
			case "Mar": 
				month="3";
			
			case "Apr": 
				month="4";
			
			case "May": 
				month="5";
			
			case "Jun": 
				month="6";
			
			case "Jul": 
				month="7";
			
			case "Aug": 
				month="8";
			
			case "Sep": 
				month="9";
			
			case "Oct": 
				month="10";
			
			case "Nov": 
				month="11";
			
			case "Dec": 
				month="12";
			
			default:
				break;
			}
			
			String time = month +"/"+matcher.group(2)+"/"+matcher.group(3);
			return time
	}
}
