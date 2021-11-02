package com.Principal;

public class Main extends Core {
	
	public static void main(String[] args) {
		int[] vetor = new int[tamanho];
		long[][] interacoesExecucoes = new long[6][2];
 		int numero_pesquisado = 40;
		
		//Instanciando os objetos para as funcoes d
		Busca busca = new Busca();
		
		//Vetor aleatorios de 1 ate 50 com valores unicos
		vetor_aleatorio(vetor);

		//Clona os vetores e obtem quantidade de interacoes e tempo de execucao
		int[] vetor_insertion = vetoresClonados(vetor, interacoesExecucoes);
		 
	    //Monstrando vetor gerado pela math
	    printVetorAleatorio(vetor);
	    
		//Organizacao de Prints Referente as Buscas
	    System.out.format("\nTabela Buscas:\n");
	    System.out.format(" Tipo de Busca  | Interacaes | Numero Pesquisado\n");
		System.out.format(" Linear         |       %2d   | 	40\n", busca.Busca_Linear(vetor_insertion, numero_pesquisado));
		System.out.format(" Linear Sem Sort|       %2d   |	40\n", busca.Busca_Linear(vetor, numero_pesquisado));
		System.out.format(" Binaria        |       %2d   | 	40\n", busca.Busca_Binaria(vetor_insertion, numero_pesquisado));
		System.out.format(" Jump           |       %2d   | 	40\n", busca.Busca_Jump(vetor_insertion, numero_pesquisado));
		System.out.format(" Fibonacci      |       %2d   | 	40\n", busca.Busca_Fibbonacci(vetor_insertion, numero_pesquisado));
		
		//Organiza��o de Prints Referente ao Sorts
		System.out.format("\nTabela Sorts:\n");
		System.out.format(" Tipo de Sort | Interacaes  | Execucao(MiliSegundos)\n");
		System.out.format(" Bubble       |       %4d | 	   %.6f\n", interacoesExecucoes[0][0], (double)interacoesExecucoes[0][1]/1e6);
		System.out.format(" Insertion    |       %4d | 	   %.6f\n", interacoesExecucoes[1][0], (double)interacoesExecucoes[1][1]/1e6);
		System.out.format(" Selecion     |       %4d |       %.6f\n", interacoesExecucoes[2][0], (double)interacoesExecucoes[2][1]/1e6);
		System.out.format(" Shell        |       %4d |       %.6f\n", interacoesExecucoes[3][0], (double)interacoesExecucoes[3][1]/1e6);
		System.out.format(" Merge        |       %4d |       %.6f\n", interacoesExecucoes[4][0], (double)interacoesExecucoes[4][1]/1e6);
		System.out.format(" Heap         |       %4d |       %.6f\n", interacoesExecucoes[5][0], (double)interacoesExecucoes[5][1]/1e6);
	}
}
