package es.esy.playdotv;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.function.Supplier;

class Tests{
	
	/*
	 * fileExists
	 */
	public void fileExists(){
		File splash = new File("resources" + File.separator + "splash.png");
		System.out.println("Exists: " + splash.exists() + " Is directory: " + splash.isDirectory());
		
	}
	
	/*
	 * createDir
	 */
	public void createDir() throws IOException{
		Files.createDirectories(Paths.get("resources"));
		
	}
	
	/*
	 * downloadImg
	 */
	public void downloadImg() throws IOException{
		URL url = new URL("https://raw.githubusercontent.com/ShardBytes/library-book-scanner-launcher/master/splash.png");
		InputStream in = url.openStream();
		Files.copy(in, Paths.get("splash.png"));
		
	}
	
	/*
	 * downloadImgToDir
	 */
	public void downloadImgToDir() throws IOException{
		URL url = new URL("https://raw.githubusercontent.com/ShardBytes/library-book-scanner-launcher/master/splash.png");
		InputStream in = url.openStream();
		Files.copy(in, Paths.get("resources" + File.separator + "splash.png"));
		
	}
	
	/*
	 * doubleColon
	 */
	public void doubleColon(){
		Supplier<Integer> i = Tests::getOne;
		Supplier<Integer> i1 = () -> {return 1;};
		Supplier<Boolean> b = () -> {return false;};
		Supplier<Boolean> b1 = Tests::getFalse;
		System.out.println(i.get() + " " + i1.get());
		System.out.println(b.get() + " " + b1.get());
	}
	
	private static int getOne(){
		return 1;
	}
	
	private static boolean getFalse(){
		return false;
	}
	
	/*
	 * javaFunctions
	 */
	public void javaFunctions(){
		Function<Integer, String> numberToHex = (i) -> {return Integer.toHexString(i).toUpperCase();};
		int number = 0b1101;
		System.out.println(numberToHex.apply(number));
	}
	
}
