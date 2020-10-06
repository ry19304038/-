package factory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Factory {
	public static Object createInstance(String className) {
		Object object=null;

		try {
			String path = new File(".").getAbsoluteFile().getParent();
	        System.out.println("現在のカレントは	"+path);



			Properties properties=new Properties();
			properties.load(new FileInputStream("C:\\Users\\19304026\\git\\Bboard\\WebContent\\myapps22\\Properties/properties.properties"));
			System.out.println("引数に受け取ったclassNameは		 "+className);

			className=properties.getProperty(className);
			Class c=Class.forName(className);
			object=c.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return object;
	}
}
