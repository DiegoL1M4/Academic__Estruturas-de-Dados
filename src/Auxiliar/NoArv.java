package Auxiliar;

public class NoArv<tipo> {
	
	NoArv<tipo> pai;
	NoArv<tipo> esquerda;
	NoArv<tipo> direita;
	
	tipo elemento;
	
	char cor = 's';
	Integer fator = null;
	
	// Arvore Binaria
	public NoArv(NoArv<tipo> pai, NoArv<tipo> esquerda, NoArv<tipo> direita, tipo elemento) {
		this.pai = pai;
		this.direita = direita;
		this.esquerda = esquerda;
		
		this.elemento = elemento;
	}
	
	// Arvore RB
	public NoArv(NoArv<tipo> pai, NoArv<tipo> esquerda, NoArv<tipo> direita, tipo elemento, char cor) {
		this.pai = pai;
		this.direita = direita;
		this.esquerda = esquerda;
		
		this.elemento = elemento;
		
		this.cor = cor;
	}

	public NoArv<tipo> getPai() {
		return pai;
	}

	public void setPai(NoArv<tipo> pai) {
		this.pai = pai;
	}

	public NoArv<tipo> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArv<tipo> esquerda) {
		this.esquerda = esquerda;
	}

	public NoArv<tipo> getDireita() {
		return direita;
	}

	public void setDireita(NoArv<tipo> direita) {
		this.direita = direita;
	}

	public tipo getElemento() {
		return elemento;
	}

	public void setElemento(tipo elemento) {
		this.elemento = elemento;
	}


	public char getCor() {
		return cor;
	}

	public void setCor(char cor) {
		this.cor = cor;
	}
	
	public Integer getFator() {
		return fator;
	}
	
	public void setFator(Integer fator) {
		this.fator = fator;
	}
	
}
