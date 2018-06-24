package io.github.plajdo.learnstuff.socket.server;

import java.io.IOException;
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
