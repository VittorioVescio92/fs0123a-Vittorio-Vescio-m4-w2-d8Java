package esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import esercizio2.thread2.MyThread2;

public class Main2 {
	public static Logger logger = LoggerFactory.getLogger(Main2.class);

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < 3000; i++) {
			int randomR = r.nextInt(10);
			lista.add(randomR);
		}
		List<Integer> primaLista = new ArrayList<>();
		List<Integer> secondaLista = new ArrayList<>();
		List<Integer> terzaLista = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			primaLista.add(lista.get(i));
			secondaLista.add(lista.get(i + 1000));
			terzaLista.add(lista.get(i + 2000));
		}
		MyThread2 t1 = new MyThread2(primaLista);
		MyThread2 t2 = new MyThread2(secondaLista);
		MyThread2 t3 = new MyThread2(terzaLista);

		try {
			t1.start();
			t2.start();
			t3.start();
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			Main2.logger.error(e.getMessage());
		}
		int sommaGenerale = t1.getSomma() + t2.getSomma() + t3.getSomma();
		logger.info("La somma totale è: " + sommaGenerale);
	}
}
