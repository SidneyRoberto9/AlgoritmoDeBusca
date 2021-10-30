package Principal;

public class Main extends Core {
	public static void main(String[] args) {
		int vetor[] = new int[tamanho];
		int numero_pesquisado = 40;
		
		//Instanciando os objetos para as fun��es de busca e sort
		Sort sort = new Sort();
		Busca busca = new Busca();
		
		//Vetor aleatorios de 1 ate 50 com valores unicos
		vetor_aleatorio(vetor);
		
		//Criando um vetor organizado pelo Bubble Sort
		int vetor_bubble[] = vetor.clone();
		sort.Bubble_Sort(vetor_bubble);
		 
	    //Monstrando vetor gerado pela math
	    printVetorAleatorio(vetor);
	    
		printInteracoesSort(vetor_bubble, numero_pesquisado);
		System.out.format("Busca Linear Sem Sort - %d intera��es.\n", busca.Busca_Linear(vetor, numero_pesquisado));
	}
}
