package Arvores;

import Auxiliar.NoArv;

public class ArvoreBin<tipo> {
	NoArv<tipo> raiz = new NoArv<tipo>(null, null, null, null);
	int tamanho;
	
	public NoArv<tipo> getRaiz() {
		return raiz;
	}
	
	public void inserirRaiz(tipo elemento) {
		if(raiz == null)
			raiz = new NoArv<tipo>(null,null,null,elemento);
	}
	
	public NoArv<tipo> inserirEsq(tipo elemento, NoArv<tipo> noBase) {
		if(noBase == null)
			return null;
		if(noBase.getEsquerda() != null)
			return noBase.getEsquerda();
		
		NoArv<tipo> novoNo = new NoArv<tipo>(noBase,null,null,elemento);
		noBase.setEsquerda(novoNo);
		return novoNo;
	}
	
	public NoArv<tipo> inserirDir(tipo elemento, NoArv<tipo> noBase) {
		if(noBase == null)
			return null;
		if(noBase.getDireita() != null)
			return noBase.getDireita();
		
		NoArv<tipo> novoNo = new NoArv<tipo>(noBase,null,null,elemento);
		noBase.setDireita(novoNo);
		return novoNo;
	}

	public void prefixado(NoArv<tipo> no) {
		if(no != null) {
			System.out.println(no.getElemento());
			prefixado(no.getEsquerda());
			prefixado(no.getDireita());
		}
	}
	
	public void posfixado(NoArv<tipo> no) {
		if(no != null) {
			posfixado(no.getEsquerda());
			posfixado(no.getDireita());
			System.out.println(no.getElemento());
		}
	}
	
	public void interfixado(NoArv<tipo> no) {
		if(no != null) {
			interfixado(no.getEsquerda());
			System.out.println(no.getElemento());
			interfixado(no.getDireita());
		}
	}
	
	public int profundidade(NoArv<tipo> noBase) {
		if(noBase.getPai() == null) {
			return 0;
		}
		noBase = noBase.getPai();
		return 1 + profundidade(noBase);
	}
	
	public boolean isExternal(NoArv<tipo> no) {
		if(no != null && no.getEsquerda() == null && no.getDireita() == null)
			return true;
		return false;
	}
	
	public boolean isInternal(NoArv<tipo> no) {
		if(no != null && (no.getEsquerda() != null || no.getDireita() != null))
			return true;
		return false;
	}
	
	public int altura() {
		return tamanho;
	}
}
