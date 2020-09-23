package Auxiliar;

public class No<tipo> {
	
	private tipo elemento;
	private No<tipo> proximo;
	
	public No(tipo elemento, No<tipo> proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public tipo getElemento() {
		return elemento;
	}
	public void setElemento(tipo elemento) {
		this.elemento = elemento;
	}
	public No<tipo> getProximo() {
		return proximo;
	}
	public void setProximo(No<tipo> proximo) {
		this.proximo = proximo;
	}
	
	
}
