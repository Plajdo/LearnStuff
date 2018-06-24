package io.github.plajdo.learnstuff.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
	
	private static ServerSocket serverSocket;
	private static ArrayList<Client> allClients = new ArrayList<>();
	
	public static void main(String[] args){
		try{
			serverSocket = new ServerSocket(4000);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		do{
			try{
				Socket clientSocket = serverSocket.accept();
				Client c = new Client(clientSocket);
				
				allClients.add(c);
				
				new Thread(() -> {
					System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());
					allClients.remove(c.dealWithIt());
					System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostName());
				}).start();
				
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
			
		}while(!allClients.isEmpty());
		
	}
	
	public static ArrayList<Client> getAllClients(){
		return allClients;
	}
	
}
