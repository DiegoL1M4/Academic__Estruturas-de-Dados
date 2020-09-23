package Arvores;

import Auxiliar.NoArv;

public class ArvoreRN {

	public NoArv<Integer> raiz = new NoArv<Integer>(null, null, null, null, 'N');
	
	public NoArv<Integer> inserir2(NoArv<Integer> noBase, Integer elemento) {
		if(raiz.getElemento() == null) {
			raiz.setElemento(elemento);
			return raiz;
		}
		
		NoArv<Integer> novoNo = null;
		
		if(elemento < noBase.getElemento()) {
			if(noBase.getEsquerda() == null) {
				novoNo = new NoArv<Integer>(noBase, null, null, elemento, 'R');
				noBase.setEsquerda(novoNo);
			} else {
				novoNo = inserir2(noBase.getEsquerda(), elemento);
			}
		} else if(noBase.getElemento() < elemento) {
			if(noBase.getDireita() == null) {
				novoNo = new NoArv<Integer>(noBase, null, null, elemento, 'R');
				noBase.setDireita(novoNo);
			} else {
				novoNo = inserir2(noBase.getDireita(), elemento);
			}
			
		}
		
		
		return novoNo;
			
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
	
	
	// Manipulacao de nos
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
	
	
	// Mostra Arvore
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
				System.out.print(no.getElemento() + "-" + no.getCor());
				
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
	
	public void fatoresArvore(NoArv<Integer> no) {
		if(no != null) {
			fatoresArvore(no.getEsquerda());
			fatoresArvore(no.getDireita());
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
			if(fator(no.getDireita()) > 0)
				novoNo = RR(no);
			else
				novoNo = RL(no);
		} else if(fator == -2) {
			if(fator(no.getEsquerda()) < 0)
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
	
	
	// Rubro Negra
	public void verificacaoRubroEsq(NoArv<Integer> no) {
		if(no != null) {
			
			verificacaoRubroEsq(no.getEsquerda());
			verificacaoRubroEsq(no.getDireita());
		}
	}
	
	public void aplicarNegro(NoArv<Integer> no) {
		if(no != null) {
			if(isExternal(no))
				no.setCor('N');
				
			aplicarNegro(no.getEsquerda());
			aplicarNegro(no.getDireita());
		}
	}
	
	public void filhosNegros(NoArv<Integer> no) {
		if(no != null) {
			if(isExternal(no))
				no.setCor('N');
				
			filhosNegros(no.getEsquerda());
			filhosNegros(no.getDireita());
		}
	}
}
