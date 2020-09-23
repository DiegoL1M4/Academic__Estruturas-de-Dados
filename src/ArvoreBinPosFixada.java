
public class ArvoreBinPosFixada {

	public static void main(String[] args) {

		ArvoreBinPos<Integer> arvore = new ArvoreBinPos<Integer>();
		
		arvore.inserirRaiz(33);
		
		arvore.inserirEsq(15, arvore.raiz);
		NoArv<Integer> raizDir = arvore.inserirDir(41, arvore.raiz);
		
		NoArv<Integer> raizDirEsq = arvore.inserirEsq(38, raizDir);
		NoArv<Integer> raizDirDir = arvore.inserirDir(47, raizDir);
		
		arvore.inserirEsq(34, raizDirEsq);
		
		arvore.inserirEsq(43, raizDirDir);
		arvore.inserirDir(49, raizDirDir);
		
		arvore.posfixado(arvore.raiz);

	}

}

class NoArv<tipo> {
	
	NoArv<tipo> pai;
	NoArv<tipo> esquerda;
	NoArv<tipo> direita;
	tipo elemento;
	
	public NoArv(NoArv<tipo> pai, NoArv<tipo> esquerda, NoArv<tipo> direita, tipo elemento) {
		this.pai = pai;
		this.direita = direita;
		this.esquerda = esquerda;
		this.elemento = elemento;
	}

	public NoArv<tipo> getPai() { return pai; }
	public void setPai(NoArv<tipo> pai) { this.pai = pai; }
	public NoArv<tipo> getEsquerda() { return esquerda; }
	public void setEsquerda(NoArv<tipo> esquerda) { this.esquerda = esquerda; }
	public NoArv<tipo> getDireita() { return direita; }
	public void setDireita(NoArv<tipo> direita) { this.direita = direita; }
	public tipo getElemento() { return elemento; }
	public void setElemento(tipo elemento) { this.elemento = elemento; }
	
}

class ArvoreBinPos<tipo> {
	NoArv<tipo> raiz = new NoArv<tipo>(null, null, null, null);
	int tamanho;
	
	public void inserirRaiz(tipo elemento) {
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

	public void posfixado(NoArv<tipo> no) {
		if(no != null) {
			posfixado(no.getEsquerda());
			posfixado(no.getDireita());
			System.out.println(no.getElemento());
		}
	}
	
}

