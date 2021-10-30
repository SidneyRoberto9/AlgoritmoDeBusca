package Principal;

public class Main extends Core {
	public static void main(String[] args) {
		int vetor[] = new int[tamanho];
		int numero_pesquisado = 40;
		
		//Vetor aleatorios de 1 ate 50 com valores unicos
		vetor_aleatorio(vetor);
		
		//Criando um vetor organizado pelo Bubble Sort
		int vetor_bubble[] = vetor.clone();
		bubble_sort(vetor_bubble);
		 
	    //Monstrando vetor gerado pela math
	    System.out.println("Vetor Gerado Aleatoriamente:");
	    int a = 0;
	    for(int item: vetor) {
	    	System.out.format("%2d ", item);
	    	a++;
	    	if(a == 10) {
	    		System.out.println(" ");
	    		a = 0;
	    	}
	    }
		
		System.out.format("\nBuscando pelo Numero 40:\n");
		System.out.format("Busca Linear - Sem Bubble Sort - %d interações.\n", (busca_linear(vetor, numero_pesquisado)));
		System.out.format("Busca Linear - Com Bubble Sort - %d interações.\n", (busca_linear(vetor_bubble, numero_pesquisado)));
		System.out.format("Busca Binaria - %d interações.\n", (busca_binaria(vetor_bubble, numero_pesquisado)));
		System.out.format("Jump Search - %d interações.\n", (jump_search(vetor_bubble, numero_pesquisado)));
		System.out.format("Fibonacci Search - %d interações.\n", (fibonacci_Search(vetor_bubble, numero_pesquisado)));
	}
}
