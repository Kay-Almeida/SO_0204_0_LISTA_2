package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarros;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore (3); 
		
		for(int id = 1; id<=10; id++) {
			ThreadCarros tc = new ThreadCarros(semaforo, id); 
			tc.start();
		}
	}

}
