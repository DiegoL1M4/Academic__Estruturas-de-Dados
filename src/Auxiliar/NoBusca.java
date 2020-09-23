package Auxiliar;

public class NoBusca {
	
	private String nome;
	private String link;
	private NoBusca proximo;
	
	public NoBusca(String nome, String link, NoBusca proximo) {
		this.nome = nome;
		this.link = link;
		this.proximo = proximo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public NoBusca getProximo() {
		return proximo;
	}

	public void setProximo(NoBusca proximo) {
		this.proximo = proximo;
	}
	
	public String toString() {
		return "Nome:" + this.nome + " - Link:" + this.link;
	}
	
	
}
