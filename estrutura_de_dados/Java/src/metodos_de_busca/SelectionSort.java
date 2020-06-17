package metodos_de_busca;

public class SelectionSort {
	static void selection_sort(int vetor[]) {
		for(int i = 0; i < (vetor.length - 1); i++) {
			int posicao_menor = i;
			
			for(int j = (i + 1); j < vetor.length; j++) {
				if(vetor[j] < vetor[posicao_menor]) {
					posicao_menor = j;
				}
			}
			
			int copia = vetor[posicao_menor];
			vetor[posicao_menor] = vetor[i];
			vetor[i] = copia;
		}
	}
	
	public static void main(String[] args) {
		int vetor[] = {545, 545, 51, 155, 215, 5161, 511665, 0, 1, 2, 3, 5, 8, 55, 88};
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
		
		selection_sort(vetor);
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
