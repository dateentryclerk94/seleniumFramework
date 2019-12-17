package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error occurred" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error occurred" + e.getMessage());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("error occurred" + e.getMessage());
		}

		return pro;

	}

	public static Properties userData = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\testdata.properties");
	//public static Properties userData = loadProperties("C:\\Users\\Mohamed\\eclipse-workspace\\taf\\src\\main\\java\\properties\\testdata.properties");
}
