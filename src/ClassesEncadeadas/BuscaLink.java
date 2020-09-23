package ClassesEncadeadas;

import Auxiliar.NoBusca;

public class BuscaLink {
	
	private NoBusca inicio;
	private int tamanho;
	
	
	/* ######################### Métodos de Inserção ######################### */
	public void inserirInicio(String nome, String link) {
		if(inicio == null)
			inicio = new NoBusca(nome, link, null);
		else
			inicio = new NoBusca(nome, link, inicio);
		
		tamanho++;
	}
	
	public void inserirPosicao(String nome, String link, int posicao) {
		if(inicio == null)
			inicio = new NoBusca(nome, link, null);
		else {
			if(posicao > tamanho) {
				System.out.println("Posição não existe na lista!");
				return;
			}
			NoBusca aux = inicio;
			for(int k = 1; k<posicao; k++)
				aux = aux.getProximo();
			
			if(posicao == 0) {
				inserirInicio(nome, link);
				return;
			} else
				aux.setProximo(new NoBusca(nome, link, aux.getProximo()));
		}
		
		tamanho++;
	}
	
	public void inserirFim(String nome, String link) {
		if(inicio == null)
			inicio = new NoBusca(nome, link, null);
		else
			getCauda().setProximo(new NoBusca(nome, link, null));
		
		tamanho++;
	}
	
	
	
	/* ######################### Métodos de Remoção ######################### */
	public NoBusca removerInicio() {
		if(inicio == null)
			return null;
		
		NoBusca aux = inicio;
		
		inicio = inicio.getProximo();
		
		aux.setProximo(null);
		
		tamanho--;
		
		return aux;
	}
	
	public NoBusca removerPosicao(int posicao) {
		if(inicio == null)
			return null;
		if(posicao >= tamanho) {
			System.out.println("Posição não existe na lista!");
			return null;
		}
		
		NoBusca noAnterior = inicio;
		NoBusca noRemover = null;
		NoBusca removido = null;
		
		for(int k = 0; k < posicao - 1; k++) // para no elemento anterior ao da posicao
			noAnterior = noAnterior.getProximo();
		
		noRemover = noAnterior.getProximo();
		
		if(posicao == 0)
			removido = removerInicio();
		else {
			noAnterior.setProximo(noRemover.getProximo()); // nova referencia
			noRemover.setProximo(null); // setando a referencia do elemento eliminado
			removido = noRemover;
			tamanho--;
		}
		
		return removido;
	}
	
	public NoBusca removerFim() {
		if(inicio == null)
			return null;
		
		NoBusca aux = inicio;
		NoBusca aux2 = null;
		
		while(aux.getProximo().getProximo() != null)
			aux = aux.getProximo();
		
		aux2 = aux.getProximo();
		
		aux.setProximo(null);
		
		tamanho--;
		
		return aux2;
	}
	
	
	/* ######################### Auxiliares ######################### */
	public void mostrarLista() {
		if(inicio == null)
			System.out.println("Lista Vazia!\n");
		else {
			NoBusca aux = inicio;
			
			System.out.print("Lista: \n");
			while(aux != null) {
				System.out.println(aux);
				aux = aux.getProximo();
			}
			
			System.out.println("\n\n");
		}
	}
	
	
	public NoBusca getCauda() {
		if(inicio == null)
			return null;
			
		NoBusca aux = inicio;
		
		while(aux.getProximo() != null)
			aux = aux.getProximo();
		
		return aux;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public String busca(String nome) {
		String link = "Não existe na lista!";
		NoBusca aux = inicio;
		int k = 0, posicao = -1;
		
		while(aux != null) {
			if(nome == aux.getNome()) {
				link = aux.getLink();
				posicao = k;
			}
			k++;
			aux = aux.getProximo();
		}
		
		if(posicao != -1) {
			NoBusca removido = removerPosicao(posicao);
			inserirInicio(removido.getNome(),removido.getLink());
		}
		
		return link;
	}
}
