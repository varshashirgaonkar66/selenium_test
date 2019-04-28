package selenium_prj.po;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.BaseTest;

public class ExcelReadWrite  {
	//18-->creating filemap using sheet object
	static LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>>  getInputData 
	                         = new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>>();;

	public void getExcelFileData(String rootPath) {
		// TODO Auto-generated method stub
		
		//1-->to capture filepath
		String filePath = rootPath+"/Testdata/Login.xlsx";
		File f = new File(filePath);//creating file object and proving the location of file, file class;specified where the excel sheet is located
		
		
		//2->to read file
		FileInputStream fis; //FileInputStream class
		try {
			fis = new FileInputStream(f);//create object of FileInputStream,specify the file f;we need to specify filesource f as FileInputStream separate class that will accept file f
			
			//3-->convert fileobject to excel object
			XSSFWorkbook excel =new XSSFWorkbook(fis);//XSSFWorkbook class in Apache POI; it loads our excel workbook;creating an object n passing the filestream
			
			//4-->count number of used sheets available in workbook
			int noofSheets = excel.getNumberOfSheets();//returns the number of sheets in a workbook

			//System.out.println("No of excel sheets in a workbook is "+noofSheets);
			//LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>> getInputData = new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>>();
			
			//5-->loop for accessing all sheets in a workbook and printing their name--iterate sheet by sheet
			for (int i=0;i<noofSheets;i++){
				String Stname = excel.getSheetAt(i).getSheetName();//get the sheet at index 0 (i.e. first sheet and then get sheet name ; using the workbook object as the sheets are present inside the workbook)
				//getSheetAt --> at which index sheet is located and what is the name of that sheet
				//indes starts at 0
				//System.out.println("New Sheet "+Stname);//prints sheet names
				//i=0 ; Stname = login
				//i=1,Stname = Testing
				//i=2;Stname=Customer
				//i=3; Stname = Contact
				
				//6-->creating sheet objext
				//if(Stname.equals("login")){
				XSSFSheet Stobj=excel.getSheetAt(i); //accessing the sheet at index 0 i.e. login using workbook object and storing the sheet object 
				
				
				//and cell 3,4 are blank than cell 5 contains data then excel will consider cell five as last row and not the empty rows in between
				
				//7-->creating header row object
				XSSFRow headerObj=Stobj.getRow(0);//using sheet object now as the row sits in the sheet of a workbook
				//first row object ; to access only headers
				
				//8-->count number of used rows
				int noofRow = Stobj.getPhysicalNumberOfRows();//returns the actual number of rows populated with data; with cell 1,2 of a row contain data 
				
				
				//17-->creating sheetmap from rowmap
				LinkedHashMap<String,LinkedHashMap<String,String>> sheetMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
				//loop to access data which is starting at second row (index 1), header not considered at row zero is not accesses
				//
				//iterate used row by row
				for (int j =1;j<noofRow;j++)
				{
					
					XSSFRow rowObj = Stobj.getRow(j); // created a row object to access the rows with data starting from row 1
					
					//counting used column in current row object
					int noofColumn=rowObj.getLastCellNum(); //returns the last occupied column
					//System.out.println("number of columns "+noofColumn);
					
					//16--> creating rowmap from cell object
					LinkedHashMap<String,String> rowMap = new LinkedHashMap<String,String>();//stores the data of a row in a map
					
					//validating execution flag is set to Y or nor not in current row object
					//only access the test data where the value of cell 1, second column i.e. ExecutionFlag is Y
					if(rowObj.getCell(1).toString().equalsIgnoreCase("Y"))
					{
						
						//iterate column by column in current row object
					for (int k=0;k<noofColumn;k++) //0<4;1<4;2<4,3<4;4=4
					{
						//fetching header object from header row object
						XSSFCell headObj = headerObj.getCell(k);//creates obj of cell;accesses only one header row; 00 01 02 03
						
						//fetching cell object in current row object
						XSSFCell cellObj = rowObj.getCell(k);//creates obj of data
						
						String colName = headObj.toString();//print header
						String value = cellObj.toString();//prints data
						
						//System.out.println("column"+colName);
						//System.out.println("value "+value);
						rowMap.put(colName, value);//putting the values one at a time in rowmap
					}//after this loop we will get all the values
					}//since we are fetching only execution flag Y values clsing this loop then printing rowmap
					
					//System.out.println("RowMap"+rowMap);//prints column name and value pair stired in map
					String tcID=rowObj.getCell(0).toString();
					
					//we can store data now that the entire row data is stored against the TCID now
					sheetMap.put(tcID, rowMap);//1.0,column - value pair 
				}
				//print the values if ExecutionFlag is Y
				//System.out.println("sheet map "+sheetMap); //prints TC id value as unique key and the rows mapped against it columnvalue pair
				getInputData.put(Stname, sheetMap);
				//}

			}
			System.out.println(getInputData);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	//situation 1 -- get all the data from a sheet
	public static LinkedHashMap<String, LinkedHashMap<String, String>> getSheetData(String sheetName)
	{
		//getExcelFileData(projectRootpath);
		//System.out.println(getInputData.get(sheetName));
		return getInputData.get(sheetName);
	}
	
	//situation 2 --get data of a specific sheet and specific test case
	
	public static LinkedHashMap<String, String> getTestCaseData(String sheetName,String testcaseName){
		return getInputData.get(sheetName).get(testcaseName);
	}
	
	//situation 3 --get data of a specific sheet, specific test case and specific column
	public static String getTestCaseColumnData(String sheetName,String testcaseName,String cellName)
	{
		return getInputData.get(sheetName).get(testcaseName).get(cellName);
	}
	
}


