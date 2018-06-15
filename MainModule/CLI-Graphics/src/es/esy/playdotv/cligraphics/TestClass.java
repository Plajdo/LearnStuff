package es.esy.playdotv.cligraphics;

public class TestClass {
	
	public static void main(String[] args){
		Controls.initKeyboard();
		while(!Controls.isEnterPressed()){
			if(Controls.isWPresssed()){
				System.out.println("W pressed");
			}else if(Controls.isAPressed()){
				System.out.println("A pressed");
			}else if(Controls.isDPressed()){
				System.out.println("D pressed");
			}else if(Controls.isSPressed()){
				System.out.println("S pressed");
			}else{
				System.out.println("Nothing pressed");
			}
			
		}
		
	}
	
}
