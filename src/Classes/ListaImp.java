package Classes;

import Interfaces.Lista;

public class ListaImp implements Lista{
	
	private Integer lista[];
	private int tamanho;
	private int pos = -1;
	
	public ListaImp(int tamanho) {
		lista = new Integer[tamanho];
		this.tamanho = tamanho;
	}
	
	
	@Override
	public void insereInicio(Integer elemento) {
		// TODO Auto-generated method stub
		if(!listaCheia()) {
			for(int k = pos; 0 <= k; k--)
				lista[k+1] = lista[k];
			lista[0] = elemento;
			pos++;
		}
	}

	
	@Override
	public void insereFim(Integer elemento) {
		// TODO Auto-generated method stub
		if(!listaCheia()) {
			lista[++pos] = elemento;
		}
	}

	
	@Override
	public void inserePosicao(Integer elemento, int posicao) {
		// TODO Auto-generated method stub
		if(!listaCheia()) {
			for(int k = pos; posicao <= k; k--)
				lista[k+1] = lista[k];
			lista[posicao] = elemento;
			pos++;
		}
	}
	
	
	@Override
	public void insereOrdenado(Integer elemento) {
		// TODO Auto-generated method stub
		if(!listaCheia()) {
			for(int k = 0; k <= pos; k++) {
				if(elemento < lista[k]) {
					inserePosicao(elemento, k);
					break;
				} else if(k == pos) {
					inserePosicao(elemento, k+1);
					break;
				}
			}
		}
	}
	
	
	@Override
	public Integer removeInicio() {
		// TODO Auto-generated method stub
		if(pos != -1) {
			Integer numero = lista[0];
			for(int k = 0; k < pos; k++)
				lista[k] = lista[k+1];
			lista[pos] = null;
			pos--;
			return numero;
		}
		System.out.println("Lista Vazia!");
		return null;
	}

	
	@Override
	public Integer removeFim() {
		// TODO Auto-generated method stub
		if(pos != -1) {
			Integer numero = lista[pos];
			lista[pos--] = null;
			return numero;
		}
		System.out.println("Lista Vazia!");
		return null;
	}

	
	@Override
	public Integer removePosicao(int posicao) {
		// TODO Auto-generated method stub
		if(pos != -1) {
			Integer numero = lista[0];
			for(int k = posicao; k < pos; k++)
				lista[k+1] = lista[k];
			lista[pos] = null;
			pos--;
			return numero;
		}
		System.out.println("Lista Vazia!");
		return null;
	}

	
	@Override
	public boolean listaCheia() {
		// TODO Auto-generated method stub
		if(tamanho - 1 == pos) {
			System.out.println("Lista Cheia!");
			return true;
		}
		return false;
	}


	@Override
	public void mostrarLista() {
		// TODO Auto-generated method stub
		if(pos != -1) {
			for(int k = 0; k <= pos; k++)
				System.out.print(lista[k] + "\t");
			System.out.println();
		} else 
			System.out.println("A lista não possui elementos!");
	}


	
	
	
	
	// Métodos Adicionais
	public boolean listaOrdenada() {
		// TODO Auto-generated method stub
		int cont = 0;
		for(int k = 0; k < pos; k++) {
			if(lista[k] < lista[k+1])
				cont++;
		}
		if(cont == pos)
			return true;
		System.out.println("A lista não está ordenada!");
		return false;
	}


	public void ordenarListaCresc() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pos; i++)
			for(int j = 0; j < pos; j++)
				if(lista[j + 1] < lista[j]) {
					int aux = lista[j];
					lista[j] = lista[j + 1];
					lista[j + 1] = aux;
				}
	}


	public Integer index(Integer elemento) {
		// TODO Auto-generated method stub
		for(int k = 0; k < this.tamanho; k++)
			if(lista[k] == elemento)
				return k;
		return null;
	}
	
	
	
	public Integer[] inversao1() { // inversão total
		Integer novaLista[] = new Integer[tamanho];
		int nulos = 0;
		
		for(int k = 0; k<=pos; k++) {
			novaLista[k - nulos] = lista[pos - k];
			if(lista[pos - k] == null) nulos++;
		}
		this.lista = novaLista;
		return novaLista;
	}
	
	public Integer[] inversao2() { // primeiro elemento será o último
		Integer novaLista[] = new Integer[tamanho];
		int primeiro = lista[0];
		
		for(int k = 0; k<=pos; k++) {
			novaLista[k] = (k==pos) ? primeiro: lista[k+1];
		}
		this.lista = novaLista;
		return novaLista;
	}
	
	public Integer antepenultimo() {
		Integer antepenultimo = null;
		Integer penultimo = null;
		for(int k = 0; k<=pos; k++) {
			if(lista[k] == null)
				break;
			antepenultimo = penultimo;
			penultimo = lista[k];
		}
		return antepenultimo;
	}
	
	public Integer esvaziarLista() {
		if(pos == -1)
			return null;
		lista[pos--] = esvaziarLista();
		return null;
	}
}
