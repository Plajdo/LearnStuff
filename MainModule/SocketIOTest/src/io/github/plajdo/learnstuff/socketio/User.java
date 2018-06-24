package io.github.plajdo.learnstuff.socketio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User{
	
	public static void main(String[] args){
		try(Socket echoSocket = new Socket("localhost", 4000);
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))){
			
			String userInput;
			System.out.println("Server: " + in.readLine());
			
			while((userInput = stdIn.readLine()) != null){
				out.println(userInput);
				if(userInput.equals("kys")){
					break;
				}
				System.out.println("Server: " + in.readLine());
				
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
