package io.github.plajdo.learnstuff.socketio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	
	private static ServerSocket serverSocket;
	private static ArrayList<Socket> allClients = new ArrayList<>();
	
	static{
		try{
			serverSocket = new ServerSocket(4000);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args){
		do{
			try{
				Socket clientSocket = serverSocket.accept();
				allClients.add(clientSocket);
				new Thread(() -> {
					System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());
					System.out.println("Connected clients: " + allClients.toString());
					allClients.remove(new Client(clientSocket).dealWithIt());
					System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostName());
					System.out.println("Connected clients: " + allClients.toString());
				}).start();
			}catch(IOException e){
				e.getMessage();
			}
			
		}while(!allClients.isEmpty());
		
	}
	
}

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
