package dataprovider_example;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelPractice.ExcelExample2;

public class DATAPROVIDEREXAMPLE {

	@Test(dataProvider="Inputdata")
    public void instanceDbProvider(String keyName , LinkedHashMap<String,String> inputrowdat) {
        System.out.println("Instance DataProvider Example: Data(" + keyName + ", " + inputrowdat.get("Password") + ")");
    }   
     
    @DataProvider(name="Inputdata")
    public Object[][] getData() {
        
    	LinkedHashMap<String, LinkedHashMap<String, String>> sheetdata=ExcelExample2.getSheetData("login");
    	
    	Object[][] data = new Object[sheetdata.size()][2];  //initialize the array dimension
    	Set<String>sheetkeys=sheetdata.keySet();
    	
    	Iterator<String> itr=sheetkeys.iterator();
    	int counter=0;
    	while(itr.hasNext()){
    		String keyName=itr.next();
    		System.out.println(keyName);
    		LinkedHashMap<String,String> rowdata=sheetdata.get(keyName);
    		data[counter][0]=keyName;
			data[counter][1]=rowdata;
			counter++;
    		
    		
    	}
    	
    	return data;
    }
}
