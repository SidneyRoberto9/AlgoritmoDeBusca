package Principal;

public class Core {
	protected static int tamanho = 50;
	
	public static void vetor_aleatorio(int v[]) {
		int numero_aleatorio;
		int igual = 0;
		
		for(int x = 0; x < tamanho; x++) {
			numero_aleatorio = (int)(Math.random() * tamanho) + 1;
			for(int y = 0; y < tamanho; y++) {
				if(numero_aleatorio == v[y])
					igual++;
			}
			if(igual == 0)
				v[x] = numero_aleatorio;
			else {
				igual = 0;
				x--;
			}
		}  
	}
	
	public static void printVetorAleatorio(int v[]) {
		System.out.println("Vetor Gerado Aleatoriamente:");
	    int a = 0;
	    for(int item: v) {
	    	System.out.format("%2d ", item);
	    	a++;
	    	if(a == 10) {
	    		System.out.println(" ");
	    		a = 0;
	    	}
	    }
	}
	
	public static void printInteracoesSort(int v[], int numero_pesquisado) {
		Busca busca = new Busca();
		
		System.out.format("\nBuscando pelo Numero %d:\n", numero_pesquisado);
		System.out.format("Busca Linear - %d interações.\n", busca.Busca_Linear(v, numero_pesquisado));
		System.out.format("Busca Binaria - %d interações.\n", busca.Busca_Binaria(v, numero_pesquisado));
		System.out.format("Jump Search - %d interações.\n", busca.Busca_Jump(v, numero_pesquisado));
		System.out.format("Fibonacci Search - %d interações.\n", busca.Busca_Fibbonacci(v, numero_pesquisado));
	}
}
