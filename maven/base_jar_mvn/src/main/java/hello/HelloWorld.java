package hello;

import org.joda.time.LocalTime;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class HelloWorld {
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());

	//TODO: get image as file
	    String imgPath = "E:\\tmp\\_bender.jpg";
		File imagFile = new  File(imgPath);

		if(!imagFile.exists()){
			System.out.println("img file does not exists");
			return ;
		}

		String jarPath = "E:\\tmp\\gs-maven-0.1.0.jar";
		File jarFile = new  File(jarPath);

		if(!jarFile.exists()){
			System.out.println("jarFile file does not exists : " + jarFile);
			return ;
		}


		try {
			JarUtil.updateJarFile(jarFile,true,  new File[]{imagFile});
		} catch (IOException e) {
			e.printStackTrace();
		}
		//	myMethod(new String[]{"a", "b", "c"});
	//	myMethod2(new File[]{jarFile,imageFile});
	//	File file = new File("");
	//	myMethod3( file ,new File[]{jarFile,imageFile});

	//	JarUtil.updateJarFile2( jarFile ,new File[]{jarFile});

	}

	private static void myMethod4(File file, File... files) {
	}

	private static void myMethod3(File file, File... files) {
	}

	private static void myMethod2(File ... files) {
	}

	private static void myMethod(String ... strings) {
	}


}
