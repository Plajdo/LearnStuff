package es.esy.playdotv.cligraphics;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class Controls{
	
	private static volatile boolean w;
	private static volatile boolean s;
	private static volatile boolean a;
	private static volatile boolean d;
	private static volatile boolean enter;
	
	public static void initKeyboard(){
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher(){

			@Override
			public boolean dispatchKeyEvent(KeyEvent e){
				synchronized(Controls.class){
					switch(e.getID()){
					case KeyEvent.KEY_PRESSED:
						if(e.getKeyCode() == KeyEvent.VK_W){
							w = true;
						}
						if(e.getKeyCode() == KeyEvent.VK_S){
							s = true;
						}
						if(e.getKeyCode() == KeyEvent.VK_A){
							a = true;
						}
						if(e.getKeyCode() == KeyEvent.VK_D){
							d = true;
						}
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
							enter = true;
						}
						break;
					case KeyEvent.KEY_RELEASED:
						if(e.getKeyCode() == KeyEvent.VK_W){
							w = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_S){
							s = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_A){
							a = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_D){
							d = false;
						}
						if(e.getKeyCode() == KeyEvent.VK_ENTER){
							enter = false;
						}
						break;
						
					}
					
				}
				return false;
				
			}
			
		});
		
	}
	
	public static boolean isWPresssed(){
		synchronized(Controls.class){
			return w;
		}
		
	}
	
	public static boolean isSPressed(){
		synchronized(Controls.class){
			return s;			
		}
		
	}
	
	public static boolean isAPressed(){
		synchronized(Controls.class){
			return a;			
		}
		
	}
	
	public static boolean isDPressed(){
		synchronized(Controls.class){
			return d;			
		}
		
	}
	
	public static boolean isEnterPressed(){
		synchronized(Controls.class){
			return enter;			
		}
		
	}
	
}
