package io.github.plajdo.learnstuff.socket.client;

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
			
			/*
			 * Get nickname message
			 */
			System.out.print(in.readLine());
			
			Thread serverWriter = new Thread(() -> {
				String serverText;
				try{
					while((serverText = in.readLine())!= null){
						System.out.println(serverText);
					}
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
			});
			serverWriter.setDaemon(true);
			serverWriter.start();
			
			while((userInput = stdIn.readLine()) != null){
				out.println(userInput);
				if(userInput.equals("kys")){
					System.exit(0);
				}
				
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
