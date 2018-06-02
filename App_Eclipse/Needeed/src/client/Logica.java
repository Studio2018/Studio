package client;

import java.util.Observable;
import java.util.Observer;

import leidercalvo.envio.Modelo;

public class Logica implements Observer, Runnable{
	
	private ComToApp comToApp; // comunicacion con la app
	private ComToMesa com; //Comunicacion con la mesa
	
	public Logica() {
		//comToApp = new ComToApp();
		//comToApp.addObserver(this);
		
		//Thread t = new Thread(comToApp);
		//t.start();
		
		conectarToMesa();
	}	

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ComToApp) {
			Modelo modelo = (Modelo) arg;
			/*
			 * Este mensaje lo envia la app
			 * 
			 */
		}
		
		if(o instanceof ComToMesa) {
			Modelo modelo = (Modelo) arg;
			/*
			 * Este mensaje lo envia la Mesa
			 * Aqui deberia hacer algo con el mensaje que llega
			 */
		}
	}
	
	public void conectarToMesa() {
		com = new ComToMesa("127.0.0.1", 5000);		
		com.addObserver(this);		
		
		Thread t = new Thread(com);
		t.start();
		
		Modelo modelo = new Modelo("a", "b", "c");
		com.enviar(modelo);
	}

	@Override
	public void run() {
		while(true){
			try {
				/*
				 * Los procesos que pueda ejecutar la silla
				 */
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}		
	}
}
