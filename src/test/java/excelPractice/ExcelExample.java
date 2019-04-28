package excelPractice;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;


public class ExcelExample {

	public static void main(String[] args)
	{
		String rootPath = System.getProperty("user.dir");
		String filePath = rootPath+"/Testdata/InputTestData.xlsx";
		File f = new File(filePath);
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			XSSFWorkbook excel =new XSSFWorkbook(fis);
			int noofSheets = excel.getNumberOfSheets();

			for (int i=0;i<noofSheets;i++){
				String Stname = excel.getSheetAt(i).getSheetName();
				System.out.println("New Sheet "+Stname);

				//if(Stname.equals("login")){
					XSSFSheet Stobj=excel.getSheetAt(i);
					int noofRow = Stobj.getPhysicalNumberOfRows();

					for (int j =0;j<noofRow;j++)
					{
						XSSFRow rowObj = Stobj.getRow(j);
						int noofColumn=rowObj.getLastCellNum();
						//if(rowObj.getCell(1).toString().equalsIgnoreCase("Y"))
						//{
							for (int k=0;k<noofColumn;k++)
							{
								XSSFCell cellObj = rowObj.getCell(k);
								String value = cellObj.toString();
								System.out.println(value);
							}
						//}
					}
					//print the values if ExecutionFlag is Y

				//}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
