package io.github.plajdo.learnstuff.socketio;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

public class User{
	
	private static Terminal terminal;
	private static Screen screen;
	private static MultiWindowTextGUI gui;
	
	private static BasicWindow loginWindow;
	private static BasicWindow chatWindow;
	
	private static Socket socket;
	
	public static void main(String[] args) throws IOException{
		
		new Server();
		
		terminal = new DefaultTerminalFactory().createTerminal();
		screen = new TerminalScreen(terminal);
		screen.startScreen();
		
		Panel chatPanel = new Panel();
		chatPanel.addComponent(new Label("kys"));
		
		chatWindow = new BasicWindow("Chat");
		chatWindow.setHints(Collections.singletonList(Window.Hint.CENTERED));
		chatWindow.setComponent(chatPanel);
		
		
		/*
		 * Login window
		 */
		loginWindow = new BasicWindow("Login");
		loginWindow.setHints(Collections.singletonList(Window.Hint.FIXED_POSITION));
		loginWindow.setPosition(TerminalPosition.OFFSET_1x1);
		
		Panel loginPanel = new Panel();
		loginPanel.setLayoutManager(new GridLayout(2));
		
		TextBox ip = new TextBox(new TerminalSize(16, 1));
		TextBox username = new TextBox(new TerminalSize(16, 1));
		
		loginPanel.addComponent(new Label("IP: "));
		loginPanel.addComponent(ip);
		
		loginPanel.addComponent(new Label("Name: "));
		loginPanel.addComponent(username);
		
		loginPanel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
		loginPanel.addComponent(new Button("Connect", User::login));
		
		loginWindow.setComponent(loginPanel);
		
		gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
		gui.addWindowAndWait(loginWindow);
	
	}
	
	private static void login(){
		loginWindow.close();
		
		try{
			socket = IO.socket("localhost:4000");
		}catch(URISyntaxException e){
			System.err.println(e.getMessage());
		}
		
		
		socket.on(Socket.EVENT_CONNECT, new Emitter.Listener(){
			@Override
			public void call(Object... objects){
				System.out.println("Client: Connected");
				gui.addWindowAndWait(chatWindow);
			}
		}).on(Socket.EVENT_MESSAGE, new Emitter.Listener(){
			@Override
			public void call(Object... objects){
				System.out.println("Client: " + objects[0]);
			}
		});
		
		socket.connect();
		socket.send("hyyyeeeyyey");
		
	}
	
}
