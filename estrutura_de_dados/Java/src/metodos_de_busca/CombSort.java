package metodos_de_busca;

public class CombSort {
	public static void comb_sort(int vetor[]) {
		int copiado = 1;
		int intervalo = (vetor.length - 1);
		
		while((intervalo > 1) || (copiado == 1)) {
			intervalo = (intervalo * 10) / 13;
			
			if(intervalo == 9 || intervalo == 10) {
				intervalo = 11;
			}
			
			if(intervalo < 1) {
				intervalo = 1;
			}
			
			copiado  = 0;
			
			for(int i = 0, j = intervalo; j < vetor.length; i++, j++) {
				if(vetor[i] > vetor[j]) {
					int copia = vetor[j];
					vetor[j] = vetor[i];
					vetor[i] = copia;
					copiado = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int vetor[] = {545, 545, 51, 155, 215, 5161, 511665, 0, 1, 2, 3, 5, 8, 55, 88};
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
		
		comb_sort(vetor);
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
