package Principal;

public class Sort extends Core{
	
	public void Bubble_Sort(int v[]) {
		// for utilizado para controlar a quantidade de vezes que o vetor ser� ordenado.
		for(int i = tamanho; i >= 1; i--) {
			// for utilizado para ordenar o vetor.
            for(int j = 1; j < i; j++) {
            	/* Se o valor da posi��o atual do vetor for maior que o proximo valor,
                ent�o troca os valores de lugar no vetor. */
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
	}

}
