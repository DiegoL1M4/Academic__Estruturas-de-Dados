package ClassesEncadeadas;

import Auxiliar.No;

public class ListaSimpEnc<tipo> {
	
	private No<tipo> inicio;
	private int tamanho;
	
	
	/* ######################### Métodos de Inserção ######################### */
	public void inserirInicio(tipo elemento) {
		if(inicio == null)
			inicio = new No<tipo>(elemento, null);
		else
			inicio = new No<tipo>(elemento, inicio);
		
		tamanho++;
	}
	
	public void inserirPosicao(tipo elemento, int posicao) {
		if(inicio == null)
			inicio = new No<tipo>(elemento, null);
		else {
			if(posicao > tamanho) {
				System.out.println("Posição não existe na lista!");
				return;
			}
			No<tipo> aux = inicio;
			for(int k = 1; k<posicao; k++)
				aux = aux.getProximo();
			
			if(posicao == 0) {
				inserirInicio(elemento);
				return;
			} else
				aux.setProximo(new No<tipo>(elemento, aux.getProximo()));
		}
		
		tamanho++;
	}
	
	public void inserirFim(tipo elemento) {
		if(inicio == null)
			inicio = new No<tipo>(elemento, null);
		else
			getCauda().setProximo(new No<tipo>(elemento, null));
		
		tamanho++;
	}
	
	
	
	/* ######################### Métodos de Remoção ######################### */
	public tipo removerInicio() {
		if(inicio == null)
			return null;
		
		No<tipo> aux = inicio;
		
		inicio = inicio.getProximo();
		
		aux.setProximo(null);
		
		tamanho--;
		
		return aux.getElemento();
	}
	
	public tipo removerPosicao(int posicao) {
		if(inicio == null)
			return null;
		if(posicao >= tamanho) {
			System.out.println("Posição não existe na lista!");
			return null;
		}
		
		No<tipo> noAnterior = inicio;
		No<tipo> noRemover = null;
		tipo removido = null;
		
		for(int k = 0; k < posicao - 1; k++) // para no elemento anterior ao da posicao
			noAnterior = noAnterior.getProximo();
		
		noRemover = noAnterior.getProximo();
		
		if(posicao == 0)
			removido = removerInicio();
		else {
			noAnterior.setProximo(noRemover.getProximo()); // nova referencia
			noRemover.setProximo(null); // setando a referencia do elemento eliminado
			removido = noRemover.getElemento();
			tamanho--;
		}
		
		return removido;
	}
	
