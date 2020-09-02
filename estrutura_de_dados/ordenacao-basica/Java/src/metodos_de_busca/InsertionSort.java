package metodos_de_busca;

public class InsertionSort {
	static void insertion_sort(int vetor[]) {
		for(int i = 1; i < vetor.length; i++) {
			int menor_valor = vetor[i];
			int j = (i - 1);
			
			while((j >= 0) && (vetor[j] > menor_valor)) {
				vetor[j + 1] = vetor[j];
				j = (j - 1);
			}
			
			vetor[j + 1] = menor_valor;
		}
	}
	
	public static void main(String[] args) {
		int vetor[] = {545, 545, 51, 155, 215, 5161, 511665, 0, 1, 2, 3, 5, 8, 55, 88};
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
		
		insertion_sort(vetor);
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
