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
	
	public static void bubble_sort(int v[]) {
		// for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
		for(int i = tamanho; i >= 1; i--) {
			// for utilizado para ordenar o vetor.
            for(int j = 1; j < i; j++) {
            	/* Se o valor da posição atual do vetor for maior que o proximo valor,
                então troca os valores de lugar no vetor. */
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
	}
	
	public static int busca_linear(int v[], int numero_pesquisado) {
		int interacoes_Linear = 1;
		
		for(int i = 0; i < tamanho; i++) {
			if(!(v[i] == numero_pesquisado))
				interacoes_Linear++;
			else
				break;
		}
		return interacoes_Linear;
	}
	
	public static int busca_binaria(int v[], int numero_pesquisado) {
		int inicio = 0 , meio = 0, fim = tamanho - 1, interacoes_Binaria = 1;
		    
	    while(inicio <= fim) {
	    	meio = (fim + inicio) / 2;
		  
		    if(v[meio] == numero_pesquisado)
		        break;
		    
		    if(v[meio] < numero_pesquisado)
		    	inicio = meio + 1;
		    else
		    	fim = meio - 1;
		    
		    interacoes_Binaria++;
	    }
	    return interacoes_Binaria;
	}
	
	public static int jump_search(int v[], int numero_pesquisado) {
		// o Tamnho do bloco faz referencia a raiz quadrada do tamanaho total e arredondando pra o valor maior
		int tamanhoBloco = (int) Math.floor(Math.sqrt(tamanho)), interacoes_Jump = 1;
		// o ultimo elemento representa o ultimo elemento do bloco
	    int ultimoElemento = tamanhoBloco;
	    //Como a lista ja ta organizada ele vai varrendo cada bloco ate achar o bloco com valor maior e armazena esse bloco
	    while (ultimoElemento < tamanho && numero_pesquisado > v[ultimoElemento]) {
	    	interacoes_Jump++;
	    	ultimoElemento += tamanhoBloco;
	    }
	    //varre o bloco selecionado anteriormente ate encontrar o valor.
	    for(int elementoAtual = ultimoElemento - tamanhoBloco + 1; elementoAtual <= ultimoElemento && elementoAtual < tamanho; elementoAtual++) {
	    	interacoes_Jump++;
	    	if (numero_pesquisado == v[elementoAtual])
	            break;
	    }
	    return interacoes_Jump;
	}
	
	public static int fibonacci_Search(int v[], int numero_pesquisado){
		// iniciando a sequencia de fibbonacci
		int fib2 = 0, fib1 = 1 ,fibM = fib2 + fib1, interacoes_fib = 1;
		// limita o tamanho na busca para não recebemos um "Index out range"
		int offset = -1;
		//fibM armazerna o menor numero de fibbonacci, maior ou igual ao tamanho da lista
		while (fibM < tamanho) {
			fib2 = fib1;
			fib1 = fibM;
			fibM = fib2 + fib1;
		}
		//Busca o elemento utilizando a sequencia de fibbonacci
		while (fibM > 1) {
		
			// valida se a posição da array é valida, verificando se esta dentro dela
			int valid = offset + fib2;
			if(!(valid <= (tamanho - 1)))
			valid = tamanho - 1;
		
			int i = valid;
			
			// Se o numero_procurado for maior que o valor em fib2, corta a subarray deslocamento para o i criado anteriormente
			
			if (v[i] < numero_pesquisado) {
				fibM = fib1;
				fib1 = fib2;
				fib2 = fibM - fib1;
				offset = i;
			
			// Se o numero_procurado for menor que o valor no fib2, corta a subarray em i + 1 * /
			} else if (v[i] > numero_pesquisado) {
				fibM = fib2;
				fib1 = fib1 - fib2;
				fib2 = fibM - fib1;
		
			//O numero_procurado foi encontrado
			} else {
				break;
			}
			interacoes_fib++;
		}
		//Comparando a ultima posição da lista com o numero_procurado
		if (fib1 == 1 && v[tamanho-1] == numero_pesquisado)interacoes_fib++;
		
		return interacoes_fib;
	}
}
