package Interfaces;

public interface Lista {
	//Insere elementos no inicio da lista
	public void insereInicio(Integer elemento);
	
	//Insere elementos no fim da lista
	public void insereFim(Integer elemento);
	
	//Insere elementos em uma posi��o espec�fica da lista
	public void inserePosicao(Integer elemento, int posicao);
	
	//Insere elementos na ordena��o correta
	public void insereOrdenado(Integer elemento);
	
	
	//Remove elementos no inicio da lista
	public Integer removeInicio();
	
	//Remove elementos no fim da lista
	public Integer removeFim();
	
	//Remove elementos em um posicao espec�fica da lista
	public Integer removePosicao(int posicao);
	
	
	//Verifica se a lista est� cheia
	public boolean listaCheia();
	
	//Mostra os elementos da lista
	public void mostrarLista();
	
}
