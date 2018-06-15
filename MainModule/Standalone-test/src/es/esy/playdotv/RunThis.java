package es.esy.playdotv;

import java.util.Arrays;

public class RunThis{
	
	public static void main(String[] args) throws Exception{
		Tests t = new Tests();
		if(contains(args, "fileExists")){
			t.fileExists();
		}
		if(contains(args, "createDir")){
			t.createDir();
		}
		if(contains(args, "downloadImg")){
			t.downloadImg();
		}
		if(contains(args, "downloadImgToDir")){
			t.downloadImgToDir();
		}
		if(contains(args, "doubleColon")){
			t.doubleColon();
		}
		if(contains(args, "javaFunctions")){
			t.javaFunctions();
		}
		
	}
	
	public static boolean contains(String[] array, String item){
		return Arrays.stream(array).anyMatch(item::equals);
	}
	
}