	public tipo removerFim() {
		if(inicio == null)
			return null;
		
		No<tipo> aux = inicio;
		No<tipo> aux2 = null;
		
		while(aux.getProximo().getProximo() != null)
			aux = aux.getProximo();
		
		aux2 = aux.getProximo();
		
		aux.setProximo(null);
		
		tamanho--;
		
		return aux2.getElemento();
	}
	
	
	/* ######################### Auxiliares ######################### */
	public void mostrarLista() {
		if(inicio == null)
			System.out.println("Lista Vazia!\n");
		else {
			No<tipo> aux = inicio;
			
			System.out.print("Lista: ");
			while(aux != null) {
				System.out.print(aux.getElemento() + "\t");
				aux = aux.getProximo();
			}
			
			System.out.println("\n");
		}
	}
	
	
	public No<tipo> getCauda() {
		if(inicio == null)
			return null;
			
		No<tipo> aux = inicio;
		
		while(aux.getProximo() != null)
			aux = aux.getProximo();
		
		return aux;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// ############################## MÉTODOS DA PROVA PASSADA ##############################
	public void addAntes(tipo elemento, int pos) {
		if(pos - 1 < 0) {
			System.out.println("Extrapola o limite!");
			return;
		}
		inserirPosicao(elemento, pos - 1);
	}
	
	public void addApos(tipo elemento, int pos) {
		if(tamanho <= pos + 1) {
			System.out.println("Extrapola o limite!");
			return;
		}
		inserirPosicao(elemento, pos + 1);
	}

	public tipo removeElemento(tipo elemento) {
		int pos = 0;
		boolean naoExiste = true;
		No<tipo> aux = inicio;
		
		for(int k = 0; k < tamanho; k++) {
			if(aux.getElemento() == elemento) {
				naoExiste = false;
				pos = k;
				break;
			}
			aux = aux.getProximo();
		}
		
		if(naoExiste) {
			System.out.println("Não existe esse elemento");
			return null;
		}
		
		
		return removerPosicao(pos);
	}
	
	public tipo first() {
		if(tamanho == 0)
			return null;
		
		return inicio.getElemento();
	}
	
	public tipo last() {
		if(tamanho == 0)
			return null;
		
		return getCauda().getElemento();
	}
	
	public tipo anterior(int pos) {
		if(pos - 1 < 0 || tamanho < pos)
			return null;
		
		No<tipo> aux = inicio;
		for(int k = 0; k < pos - 1; k++)
			aux = aux.getProximo();
		
		return aux.getElemento();
	}
	
	public tipo posterior(int pos) {
		if(tamanho <= pos + 1 || tamanho <= pos)
			return null;
			
		No<tipo> aux = inicio;
		for(int k = 0; k < pos + 1; k++)
			aux = aux.getProximo();
		
		return aux.getElemento();
	}
	
	public void insereOrdenado(tipo elemento) {
		No<tipo> aux = inicio;
		
		for(int k = 0; k < tamanho; k++) {
			/*if(elemento < aux.getElemento()) {
				inserirPosicao(elemento, k);
				break;
			}*/
			aux = aux.getProximo();
		}
		
		
	}
	
	
	
	
	
	
	
	
	// ####################################### MÉTODOS DA PROVA DO SEMESTRE PASSADO ###################################################
	// Questão1
	public tipo antePenultimo() {
		if(tamanho < 3) {
			System.out.println("Não existe ante penultimo!");
			return null;
		}
		
		No<tipo> aux = inicio;
		while(aux.getProximo().getProximo().getProximo() != null)
			aux = aux.getProximo();
		
		return aux.getElemento();
	}
	// Questão2a (Inverter)
	public void inverter() {
		No<tipo> aux = inicio;
		int metade = tamanho/2;
		for(int k = 0; k < metade; k++) {
			tipo valor = aux.getElemento();
			aux.setElemento(getNo(tamanho-k-1).getElemento());
			getNo(tamanho-k-1).setElemento(valor);
			
			aux = aux.getProximo();
		}
	}
	public ListaSimpEnc<tipo> inverterCriando() {
		No<tipo> aux = inicio;
		ListaSimpEnc<tipo> listaNova = new ListaSimpEnc<tipo>();
		
		for(int k = 0; k < tamanho; k++) {
			listaNova.inserirInicio(aux.getElemento());
			aux = aux.getProximo();
		}

		return listaNova;
	}
	
	// Questão2b (Elemento 1 será o último)
	public void primeiroUltimo() {
		
		No<tipo> aux = inicio;
		tipo primeiro = aux.getElemento();
		while(aux != null) {
			if(aux.getProximo() == null)
				aux.setElemento(primeiro);
			else
				aux.setElemento(aux.getProximo().getElemento());
			
			aux = aux.getProximo();
		}
	}
	public ListaSimpEnc<tipo> primeiroUltimoCriando() {
		
		No<tipo> aux = inicio;
		ListaSimpEnc<tipo> listaNova = new ListaSimpEnc<tipo>();
		
		tipo primeiro = aux.getElemento();
		while(aux.getProximo() != null) {
			aux = aux.getProximo();
			listaNova.inserirFim(aux.getElemento());
		}
		
		listaNova.inserirFim(primeiro);
		listaNova.mostrarLista();
		return listaNova;
	}
	
	
	// Questão3
	
	
	// Questão4
	//Classe INVERTER no default package
	
	// Questão5
	
	
	
	
	
	
	
	
	// ############################## MÉTODOS COMPLEMENTARES ##############################
	public int index(tipo elemento) {
		int pos = 0;
		boolean naoExiste = true;
		No<tipo> aux = inicio;
		
		for(int k = 0; k < tamanho; k++) {
			if(aux.getElemento() == elemento) {
				naoExiste = false;
				pos = k;
				break;
			}
			aux = aux.getProximo();
		}
		
		if(naoExiste) {
			System.out.println("Não existe esse elemento");
			return -1;
		}
		
		
		return pos;
	}
	
	public No<tipo> getNo(int pos) {
		No<tipo> aux = inicio;
		
		for(int k = 0; k < pos; k++)
			aux = aux.getProximo();
		
		return aux;
	}
	
	public tipo getElemento(int pos) {
		No<tipo> aux = inicio;
		
		for(int k = 0; k < pos; k++)
			aux = aux.getProximo();
		
		return aux.getElemento();
	}
	
	public void setElemento(tipo elemento, int pos) {
		No<tipo> aux = inicio;
		
		for(int k = 0; k < pos; k++)
			aux = aux.getProximo();
		
		aux.setElemento(elemento);
	}
	
	public void ordenarLista() {
		for(int i = 0; i < tamanho; i++) {
			No<tipo> aux = inicio;
			for(int j = 0; j < tamanho - 1; j++) {
				//if(aux.getElemento() > aux.getProximo().getElemento())
					inverteNos(aux, aux.getProximo());
				aux = aux.getProximo();
			}
		}
	}
	
	public void inverteNos(No<tipo> no1, No<tipo> no2) {
			tipo aux = no1.getElemento();
			no1.setElemento(no2.getElemento());
			no2.setElemento(aux);
	}
	
}
















