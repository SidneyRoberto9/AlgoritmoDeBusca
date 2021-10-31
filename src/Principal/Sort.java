package Principal;

public class Sort extends Core{
	
	public long Bubble_Sort(int v[], int mode) {
		long startTime = System.nanoTime();
		
		int interacoes = 1;
		// for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
		for(int i = tamanho; i >= 1; i--) {
			// for utilizado para ordenar o vetor.
			interacoes++;
            for(int j = 1; j < i; j++) {
            	interacoes++;
            	// Se o valor da posição atual do vetor for maior que o proximo valor,
                //então troca os valores de lugar no vetor
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                    interacoes++;
                }
            }
        }
			
		if (mode == 1)
			return interacoes;
		else
			return System.nanoTime() - startTime;
		
	}

	public long Insertion_Sort(int v[],int mode) {
		long startTime = System.nanoTime();
		int interacoes = 1;
		// aponta para a posição de index [1] do vetor e varre a lista apartir dele
	    for(int i = 1; i < tamanho; ++i) {
	    	// key = variavel auxiliar utilizada para manter o conteudo da posição atual do vetor
	    	// j = variavel auxiliar utilizada para mandar a posição anterior do vetor
	    	int key = v[i];
	        int j = i - 1;
	        
	        // Mova os elementos da posição anterior, que são
	        // maior que a posição atual, para uma posição à frente
	        // de sua posição atual 
	        interacoes++;
	        while (j >= 0 && v[j] > key) {
	        	interacoes++;
	        	v[j + 1] = v[j];
	            j = j - 1;
	        }
	        // o conteudo da posição atual vai receber o conteudo salvo com atencedencia
	        v[j + 1] = key;
	    }
	    if (mode == 1)
			return interacoes;
		else
			return System.nanoTime() - startTime;
	}

	public long Selection_Sort(int v[], int mode) {
		long startTime = System.nanoTime();
		int interacoes = 1;
		// definindo a movimentação da raiz pelos index 0 ah tamanho do vetor - 1
        for (int i = 0; i < tamanho-1; i++){
            // Procurando o menor elemnto do vetor desordenado
            int menor = i;
            for (int j = i+1; j < tamanho; j++) {
            	interacoes++;
            	if (v[j] < v[menor]) {
            		interacoes++;
                    menor = j;
                }
            } 
            // Trocando o menor elemento encontrado pelo primeiro e 
            // seguindo essa logica, varrendo os menores elementos 
            // para frente
            int temp = v[menor];
            v[menor] = v[i];
            v[i] = temp;
            interacoes++;
        }
        if (mode == 1)
			return interacoes;
		else
			return System.nanoTime() - startTime;
	}
	
	public long Shell_Sort(int v[], int mode) {
		long startTime = System.nanoTime();
		int interacoes = 1;
		// Começando com a metade do valor total e tradando como um bloco
		// para ficar reduzindo gradativamente
		for (int gap = tamanho/2; gap > 0; gap /= 2){
			interacoes++;
            // Fazemos insertion sort Para o tamanho estabelecido acima
            // os primeiros elementos do bloco seram  gap-1
            // sera preenchido em ordem esse bloco ate que tudo estaja organizado
            for (int i = gap; i < tamanho; i += 1){
            	interacoes++;
                int temp = v[i];
                //desloca os elementos em blocos anteriores ate achar a lacuna com o
                // index correto
                int j;
                for (j = i; j >= gap && v[j - gap] > temp; j -= gap) {
                	v[j] = v[j - gap];
                	interacoes++;
                }   
                // assim colocando o temp que seria o valor pego anterior mente na posição correta
                v[j] = temp;
            }
        }
		if (mode == 1)
			return interacoes;
		else
			return System.nanoTime() - startTime;
	}
	
	public long Merge(int v[], int inicio, int metade, int fim, int mode) {
		long startTime = System.nanoTime();
		int interacoes = 1;
		 // Coloca o tamanho das 2 sublsitas
        int n1 = metade - inicio + 1;
        int n2 = fim - metade;
        //Criando 2 listas temporarias
        int L[] = new int[n1];
        int R[] = new int[n2];
        //Copiando os conteudos para elas
        for(int i = 0; i < n1; ++i) {
        	L[i] = v[inicio + i];
        	interacoes++;
        } 	
        for(int j = 0; j < n2; ++j) {
            R[j] = v[metade + 1 + j];
            interacoes++;
        }
        //juntado as duas listas temporarias
        // inciando o index das daus listas
        int i = 0, j = 0;
        // index inicial para juntar as listas
        int k = inicio;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                v[k] = L[i];
                i++;
            }
            else {
                v[k] = R[j];
                j++;
            }
            interacoes++;
            k++;
        }
        //Copiando os elementos restantes de L se houver
        while (i < n1) {
        	interacoes++;
            v[k] = L[i];
            i++;
            k++;
        }
        //Copiando os elementos restantes de R se houver
        while (j < n2) {
        	interacoes++;
            v[k] = R[j];
            j++;
            k++;
        }
		if (mode == 1)
			return interacoes;
		else
			return System.nanoTime() - startTime;
		
	}
	
	public long Merge_Sort(int v[], int inicio, int fim, int mode) {
		long startTime = System.nanoTime(), variavel = 0;
		if (inicio < fim) {
            // Ache o ponto ao meio
            int metade = inicio + (fim - inicio)/2;
  
            // Organiza a primeira e a segunda metade
            variavel += Merge_Sort(v, inicio, metade, mode) + 1;
            variavel += Merge_Sort(v, metade + 1, fim, mode) + 1;
  
            // Mesclar as metades as metade
            variavel += Merge(v, inicio, metade, fim, mode) + 1;
        }	
		if (mode == 1)
			return variavel + 1;
		else
			return (System.nanoTime() - startTime);
	}
	
	public long Heap_Sort(int v[], int tam, int mode) {
		long startTime = System.nanoTime(), variavel = 0;
		int interacoes = 1;
		//Crie o Heap
        for (int i = (tam / 2) - 1; i >= 0; i--) {
        	variavel += heap_arvore(v, tam , i, mode);
        	interacoes++;
        }
        // Extraia gradativamente os elemntos para o heap
        for (int i = tam - 1; i > 0; i--) {
        	interacoes++;
            //Mexa a raiz atual para o fim
            int temp = v[0];
            v[0] = v[i];
            v[i] = temp;
            //Chamar o maximo da heap_arvore para reduzir o heap
            variavel += heap_arvore(v, i, 0, mode);
        }
		if (mode == 1)
			return interacoes + variavel;
		else
			return System.nanoTime() - startTime;
	}
	
	public long heap_arvore(int v[], int tam, int inic, int mode){
		long startTime = System.nanoTime() , variavel = 0;
		int interacoes = 1;
		
        int largest = inic; // iniciando a maior raiz
        int l = 2 * inic + 1; // esquerda = 2 * i + 1
        int r = 2 * inic + 2; // direita = 2 * i + 2
 
        //Se o filho esquerdo é maior que a raiz
        if (l < tam && v[l] > v[largest]) {
        	interacoes++;
            largest = l;
        }
        //Se o filho direito é maior do que a maior atual
        if (r < tam && v[r] > v[largest]) {
        	interacoes++;
            largest = r;
        }
        
        //Se o maior não for raiz
        if (largest != inic) {
        	interacoes++;
            int temp = v[inic];
            v[inic] = v[largest];
            v[largest] = temp;
 
            // Criar a sub arvore afetada chamando heap_arvore
            variavel += heap_arvore(v, tam, largest, mode);
        }
        if (mode == 1)
			return interacoes + variavel;
		else
			return System.nanoTime() - startTime;
    }
	
}
