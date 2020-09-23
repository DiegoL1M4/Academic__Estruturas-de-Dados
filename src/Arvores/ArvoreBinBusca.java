package Arvores;

import Auxiliar.NoArv;

public class ArvoreBinBusca {
	
	public NoArv<Integer> raiz = new NoArv<Integer>(null, null, null, null);
	int tamanho;
	
	public NoArv<Integer> inserir(Integer elemento) {
		if(raiz.getElemento() == null) {
			raiz.setElemento(elemento);
			return raiz;
		}
		
		NoArv<Integer> aux = raiz;
		tamanho++;
		NoArv<Integer> novoNo;
		
		while(true) {
			if(elemento < aux.getElemento()) {
				if(aux.getEsquerda() == null) {
					novoNo = new NoArv<Integer>(aux, null, null, elemento);
					aux.setEsquerda(novoNo);
					return novoNo;
				} else {
					aux = aux.getEsquerda();
					continue;
				}
			}
			
			if(aux.getElemento() < elemento) {
				if(aux.getDireita() == null) {
					novoNo = new NoArv<Integer>(aux, null, null, elemento);
					aux.setDireita(novoNo);
					return novoNo;
				} else {
					aux = aux.getDireita();
					continue;
				}
			}
			if(aux.getElemento() == elemento)
				return null;
			
		}
			
	}
	
	public NoArv<Integer> inserir2(NoArv<Integer> noBase, Integer elemento) {
		if(raiz.getElemento() == null) {
			raiz.setElemento(elemento);
			return raiz;
		}
		
		NoArv<Integer> novoNo = null;
		
		if(elemento < noBase.getElemento()) {
			if(noBase.getEsquerda() == null) {
				novoNo = new NoArv<Integer>(noBase, null, null, elemento);
				noBase.setEsquerda(novoNo);
			} else {
				inserir2(noBase.getEsquerda(), elemento);
			}
		} else if(noBase.getElemento() < elemento) {
			if(noBase.getDireita() == null) {
				novoNo = new NoArv<Integer>(noBase, null, null, elemento);
				noBase.setDireita(novoNo);
			} else {
				inserir2(noBase.getDireita(), elemento);
			}
			
		}
		
		return novoNo;
			
	}
	
	public void mostrarPrefixado() {
		prefixado(raiz);
	}
	public void prefixado(NoArv<Integer> no) {
		if(no != null) {
			System.out.println(no.getElemento());
			prefixado(no.getEsquerda());
			prefixado(no.getDireita());
		}
	}
	
	public void mostrarPosfixado() {
		posfixado(raiz);
	}
	public void posfixado(NoArv<Integer> no) {
		if(no != null) {
			posfixado(no.getEsquerda());
			posfixado(no.getDireita());
			System.out.println(no.getElemento());
		}
	}
	
	public void mostrarInterfixado() {
		interfixado(raiz);
	}
	public void interfixado(NoArv<Integer> no) {
		if(no != null) {
			interfixado(no.getEsquerda());
			System.out.println(no.getElemento());
			interfixado(no.getDireita());
		}
	}
	
	public void prefixadoAlterado(NoArv<Integer> no, int k) {
		if(no != null) {
			if(profundidade(no) == k) {
				for(int l = 0; l < Math.pow(2,altura(no))-1; l++)
					System.out.print("  ");
				
				if(no.getElemento()<10) System.out.print('0');
				System.out.print(no.getElemento());
				
				
			} else {
				prefixadoAlterado(no.getEsquerda(), k);
				for(int l = 0; l < Math.pow(2,altura(no))-1; l++)
					System.out.print("  ");
				prefixadoAlterado(no.getDireita(), k);
			}
		}
	}
	
	public void mostrarEstruturado() {
		for(int k = 0; k <= altura(raiz); k++) {
			prefixadoAlterado(raiz,k);
			System.out.println();
		}
	}
	
	public int profundidade(NoArv<Integer> noBase) {
		if(noBase.getPai() == null) {
			return 0;
		}
		noBase = noBase.getPai();
		return 1 + profundidade(noBase);
	}
	
	public boolean isExternal(NoArv<Integer> no) {
		if(no != null && no.getEsquerda() == null && no.getDireita() == null)
			return true;
		return false;
	}
	
	public boolean isInternal(NoArv<Integer> no) {
		if(no != null && (no.getEsquerda() != null || no.getDireita() != null))
			return true;
		return false;
	}
	
