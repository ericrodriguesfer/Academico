package JantarFilosofos;

import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		List <Filosofo> jantarFilosofos = new ArrayList<>();
		
		jantarFilosofos.add(new Filosofo("Nietzsche", 1, mesa));
		jantarFilosofos.add(new Filosofo("Sartre", 2, mesa));
		jantarFilosofos.add(new Filosofo("Baudrillard", 3, mesa));
		jantarFilosofos.add(new Filosofo("Schopenhauer", 4, mesa));
		jantarFilosofos.add(new Filosofo("Anaxímenes", 5, mesa));
		
		for (int i = 0; i < jantarFilosofos.size(); i++) {
			jantarFilosofos.get(i).start();
		}
	}
}
