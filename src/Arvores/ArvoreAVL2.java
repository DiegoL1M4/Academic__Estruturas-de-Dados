package Arvores;

import Auxiliar.*;

public class ArvoreAVL2 {
	
	public NoArv<Integer> raiz = null;
	
	public NoArv<Integer> inserir(Integer elemento){
		
		NoArv<Integer> novoNo = inserirRecursivo(raiz, elemento);
		
		// Balanceamento
		balanceamento(raiz);
		calculoFator(raiz);
		
		// Para fins de apresentação do trabalho
		System.out.println("Inserindo o " + elemento + ":");
		mostrarEstruturado();
		System.out.println();
		mostrarPrefixado();
		mostrarPosfixado();
		mostrarInterfixado();
		System.out.println("\n-------------------------------------------------------------\n");
		
		return novoNo;
	}
	
	public NoArv<Integer> inserirRecursivo(NoArv<Integer> noBase, Integer elemento) {
		if(raiz == null) {
			raiz = new NoArv<Integer>(null, null, null, elemento);
			return raiz;
		}
		
		NoArv<Integer> novoNo = null;
		
		if(elemento < noBase.getElemento()) {
			if(noBase.getEsquerda() == null) {
				novoNo = new NoArv<Integer>(noBase, null, null, elemento);
				noBase.setEsquerda(novoNo);
			} else {
				novoNo = inserirRecursivo(noBase.getEsquerda(), elemento);
			}
		} else if(noBase.getElemento() < elemento) {
			if(noBase.getDireita() == null) {
				novoNo = new NoArv<Integer>(noBase, null, null, elemento);
				noBase.setDireita(novoNo);
			} else {
				novoNo = inserirRecursivo(noBase.getDireita(), elemento);
			}
			
		}
		
		return novoNo;
			
	}
	
