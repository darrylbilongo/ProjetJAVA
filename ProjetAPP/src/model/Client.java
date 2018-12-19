package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable{
	
	private BufferedReader in ;
	private PrintWriter out;
	private Socket socket;
	private Thread thread;
	private String server;
	
	Scanner sc;
	
	public Client(int port) throws IOException {
		connect(port, "localhost");
		sc = new Scanner(System.in);
		System.out.println("Bonjour, \nBienvenu(e) à Motus:");	
		System.out.println("Veuillez Entrez un pseudo s'il vous plait: ");
		String pseudoJoueur = sc.next();
		sendProposition(pseudoJoueur);
		thread = new Thread(this);
		thread.start();
		readInput();
	}

	public void connect(int port, String addr) throws UnknownHostException, IOException {	
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
		out.flush();
	}
	
	public String waitForPropo() throws IOException {
		String str = in.readLine();
        if(str.contains("Pseudo")) {
        	String s [] = str.split("");
        	server = s[1];
        	str = "";
        }
        return server + "> " + str;
	
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client(12345);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public void readInput() throws IOException{
		while(true){
			String propo = sc.nextLine();
			sendProposition(propo);
		}
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			String propo = "";
			try {
				propo = waitForPropo();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(propo);
		}
	}
	
	
}
