package Principal;

public class Main extends Core {
	
	public static void main(String[] args) {
		int vetor[] = new int[tamanho];
 		int numero_pesquisado = 40;
		
		//Instanciando os objetos para as funções de busca e sort
		Sort sort = new Sort();
		Busca busca = new Busca();
		
		//Vetor aleatorios de 1 ate 50 com valores unicos
		vetor_aleatorio(vetor);
		
		//Criando vetores clone para cada tipo de sort 
		int vetor_bubble[] = vetor.clone();
		int vetor_insertion[] = vetor.clone();
		int vetor_selection[] = vetor.clone();
		int vetor_shell[] = vetor.clone();
		int vetor_merge[] = vetor.clone();
		int vetor_heap[] = vetor.clone();
		
		//atribuindo as interações e o tempo de execução em dois vetores interacoes e tempoExecucao
		long interacoes[] = new long[6];
		long tempoExecucao[] = new long[6];
		
		interacoes[0] = sort.Bubble_Sort(vetor_bubble, 1);
		tempoExecucao[0] = sort.Bubble_Sort(vetor_bubble, 0);
		
		interacoes[1] = sort.Insertion_Sort(vetor_insertion, 1);
		tempoExecucao[1] = sort.Insertion_Sort(vetor_insertion, 0);
		
		interacoes[2] = sort.Selection_Sort(vetor_selection,1);
		tempoExecucao[2] = sort.Selection_Sort(vetor_selection,0);
		
		interacoes[3] = sort.Shell_Sort(vetor_shell,1);
		tempoExecucao[3] = sort.Shell_Sort(vetor_shell,0);
		
		interacoes[4] = sort.Merge_Sort(vetor_merge, 0, tamanho - 1, 1);
		tempoExecucao[4] = sort.Merge_Sort(vetor_merge, 0, tamanho - 1, 0);
		
		interacoes[5] = sort.Heap_Sort(vetor_heap, tamanho - 1, 1);
		tempoExecucao[5] = sort.Heap_Sort(vetor_heap, tamanho - 1, 0);
		 
	    //Monstrando vetor gerado pela math
	    printVetorAleatorio(vetor);
	    
		//Organização de Prints Referente as Buscas
	    System.out.format("\nTabela Buscas:\n");
	    System.out.format(" Tipo de Busca  | interações | Numero Pesquisado\n");
		System.out.format(" Linear         |        %d  | 	40\n", busca.Busca_Linear(vetor_insertion, numero_pesquisado));
		System.out.format(" Linear Sem Sort|  	 %2d  |	40\n", busca.Busca_Linear(vetor, numero_pesquisado));
		System.out.format(" Binaria        | 	 %2d  | 	40\n", busca.Busca_Binaria(vetor_insertion, numero_pesquisado));
		System.out.format(" Jump           |        %d  | 	40\n", busca.Busca_Jump(vetor_insertion, numero_pesquisado));
		System.out.format(" Fibonacci      | 	 %2d  | 	40\n", busca.Busca_Fibbonacci(vetor_insertion, numero_pesquisado));
		
		//Organização de Prints Referente ao Sorts
		System.out.format("\nTabela Sorts:\n");
		System.out.format(" Tipo de Sort | Interações | Execução(MiliSegundos)\n");
		System.out.format(" Bubble       |       %4d | 	   %.6f\n", interacoes[0], (double)tempoExecucao[0]/1e6);
		System.out.format(" Insertion    |       %4d | 	   %.6f\n", interacoes[1], (double)tempoExecucao[1]/1e6);
		System.out.format(" Selecion     |       %4d |       %.6f\n", interacoes[2], (double)tempoExecucao[2]/1e6);
		System.out.format(" Shell        |       %4d |       %.6f\n", interacoes[3], (double)tempoExecucao[3]/1e6);
		System.out.format(" Merge        |       %4d |       %.6f\n", interacoes[4], (double)tempoExecucao[4]/1e6);
		System.out.format(" Heap         |       %4d |       %.6f\n", interacoes[5], (double)tempoExecucao[5]/1e6);	  
	}
}
