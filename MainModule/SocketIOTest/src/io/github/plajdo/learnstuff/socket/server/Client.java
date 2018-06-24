package io.github.plajdo.learnstuff.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client{
	
	PrintWriter out;
	BufferedReader in;
	Socket clientSocket;
	
	public Client(Socket s){
		clientSocket = s;
		try{
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public Socket dealWithIt(){
		try{
			String inputLine;
			String outputLine;
			
			outputLine = "Succesfully connected";
			out.println(outputLine);
			
			while((inputLine = in.readLine()) != null){
				System.out.println("inputLine = " + inputLine);
				outputLine = inputLine;
				out.println(outputLine);
				if(inputLine.equals("kys")){
					break;
				}
				
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return clientSocket;
		
	}
	
}
