package commonFunctions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class CommonFunction {
	
	public static HashMap<String, String> Fn_GetExcelValue_IntoMap_UsingQuery(String filePath,String strQuery, String KeyName, String Value) throws FilloException {
		
		HashMap<String,String> hashmap = new HashMap<String,String>();
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(filePath);
		try
		{
			Recordset recordset = connection.executeQuery(strQuery);
			while(recordset.next()) {
				String strGetKey = recordset.getField(KeyName);
				String strGetValue = recordset.getField(Value);
				hashmap.put(strGetKey, strGetValue);
			}
			recordset.close();
			connection.close();
		}
		catch(Exception e) {
			System.out.println("Exeption in getting values from driver excel sheet "+e.getMessage());
		}
		return hashmap;
}
	
	/*
	 * public static String[] Fn_jsonReader(String filePath) throws IOException,
	 * ParseException {
	 * 
	 * JSONParser parser = new JSONParser(); FileReader reader = new
	 * FileReader(filePath); Object obj = parser.parse(reader); JSONObject jsonData
	 * = (JSONObject)obj; JSONArray suiteDetailsArray =
	 * (JSONArray)jsonData.get("SuiteDetails");
	 * 
	 * HashMap<String,String> hashmap = new HashMap<String,String>();
	 * 
	 * String array[] = new String[suiteDetailsArray.size()]; for(int
	 * i=0;i<suiteDetailsArray.size();i++) { JSONObject suiteDetails = (JSONObject)
	 * suiteDetailsArray.get(i); String suiteName = (String)
	 * suiteDetails.get("SuiteName"); String moduleName = (String)
	 * suiteDetails.get("ModuleName"); String browserType = (String)
	 * suiteDetails.get("BrowserType"); String passScreenShot = (String)
	 * suiteDetails.get("PassScreenShot"); String url = (String)
	 * suiteDetails.get("URL");
	 * 
	 * //array[i] =
	 * suiteName+","+moduleName+","+","+browserType+","+passScreenShot+","+url;
	 * //System.out.println(array[i] );
	 * 
	 * 
	 * } return array; //System.out.println(jsonData.get("Suite"));
	 * //System.out.println(jsonData.get("Module"));
	 * 
	 * 
	 * }
	 */
}
