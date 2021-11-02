package com.Principal;

public class Core {
	protected static int tamanho = 50;
	
	public static void vetor_aleatorio(int[] v) {
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
	
	public static void printVetorAleatorio(int[] v) {
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

	public static int[] vetoresClonados(int[] v, long[][] it){
		Sort sort = new Sort();
		//Criando vetores clone para cada tipo de sort
		int[] vetor_bubble= v.clone();
		int[]  vetor_insertion= v.clone();
		int[] vetor_selection = v.clone();
		int[]  vetor_shell= v.clone();
		int[] vetor_merge = v.clone();
		int[] vetor_heap = v.clone();

		//atribuindo as interacoes e o tempo de execucao em dois vetores interacoes e tempoExecucao

		it[0][0] = sort.Bubble_Sort(vetor_bubble, 1);
		it[0][1] = sort.Bubble_Sort(vetor_bubble, 0);

		it[1][0] = sort.Insertion_Sort(vetor_insertion, 1);
		it[1][1]= sort.Insertion_Sort(vetor_insertion, 0);

		it[2][0] = sort.Selection_Sort(vetor_selection,1);
		it[2][1] = sort.Selection_Sort(vetor_selection,0);

		it[3][0] = sort.Shell_Sort(vetor_shell,1);
		it[3][1]  = sort.Shell_Sort(vetor_shell,0);

		it[4][0]  = sort.Merge_Sort(vetor_merge, 0, tamanho - 1, 1);
		it[4][1]  = sort.Merge_Sort(vetor_merge, 0, tamanho - 1, 0);

		it[5][0] = sort.Heap_Sort(vetor_heap, tamanho - 1, 1);
		it[5][1]  = sort.Heap_Sort(vetor_heap, tamanho - 1, 0);

		return vetor_insertion;
	}
}
