package model;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Temps extends TimerTask{
	private Mot mot;
	private int temps = 10; 
	
	public void run() {		
		if(temps == 0) {
			cancel();
		}
		System.out.println(temps);
		temps--;
	}

	public Mot getMot() {
		return mot;
	}
}
