package Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader_old {

	
	Properties pro;
	String sourceFolder;
	public ConfigFileReader_old(String sourceFolder)
	{
		this.sourceFolder=sourceFolder;
		loadPropertiesFile();
	}
	public void loadPropertiesFile() {
		try {
			File propertiesFileObj = new File(sourceFolder+"/Global/config_new.properties");
			FileInputStream fls = new FileInputStream(propertiesFileObj);
			pro = new Properties();
			pro.load(fls);
			fls.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}
	}

	public String getApplicationName(){
		String ApplicationName= pro.getProperty("APPName");
		if(ApplicationName !=null)
			return ApplicationName;
		else
			throw new RuntimeException("ApplicationName value is not specified");
	}

	public String getEnvironment(){
		String environment= pro.getProperty("Environment");
		if(environment !=null)
			return environment;
		else
			throw new RuntimeException("ApplicationName value is not specified");
	}

	public String getDevUrl(){
		String devUrl= pro.getProperty("Applicationurl");
		if(devUrl !=null)
			return devUrl;
		else
			throw new RuntimeException("DevUrl value is not specified");
	}

	public String getQAUrl(){
		String QAUrl= pro.getProperty("QAUrl");
		if(QAUrl !=null)
			return QAUrl;
		else
			throw new RuntimeException("QAUrl value is not specified");
	}

	
	public String getPassword(){
		String password= pro.getProperty("password");
		if(password !=null)
			return password;
		else
			throw new RuntimeException("password value is not specified");
	}
	
	public String getUsername(){
		String password= pro.getProperty("username");
		if(password !=null)
			return password;
		else
			throw new RuntimeException("username value is not specified");
	}
	
	public String getInputExcelFile(){
		String InputExcelFile= pro.getProperty("InputExcelFile");
		if(InputExcelFile !=null)
			return InputExcelFile;
		else
			throw new RuntimeException("InputExcelFile value is not specified");
	}
	
	public static void main(String args[]){
		String SourceFolder = System.getProperty("user.dir");
		//File propertiesFileobj = new File(SourceFolder+"/Global/config.properties");
		ConfigFileReader_old c_reader = new ConfigFileReader_old(SourceFolder);
		System.out.println(c_reader.getApplicationName());
		System.out.println(c_reader.getDevUrl());
		System.out.println(c_reader.getEnvironment());
		System.out.println(c_reader.getPassword());
		System.out.println(c_reader.getUsername());
		
	}
}
