package Interfaces;

public interface Pilha {
	
	// insere um elemento à estrutura
	public void inserirElemento(Integer num);
	
	// remove um elemento da estrutura
	public Integer removerElemento();
	
	// verifica se a fila está cheia
	public boolean estruturaCheia();
	
	// mostra os elementos da estrutura
	public void mostrarEstrutura();
	
}
