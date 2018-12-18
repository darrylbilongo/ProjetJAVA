package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private BufferedReader in ;
	private PrintWriter out;
	private Socket socket;
	
	public Client(int port) throws IOException {
		initSocket(port, "localhost");
	}

	public void initSocket(int port, String addr) throws UnknownHostException, IOException {
		
		socket = new Socket(addr, port);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	}
	
	public void closeConnection() throws IOException {
		in.close();
		out.close();
		socket.close();
	}
	
	
}
