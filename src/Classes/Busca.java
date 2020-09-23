package Classes;

public class Busca {
	
	String[] nomes = {"a", "b", "c", "d", "e"};
	String[] links = {"aaa", "bbb", "ccc", "ddd", "eee"};
	
	public String buscar(String valor) {
		String nome = "", link = "";
		boolean encontrado = false;
		
		for(int k = nomes.length - 1; 0 <= k ; k--) {
			if(valor == nomes[k]) {
				nome = nomes[k];
				link = links[k];
				encontrado = true;
			} else if(k != nomes.length - 1 && encontrado) {
				nomes[k+1] = nomes[k];
				links[k+1] = links[k];
			}
		}
		
		nomes[0] = nome;
		links[0] = link;
		
		return link;
	}
	
	// Uma estrutura de dados é uma coleção tanto de valores (e seus relacionamentos) quanto de operações
	// (sobre os valores e estruturas decorrentes). É uma implementação concreta de um tipo abstrato de dado (TAD)
	// o tipo abstrato de dado (TAD) é uma especificação de um conjunto de dados e operações que podem ser executadas sobre esses dados.
	
	/*
	 * Um array (também vetor) é uma ED linear e usualmente homogênea. Os ponteiros ficam então implícitos e representados 
	 * como inteiros, índices para recuperação randômica de valores na ED em tempo constante. A remoção e 
	 * (inserção de novos valores sem a remoção) pode ser custosa.
	 * 
	 * Uma lista (abreviação de lista ligada) é uma estrutura de dados linear e heterogênea.
	 * Elementos podem ser removidos ou inseridos no início, no fim e em uma posição específica dada pelo usuário.
	 * 
	 * Uma fila é uma estrutura de dados baseada no princípio FIFO (first in, first out), que significa o primeiro que entra 
	 * é o primeiro que sai. Possue duas funções básicas: adiciona um elemento ao final da fila e que remove o elemento no início da fila.
	 * 
	 * Uma pilha é uma estrutura de dados baseada no princípio LIFO (LAST in, FIRST out), que significa o último que
	 * entra é o primeiro que sai. Possue duas funções básicas: que insere um dado no topo da pilha e que remove o item no topo da pilha.
	 * 
	 */
	public void mostrar() {
		for(int k = 0; k < nomes.length ; k++) {
			System.out.println(nomes[k] + " - " + links[k]);
		}
	}
	
}