	public boolean isRoot(NoArv<Integer> no) {
		if(no == raiz)
			return true;
		return false;
	}
	
	public int altura(NoArv<Integer> no) {
		if (no == null || isExternal(no))
			return 0;
		else
			return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
	}
	
	public Integer[] recolher(NoArv<Integer> no) {
		Integer[] lista = {};
		if(no != null) {
			Integer[] listaEsq = recolher(no.getEsquerda());
			
			Integer[] listaDir = recolher(no.getDireita());
			
			lista = new Integer[listaEsq.length + 1 + listaDir.length];
			for(int k = 0; k < listaEsq.length; k++) {
				lista[k] = listaEsq[k];
			}
			lista[listaEsq.length] = no.getElemento();
			for(int k = 0; k < listaDir.length; k++) {
				lista[listaEsq.length + 1 + k] = listaDir[k];
			}
		}
		return lista;
	}
	
	public ArvoreBinBusca balancear() {
		ArvoreBinBusca arvoreBalanceada = new ArvoreBinBusca();
		
		Integer[] lista = recolher(raiz);
		int tamanho = lista.length;
		int total = tamanho/2;
		for(int k = 0; k < lista.length; k++) {
			int atual = total;
			while(atual < lista.length && atual != 0) {
				arvoreBalanceada.inserir(lista[atual]);
				atual += tamanho;
			}
			tamanho = total;
			total = total/2;
		}
		for(int k = 0; k < lista.length; k++) {
			arvoreBalanceada.inserir(lista[k]);
		}
		
		return arvoreBalanceada;
	}
	
	public void remover(NoArv<Integer> no) {
		if(isExternal(no)) {
			char res = posicaoNoPai(no.getPai(), no);
			if(res == 'E')
				no.getPai().setEsquerda(null);
			else
				no.getPai().setDireita(null);
			return;
		}
		
		NoArv<Integer> menor = menorValor(no.getDireita());
		
		// Casos de exclusão
		if(isExternal(menor)) {
			char res = posicaoNoPai(menor.getPai(), menor);
			if(res == 'E')
				menor.getPai().setEsquerda(null);
			else
				menor.getPai().setDireita(null);
			
		} else if(menor.getDireita() == null) {
			char res = posicaoNoPai(menor.getPai(), menor);
			if(res == 'E')
				menor.getPai().setEsquerda(menor.getEsquerda());
			else
				menor.getPai().setDireita(menor.getEsquerda());
			menor.getEsquerda().setPai(menor.getPai()); // definindo novo pai
			
		} else if(menor.getEsquerda() == null) {
			char res = posicaoNoPai(menor.getPai(), menor);
			if(res == 'E')
				menor.getPai().setEsquerda(menor.getDireita());
			else
				menor.getPai().setDireita(menor.getDireita());
			menor.getDireita().setPai(menor.getPai()); // definindo novo pai
			
		} else {
			// não sei ainda
			// acho que não precisa
		}
		
		// Substituindo o no
		menor.setPai(no.getPai());
		menor.setEsquerda(no.getEsquerda());
		menor.setDireita(no.getDireita());
		
		// Substituindo se for raiz
		if(isRoot(no))
			raiz = menor;
		
		// Excluindo as referencias do no
		no.setPai(null);
		no.setEsquerda(null);
		no.setDireita(null);
			
	}
	
	public NoArv<Integer> menorValor(NoArv<Integer> no) {
		if (no == null)
			return null;
		if (isExternal(no))
			return no;
		
		NoArv<Integer> noE = menorValor(no.getEsquerda());
		NoArv<Integer> noD = menorValor(no.getDireita());
		
		NoArv<Integer> menor = null;
		
		if(noE == null)
			menor = noD;
		else if(noD == null)
			menor = noE;
		else if(noE.getElemento() < noD.getElemento())
			menor = noE;
		else if(noE.getElemento() > noD.getElemento())
			menor = noD;
		
		if(no.getElemento() < menor.getElemento())
			return no;
		
		return menor;
	}
	
	public char posicaoNoPai(NoArv<Integer> noPai, NoArv<Integer> noFilho) {
		if(noPai.getEsquerda() == noFilho)
			return 'E';
		if(noPai.getDireita() == noFilho)
			return 'D';
		return 'N';
	}

}
