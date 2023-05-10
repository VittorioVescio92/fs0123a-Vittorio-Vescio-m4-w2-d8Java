package esercizio2.thread2;

import java.util.List;

import esercizio2.Main2;

public class MyThread2 extends Thread {
	private int somma;
	private List<Integer> lista;

	public MyThread2(List<Integer> lista) {
		setLista(lista);
	}

	@Override
	public void run() {
		for (int i = 0; i < lista.size(); i++) {
			somma += lista.get(i);
		}
		String sum = Integer.toString(somma);
		Main2.logger.info(sum);
	}

	public int getSomma() {
		return somma;
	}

	public void setSomma(int somma) {
		this.somma = somma;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}

}
