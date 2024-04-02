package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarros extends Thread {
	
	int id; 
	private Semaphore semaforo; 
	
	public ThreadCarros(Semaphore semaforo, int id) {
		this.id = id; 
		this.semaforo= semaforo; 
	}
	
	public void run() {
		int distanciatotal = (int) ((Math.random()*1001)+1000); 
		int distanciapercorrida = 0; 
		int distancia = 100; 
		int metros = 0; 
		int tempo = (int) ((Math.random()*2001)+1000);
		
		while(distanciapercorrida<=distanciatotal) {
			distanciapercorrida = distanciapercorrida + distancia; 
			
			if(distanciapercorrida>=metros) {
				System.out.println("O carro "+ id+ " percorreu "+ distanciapercorrida+ " metros");
				metros= metros + 250; 
			}
		}
		
		System.out.println("O carro "+ id+ " chegou ao estacionamento");
		
		try {
			semaforo.acquire();
			System.out.println("O carro "+ id+ " estacionou por "+ (double) tempo/1000+ " segundos");
			sleep(tempo);
			System.out.println("O carro "+ id+ " saiu do estacionamento");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release(); 
		}

			
		
		
	}

}