	public void remover(Integer elemento) {
		
		NoArv<Integer> no = pesquisa(elemento);
		
		if(no == null)
			return;
		
		if(isRoot(no) && no.getDireita() == null && no.getEsquerda() == null) {
			this.raiz = null;
		} else if((isRoot(no) && no.getDireita() == null) || (isRoot(no) && no.getEsquerda() == null)) {
			if(no.getDireita() == null) {
				raiz = no.getEsquerda();
				no.getEsquerda().setPai(null);
			} else {
				raiz = no.getDireita();
				no.getDireita().setPai(null);
			}
		} else if(isExternal(no)) {
			if(no.getPai().getEsquerda() == no)
				no.getPai().setEsquerda(null);
			else
				no.getPai().setDireita(null);
			
		} else if(no.getDireita() == null) {
			if(no.getPai().getEsquerda() == no)
				no.getPai().setEsquerda(no.getEsquerda());
			else
				no.getPai().setDireita(no.getEsquerda());
			no.getEsquerda().setPai(no.getPai()); // definindo novo pai
			if(isRoot(no)) raiz = no.getEsquerda();
		} else if(no.getEsquerda() == null) {
			if(no.getPai().getEsquerda() == no)
				no.getPai().setEsquerda(no.getDireita());
			else
				no.getPai().setDireita(no.getDireita());
			no.getDireita().setPai(no.getPai()); // definindo novo pai
			if(isRoot(no)) raiz = no.getDireita();
		} else {
			// Pega o menor valor a direita
			NoArv<Integer> menor = no.getDireita();
			while(true) {
				if(menor.getEsquerda() == null)
					break;
				menor = menor.getEsquerda();
			}
			
			if(menor.getPai() != no) {
				// Ligação do filho a esquerda do menor
				menor.getPai().setEsquerda(menor.getDireita());
				if(menor.getDireita() != null)
					menor.getDireita().setPai(menor.getPai());
			} else {
				no.setDireita(menor.getDireita());
			}
			
			// Substituindo o nó
			menor.setDireita(no.getDireita());
			menor.setEsquerda(no.getEsquerda());
			menor.setPai(no.getPai());
			if(no.getEsquerda() != null)
				no.getEsquerda().setPai(menor);
			if(no.getDireita() != null)
				no.getDireita().setPai(menor);
			
			if(no.getPai() == null) {
				raiz = menor;
			} else {
				if(no.getPai().getDireita() == no)
					no.getPai().setDireita(menor);
				else
					no.getPai().setEsquerda(menor);
			}
			
		}
		
		// Excluindo as referencias do no
		no.setPai(null);
		no.setEsquerda(null);
		no.setDireita(null);
		
		// Balanceamento
		balanceamento(raiz);
		calculoFator(raiz);
		
		// Para fins de apresentação do trabalho
		System.out.println("Removendo o " + elemento + ":");
		mostrarEstruturado();
		System.out.println();
		mostrarPrefixado();
		mostrarPosfixado();
		mostrarInterfixado();
		System.out.println("\n-------------------------------------------------------------\n");
			
	}

	
	public NoArv<Integer> pesquisa(Integer elemento) {
		NoArv<Integer> no = raiz;
		
		while(no != null) {
			if(elemento == no.getElemento())
				return no;
			else if(elemento > no.getElemento())
				no = no.getDireita();
			else if(elemento < no.getElemento())
				no = no.getEsquerda();
		}
		
		return null;
	}

	
	// Manipulacao de nos
	public int profundidade(NoArv<Integer> noBase) {
		if(noBase == null) {
			return 0;
		}
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
	
	
	// Mostra Arvore
	public void mostrarPrefixado() {
		System.out.print("Prefixado:");
		prefixado(raiz);
		System.out.println();
	}
	public void prefixado(NoArv<Integer> no) {
		if(no != null) {
			System.out.print("\t" + no.getElemento() + "/" + no.getFator());
			prefixado(no.getEsquerda());
			prefixado(no.getDireita());
		}
	}
	
	public void mostrarPosfixado() {
		System.out.print("Posfixado:");
		posfixado(raiz);
		System.out.println();
	}
	public void posfixado(NoArv<Integer> no) {
		if(no != null) {
			posfixado(no.getEsquerda());
			posfixado(no.getDireita());
			System.out.print("\t" + no.getElemento() + "/" + no.getFator());
		}
	}
	
	public void mostrarInterfixado() {
		System.out.print("Interfixado:");
		interfixado(raiz);
		System.out.println();
	}
	public void interfixado(NoArv<Integer> no) {
		if(no != null) {
			interfixado(no.getEsquerda());
			System.out.print("\t" + no.getElemento() + "/" + no.getFator());
			interfixado(no.getDireita());
		}
	}
	
	
	
	
	// Balanceamento
	public int alturaFator(NoArv<Integer> no) {
		if (no == null)
			return 0;
		else if(isExternal(no))
			return 1;
		else
			return 1 + Math.max(alturaFator(no.getEsquerda()), alturaFator(no.getDireita()));
	}
	
	public int fator(NoArv<Integer> no) {
		return alturaFator(no.getDireita()) - alturaFator(no.getEsquerda());
	}
	
	public void calculoFator(NoArv<Integer> no) {
		if(no != null) {
			calculoFator(no.getEsquerda());
			calculoFator(no.getDireita());
			no.setFator(fator(no));
		}
	}
	
	public void balanceamento(NoArv<Integer> no) {
		if(no != null) {
			balanceamento(no.getEsquerda());
			balanceamento(no.getDireita());
			rotacoes(no);
		}
	}
	
	public void rotacoes(NoArv<Integer> no) {
		NoArv<Integer> noPai = no.getPai();
		NoArv<Integer> novoNo = no;
		
		int fator = fator(no);
		boolean esquerda = true;
		
		// Definindo se o no esta a esquerda ou a direita no no pai
		if(noPai != null)
			if(no == noPai.getDireita())
				esquerda = false;
		
		if(fator == 2) {
			if(fator(no.getDireita()) >= 0)
				novoNo = RR(no);
			else
				novoNo = RL(no);
		} else if(fator == -2) {
			if(fator(no.getEsquerda()) <= 0)
				novoNo = LL(no);
			else
				novoNo = LR(no);
		}
		
		// Estabelecendo as relacoes para o novo no
		novoNo.setPai(noPai);
		if(esquerda && noPai != null)
			noPai.setEsquerda(novoNo);
		else if(noPai != null)
			noPai.setDireita(novoNo);
		
		// Unico caso do pai ser nulo é quando é a raiz
		if(noPai == null)
			raiz = novoNo;
	}			
	
	public NoArv<Integer> RR(NoArv<Integer> no) {
		NoArv<Integer> novoNo = no.getDireita();
		
		no.setPai(novoNo);
		no.setDireita(novoNo.getEsquerda());
		if(novoNo.getEsquerda() != null)
			novoNo.getEsquerda().setPai(no);
		
		novoNo.setEsquerda(no);
		novoNo.setPai(null);
		
		return novoNo;
	}
	
	public NoArv<Integer> LL(NoArv<Integer> no) {
		NoArv<Integer> novoNo = no.getEsquerda();
		
		no.setPai(novoNo);
		no.setEsquerda(novoNo.getDireita());
		if(novoNo.getDireita() != null)
			novoNo.getDireita().setPai(no);
		
		novoNo.setDireita(no);
		novoNo.setPai(null);
		
		return novoNo;
	}
	
	public NoArv<Integer> LR(NoArv<Integer> no) {
		NoArv<Integer> novoNo = no.getEsquerda().getDireita().getEsquerda();
		
		no.getEsquerda().getDireita().setEsquerda(no.getEsquerda());
		no.getEsquerda().getDireita().setPai(no);
		no.setEsquerda(no.getEsquerda().getDireita());
		no.getEsquerda().getEsquerda().setPai(no.getEsquerda());
		no.getEsquerda().getEsquerda().setDireita(null);
		
		no.getEsquerda().getEsquerda().setDireita(novoNo);
		if(novoNo != null)
			novoNo.setPai(no.getEsquerda().getEsquerda());
		
		return LL(no);
	}
	
	public NoArv<Integer> RL(NoArv<Integer> no) {
		NoArv<Integer> novoNo = no.getDireita().getEsquerda().getDireita();
		
		no.getDireita().getEsquerda().setDireita(no.getDireita());
		no.getDireita().getEsquerda().setPai(no);
		no.setDireita(no.getDireita().getEsquerda());
		no.getDireita().getDireita().setPai(no.getDireita());
		no.getDireita().getDireita().setEsquerda(null);
		
		no.getDireita().getDireita().setEsquerda(novoNo);
		if(novoNo != null)
			novoNo.setPai(no.getDireita().getDireita());
		
		return RR(no);
	}
	
	
	
	
	
	// Outras Funcoes (EXTRA)
	public void estruturado(NoArv<Integer> no, int k) {
		if(no != null) {
			if(profundidade(no) == k) {
				for(int l = 0; l < Math.pow(2,altura(no))-1; l++)
					System.out.print("  ");
				
				if(no.getElemento()<10) System.out.print('0');
				System.out.print(no.getElemento() + "/" + no.getFator());
				
				
			} else {
				estruturado(no.getEsquerda(), k);
				for(int l = 0; l < Math.pow(2,altura(no))-1; l++)
					System.out.print("  ");
				estruturado(no.getDireita(), k);
			}
		}
	}
	
	public void mostrarEstruturado() {
		for(int k = 0; k <= altura(raiz); k++) {
			estruturado(raiz,k);
			System.out.println();
		}
	}
	
	public int qtdNos(NoArv<Integer> no) {
		if(no != null) {
			return 1 + qtdNos(no.getEsquerda()) + qtdNos(no.getDireita());
		}
		return 0;
	}
	
	public int totalValoresNos(NoArv<Integer> no) {
		if(no != null) {
			return no.getElemento() + totalValoresNos(no.getEsquerda()) + totalValoresNos(no.getDireita());
		}
		return 0;
	}
	
}
