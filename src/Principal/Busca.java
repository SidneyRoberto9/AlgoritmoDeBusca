package Principal;

public class Busca extends Core{
	public int Busca_Linear(int v[], int numero_pesquisado) {
		int interacoes_Linear = 1;
		
		for(int i = 0; i < tamanho; i++) {
			if(!(v[i] == numero_pesquisado))
				interacoes_Linear++;
			else
				break;
		}
		return interacoes_Linear;
	}
	
	public int Busca_Binaria(int v[], int numero_pesquisado) {
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
	
	public int Busca_Jump(int v[], int numero_pesquisado) {
		// o Tamanho do bloco faz referencia a raiz quadrada do tamanaho total e arredondando pra o valor maior
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
	
	public int Busca_Fibbonacci(int v[], int numero_pesquisado){
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
			} else 
				break;
			interacoes_fib++;
		}
		//Comparando a ultima posição da lista com o numero_procurado
		if (fib1 == 1 && v[tamanho-1] == numero_pesquisado)interacoes_fib++;
		return interacoes_fib;
	}

}
