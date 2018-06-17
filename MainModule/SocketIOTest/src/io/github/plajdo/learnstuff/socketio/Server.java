package io.github.plajdo.learnstuff.socketio;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import javax.swing.*;
import java.net.URISyntaxException;

public class Server{
	
	Server(){
		try{
			start();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void start() throws URISyntaxException{
		IO.Options options = new IO.Options();
		options.hostname = "0.0.0.0";
		options.port = 4000;
		
		Socket s = IO.socket(options);
		
		s.on(Socket.EVENT_MESSAGE, objects -> {
			JOptionPane.showMessageDialog(null, objects[1]);
			s.send("a reply yes");
		});
		
	}
	
}
