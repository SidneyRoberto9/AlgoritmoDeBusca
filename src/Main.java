import java.util.Random;

public class Main {
	private static int tamanho = 50;
	
	private static void bubble_sort(int v[]) {
		for(int i = tamanho; i >= 1; i--) {
            for(int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
		
	}
	
	private static int busca_linear(int v[], int numero_pesquisado) {
		int interacoes_Linear = 1;
		
		for(int i = 0; i < tamanho; i++) {
			if(!(v[i] == numero_pesquisado))
				interacoes_Linear++;
			else
				break;
		}
		
		return interacoes_Linear;
	}
	
	private static int busca_binaria(int v[], int numero_pesquisado) {
		int inicio = 0 , meio = 0, fim = tamanho - 1, interacoes_Binaria = 1;
		    
	    while(inicio <= fim) {
	    	meio = (fim + inicio) / 2;
		      
		    if(v[meio] == numero_pesquisado) {
		        break;
		    }
		    if(v[meio] < numero_pesquisado) {
		    	inicio = meio + 1;
		    } else {
		    	fim = meio - 1;
		    }
		    interacoes_Binaria++;
	    }
	    return interacoes_Binaria;
	}
	
	private static int jump_search(int v[], int numero_pesquisado) {
		int tamanhoBloco = (int) Math.floor(Math.sqrt(tamanho)), interacoes_Jump = 1;

	    int ultimoElemento = tamanhoBloco;
	    
	    while (ultimoElemento < tamanho && numero_pesquisado > v[ultimoElemento]) {
	    	interacoes_Jump++;
	    	ultimoElemento += tamanhoBloco;
	    	
	    }
	    for(int elementoAtual = ultimoElemento - tamanhoBloco + 1; elementoAtual <= ultimoElemento && elementoAtual < tamanho; elementoAtual++) {
	    	interacoes_Jump++;
	    	if (numero_pesquisado == v[elementoAtual]) {
	            break;
	        }  
	    }
	    return interacoes_Jump;
	}
	
	public static void main(String[] args) {
		int vetor[] = new int[tamanho];
		int numero_aleatorio;
		int numero_pesquisado = 40;
		int igual = 0;
		
		Random random = new Random();
		
		//Vetor aleatorios de 1 ate 50 com valores unicos
		for(int x = 0; x < tamanho; x++) {
			numero_aleatorio = (int)(Math.random() * tamanho) + 1;
			
			for(int y = 0; y < tamanho; y++) {
				if(numero_aleatorio == vetor[y])
					igual++;
			}
			if(igual == 0)
				vetor[x] = numero_aleatorio;
			else {
				igual = 0;
				x--;
			}
		}  
		
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
		
		System.out.format("\nPara Buscar o Numero 40:\n");
		System.out.format("Na Busca Linear foram %d interações.\n", (busca_linear(vetor, numero_pesquisado)));
		System.out.format("Na Busca Binaria apos o BubbleSort foram %d interações.\n", (busca_binaria(vetor_bubble, numero_pesquisado)));
		System.out.format("No Jump Search apos o BubbleSort foram %d interações.\n", (jump_search(vetor_bubble, numero_pesquisado)));
	}
}
