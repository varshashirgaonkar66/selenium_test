package excelPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String rootPath = System.getProperty("user.dir");
		String filePath = rootPath+"/Testdata/Data.xlsx";
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook excel =new XSSFWorkbook(fis);
		XSSFSheet Stobj=excel.getSheetAt(0);
		String data0 =Stobj.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data0);
		String data1 =Stobj.getRow(0).getCell(1).getStringCellValue();
		System.out.println(data1);
		
		Stobj.getRow(0).createCell(2).setCellValue("Result");
		Stobj.getRow(1).createCell(2).setCellValue("Pass");
		Stobj.getRow(2).createCell(2).setCellValue("fail");
		
		FileOutputStream fout = new FileOutputStream(f);
		excel.write(fout);
		excel.close();
	}

}
