package genericutility;

import java.io.FileInputStream;

import java.util.Properties;



public class Property_utility
{
	/**
	 * This method is used to launch the application
	 * @param key
	 * @return
	 * @throws Throwable
	 */
   public String getkeyvalue(String key)throws Throwable
   {
   FileInputStream fis=new FileInputStream("C:\\Users\\suhas\\Desktop\\propertiesfile.properties.txt");
	Properties pro=new Properties();
	pro.load(fis);
	String value=pro.getProperty(key);
	return value;
}
}