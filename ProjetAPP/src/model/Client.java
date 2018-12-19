package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	
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
	
	public void sendProposition(String mot) {
		out.println(mot);
	}
	
	public String waitForMessage() throws IOException {
        String str = in.readLine();
        if(str.equals("STOP"))
        	str = "Votre interlocuteur s'est d�connect� ";
        return str;
	
	}
	
	private void envoyerProposition() {
		while(true){
			System.out.print("Partie en String");
			String msg = sc.nextLine();
			/*if(msg.equals("STOP")){
				chat.sendMessage("STOP");
				sc.close();
				chat.closeConnection();
				System.exit(0);
			}*/
			
		}
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
