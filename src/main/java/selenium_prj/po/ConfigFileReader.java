package selenium_prj.po;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//this is a practice class only;it should not be in framework ; should be in base--?refer base package file

public class ConfigFileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//older ui match approach not used now
		String SourceFolder = System.getProperty("user.dir");
		File propertiesFileobj = new File(SourceFolder+"/Global/config.properties");
		FileInputStream fis = new FileInputStream(propertiesFileobj);
				Properties pro = new Properties();
				pro.load(fis);
				System.out.println(pro.get("username"));
				System.out.println(pro.getProperty("password"));
				System.out.println(pro.get("loginButton"));
	}

}
