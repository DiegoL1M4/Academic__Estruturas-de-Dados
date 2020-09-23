package Auxiliar;

public class NoDuplo<tipo> {
	
	private tipo elemento;
	private NoDuplo<tipo> anterior;
	private NoDuplo<tipo> proximo;
	
	public NoDuplo(tipo elemento, NoDuplo<tipo> anterior, NoDuplo<tipo> proximo) {
		this.elemento = elemento;
		this.anterior = anterior;
		this.proximo = proximo;
	}

	public tipo getElemento() {
		return elemento;
	}

	public void setElemento(tipo elemento) {
		this.elemento = elemento;
	}

	public NoDuplo<tipo> getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDuplo<tipo> anterior) {
		this.anterior = anterior;
	}

	public NoDuplo<tipo> getProximo() {
		return proximo;
	}

	public void setProximo(NoDuplo<tipo> proximo) {
		this.proximo = proximo;
	}
	
	
}
