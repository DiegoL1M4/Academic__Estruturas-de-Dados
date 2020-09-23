package ClassesEncadeadas;

import Auxiliar.NoDuplo;

public class ListaDuplEnc<tipo> {
	
	private NoDuplo<tipo> header;
	private NoDuplo<tipo> trailer;
	
	private int tamanho;
	
	public ListaDuplEnc() {
		header = new NoDuplo<tipo>(null, null, null);
		trailer = new NoDuplo<tipo>(null, header, null);
		header.setProximo(trailer);
	}
	
	
	/* ######################### Metodos de Insercao ######################### */
	public void insereInicio(NoDuplo<tipo> novoNo) {
		NoDuplo<tipo> primeiroNo = header.getProximo();
		
		header.setProximo(novoNo);
		
		novoNo.setAnterior(header);
		novoNo.setProximo(primeiroNo);
		
		primeiroNo.setAnterior(novoNo);
		
		tamanho++;
	}
	
	public void inserePosicao(NoDuplo<tipo> novoNo, int pos) {
		if(tamanho < pos)
			return;
		
		NoDuplo<tipo> aux = header;
		
		for(int k = 0; k < pos; k++)
			aux = aux.getProximo();
		
		aux.getProximo().setAnterior(novoNo);
		
		novoNo.setAnterior(aux);
		novoNo.setProximo(aux.getProximo());
		
		aux.setProximo(novoNo);
		
		tamanho++;
	}
	
	public void insereFim(NoDuplo<tipo> novoNo) {
		
		trailer.getAnterior().setProximo(novoNo);
		
		novoNo.setAnterior(trailer.getAnterior());
		novoNo.setProximo(trailer);
		
		trailer.setAnterior(novoNo);
		
		tamanho++;
	}
	
	
	/* ######################### Metodos de Remocao ######################### */
	public tipo removeInicio() {
		if(tamanho == 0) {
			System.out.println("Nao ha elementos!");
			return null;
		}

		tipo valor = header.getProximo().getElemento();
		header.setProximo(header.getProximo().getProximo());
		
		header.getProximo().getAnterior().setAnterior(null);
		header.getProximo().getAnterior().setProximo(null);
		
		header.getProximo().setAnterior(header);
		
		tamanho--;
		return valor;
	}
	
	public tipo removePosicao(int pos) {
		if(tamanho < pos) {
			System.out.println("Excede ao limite!");
			return null;
		}
		
		NoDuplo<tipo> aux = header;
		
		for(int k = 0; k < pos; k++)
			aux = aux.getProximo();
		
		
		tipo valor = aux.getProximo().getElemento();
		aux.setProximo(aux.getProximo().getProximo());
		
		aux.getProximo().getAnterior().setAnterior(null);
		aux.getProximo().getAnterior().setProximo(null);
		
		aux.getProximo().setAnterior(aux);
		
		tamanho--;
		return valor;
	}
	
	public tipo removeFim() {
		if(tamanho == 0) {
			System.out.println("Nao ha elementos!");
			return null;
		}
		
		tipo valor = trailer.getAnterior().getElemento();
		trailer.setAnterior(trailer.getAnterior().getAnterior());
		
		trailer.getAnterior().getProximo().setAnterior(null);
		trailer.getAnterior().getProximo().setProximo(null);
		
		trailer.getAnterior().setProximo(trailer);
		
		tamanho--;
		return valor;
	}
	
	
	/* ######################### Auxiliares ######################### */
	public void mostrarLista() {
		if(tamanho == 0)
			System.out.println("Lista Vazia!\n");
		else {
			NoDuplo<tipo> aux = header;
			
			System.out.print("Lista: ");
			while(aux != null) {
				System.out.print(aux.getElemento() + "\t");
				aux = aux.getProximo();
			}
			
			System.out.println("\n");
		}
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	
	
	// ############################## MÉTODOS DA PROVA PASSADA ##############################
	public void addAntes(NoDuplo<tipo> novoNo, int pos) {
		if(pos - 1 < 0) {
			System.out.println("Extrapola o limite!");
			return;
		}
		inserePosicao(novoNo, pos - 1);
	}
	
	public void addApos(NoDuplo<tipo> novoNo, int pos) {
		if(tamanho <= pos + 1) {
			System.out.println("Extrapola o limite!");
			return;
		}
		inserePosicao(novoNo, pos + 1);
	}

	public tipo removeElemento(tipo elemento) {
		int pos = 0;
		boolean naoExiste = true;
		NoDuplo<tipo> aux = header;
		
		for(int k = 0; k < tamanho; k++) {
			aux = aux.getProximo();
			if(aux.getElemento() == elemento) {
				naoExiste = false;
				pos = k;
				break;
			}
		}
		
		if(naoExiste) {
			System.out.println("Não existe esse elemento");
			return null;
		}
		
		return removePosicao(pos);
	}
	
	public tipo first() {
		if(tamanho == 0)
			return null;
		
		return header.getProximo().getElemento();
	}
	
	public tipo last() {
		if(tamanho == 0)
			return null;
		
		return trailer.getAnterior() .getElemento();
	}
	
	public tipo anterior(int pos) {
		if(pos - 1 < 0 || tamanho < pos)
			return null;
		
		NoDuplo<tipo> aux = header;
		for(int k = 0; k < pos; k++)
			aux = aux.getProximo();
		
		return aux.getElemento();
	}
	
	public tipo posterior(int pos) {
		if(tamanho <= pos + 1 || tamanho <= pos)
			return null;
			
		NoDuplo<tipo> aux = header;
		for(int k = 0; k < pos + 2; k++)
			aux = aux.getProximo();
		
		return aux.getElemento();
	}
	
	
	// ############################## MÉTODOS COMPLEMENTARES ##############################
		public int index(tipo elemento) {
			int pos = 0;
			boolean naoExiste = true;
			NoDuplo<tipo> aux = header;
			
			for(int k = 0; k < tamanho; k++) {
				aux = aux.getProximo();
				if(aux.getElemento() == elemento) {
					naoExiste = false;
					pos = k;
					break;
				}
			}
			
			if(naoExiste) {
				System.out.println("Não existe esse elemento");
				return -1;
			}
			
			return pos;
		}
		
		public tipo getElemento(int pos) {
			NoDuplo<tipo> aux = header;
			
			for(int k = -1; k < pos; k++)
				aux = aux.getProximo();
			
			return aux.getElemento();
		}
		
		public void setElemento(tipo elemento, int pos) {
			NoDuplo<tipo> aux = header;
			
			for(int k = -1; k < pos; k++)
				aux = aux.getProximo();
			
			aux.setElemento(elemento);
		}
		
		public void ordenarLista() {
			for(int i = 0; i < tamanho; i++) {
				NoDuplo<tipo> aux = header;
				for(int j = 0; j < tamanho - 1; j++) {
					//if(aux.getElemento() > aux.getProximo().getElemento())
						inverteNos(aux, aux.getProximo());
					aux = aux.getProximo();
				}
			}
		}
		
		public void inverteNos(NoDuplo<tipo> no1, NoDuplo<tipo> no2) {
				tipo aux = no1.getElemento();
				no1.setElemento(no2.getElemento());
				no2.setElemento(aux);
		}
}
