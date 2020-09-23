package Classes;

import Interfaces.Pilha;

public class PilhaImp implements Pilha {
	
	public Integer[] pilha; //todos iniciam com null
	
	public int tamanho = 5;
	public int posicao = 0;
	
	public PilhaImp(int tamanho) {
		this.tamanho = tamanho;
		pilha = new Integer[tamanho];
	}
	

	@Override
	public void inserirElemento(Integer num) {
		// TODO Auto-generated method stub
		if(!estruturaCheia())
			pilha[posicao++] = num;
	}

	@Override
	public Integer removerElemento() {
		// TODO Auto-generated method stub
		if(posicao != 0) {
			Integer valor = pilha[--posicao];
			pilha[posicao] = null;
			return valor;
		}
		return null;
	}

	@Override
	public boolean estruturaCheia() {
		// TODO Auto-generated method stub
		if(posicao == tamanho)
			return true;
		return false;
	}

	@Override
	public void mostrarEstrutura() {
		// TODO Auto-generated method stub
		if(posicao == 0)
			System.out.println("Pilha Vazia");
		else
			for(int k = 0; k < tamanho; k++)
				if(pilha[k] != null)
					System.out.print(pilha[k] + " ");
	}

}
