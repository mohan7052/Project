package testCases;

import java.io.IOException;
import java.util.Arrays;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import commonFunctions.CommonFunction;

public class Driver {
	
	public static String strDriverSheet = ".\\Input\\DriverInputSheet.xlsx";
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		//CommonFunction.Fn_GetExcelValue_UsingQuery(strDriverSheet, "select * from Driver_ where TobeExecuted='Yes' ", Arrays.asList("Suite"), false);

	}

}
