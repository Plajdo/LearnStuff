package io.github.plajdo.learnstuff.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client{
	
	private PrintWriter out;
	private BufferedReader in;
	private Socket clientSocket;
	private String nickname;
	
	Client(Socket s) throws IOException{
		clientSocket = s;
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
	}
	
	public void send(String text){
		out.println(text);
	}
	
	public String getName(){
		String[] split = this.toString().split("@");
		return split[split.length - 1];
	}
	
	public Client dealWithIt(){
		try{
			String inputLine;
			
			send("well");
			nickname = in.readLine();
			//send("Hello, " + (nickname.isEmpty() ? getName() : nickname) + "!");
			//send("Use \"kys\" to exit.");
			
			while((inputLine = in.readLine()) != null){
				System.out.println(this.getName() + ": " + inputLine);
				
				if(inputLine.equals("kys")){
					break;
				}
				
				final String finalInputLine = inputLine;
				Server.getAllClients().forEach((client) -> {
					if(!client.equals(this)){
						client.send("<" + (nickname.isEmpty() ? getName() : nickname) + "> " + finalInputLine);
					}
					
				});
				
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return this;
		
	}
	
	
	
}
