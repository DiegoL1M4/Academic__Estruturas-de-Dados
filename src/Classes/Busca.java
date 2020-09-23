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
	
	// Uma estrutura de dados � uma cole��o tanto de valores (e seus relacionamentos) quanto de opera��es
	// (sobre os valores e estruturas decorrentes). � uma implementa��o concreta de um tipo abstrato de dado (TAD)
	// o tipo abstrato de dado (TAD) � uma especifica��o de um conjunto de dados e opera��es que podem ser executadas sobre esses dados.
	
	/*
	 * Um array (tamb�m vetor) � uma ED linear e usualmente homog�nea. Os ponteiros ficam ent�o impl�citos e representados 
	 * como inteiros, �ndices para recupera��o rand�mica de valores na ED em tempo constante. A remo��o e 
	 * (inser��o de novos valores sem a remo��o) pode ser custosa.
	 * 
	 * Uma lista (abrevia��o de lista ligada) � uma estrutura de dados linear e heterog�nea.
	 * Elementos podem ser removidos ou inseridos no in�cio, no fim e em uma posi��o espec�fica dada pelo usu�rio.
	 * 
	 * Uma fila � uma estrutura de dados baseada no princ�pio FIFO (first in, first out), que significa o primeiro que entra 
	 * � o primeiro que sai. Possue duas fun��es b�sicas: adiciona um elemento ao final da fila e que remove o elemento no in�cio da fila.
	 * 
	 * Uma pilha � uma estrutura de dados baseada no princ�pio LIFO (LAST in, FIRST out), que significa o �ltimo que
	 * entra � o primeiro que sai. Possue duas fun��es b�sicas: que insere um dado no topo da pilha e que remove o item no topo da pilha.
	 * 
	 */
	public void mostrar() {
		for(int k = 0; k < nomes.length ; k++) {
			System.out.println(nomes[k] + " - " + links[k]);
		}
	}
	
}
