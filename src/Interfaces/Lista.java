package Interfaces;

public interface Lista {
	//Insere elementos no inicio da lista
	public void insereInicio(Integer elemento);
	
	//Insere elementos no fim da lista
	public void insereFim(Integer elemento);
	
	//Insere elementos em uma posição específica da lista
	public void inserePosicao(Integer elemento, int posicao);
	
	//Insere elementos na ordenação correta
	public void insereOrdenado(Integer elemento);
	
	
	//Remove elementos no inicio da lista
	public Integer removeInicio();
	
	//Remove elementos no fim da lista
	public Integer removeFim();
	
	//Remove elementos em um posicao específica da lista
	public Integer removePosicao(int posicao);
	
	
	//Verifica se a lista está cheia
	public boolean listaCheia();
	
	//Mostra os elementos da lista
	public void mostrarLista();
	
}
