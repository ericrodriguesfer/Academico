package metodos_de_busca;

public class BubbleSort {
	static void bubble_sort(int vetor[]) {
		for(int i = 0; i < (vetor.length - 1); i++) {
			for(int j = 0; j < (vetor.length - 1); j++) {
				if(vetor[j + 1] < vetor[j]) {
					int copia = vetor[j + 1];
					vetor[j + 1] = vetor[j];
					vetor[j] = copia;
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
		
		bubble_sort(vetor);
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
