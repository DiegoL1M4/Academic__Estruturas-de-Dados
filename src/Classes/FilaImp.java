package Classes;

import Interfaces.Fila;

public class FilaImp implements Fila {
	
	public Integer[] fila; //todos iniciam com null
	
	public int tamanho = 5;
	public int posicao = 0;
	
	public FilaImp(int tamanho) {
		this.tamanho = tamanho;
		fila = new Integer[tamanho];
	}
	

	@Override
	public void inserirElemento(Integer num) {
		// TODO Auto-generated method stub
		if(!estruturaCheia())
			fila[posicao++] = num;
	}

	@Override
	public Integer removerElemento() {
		// TODO Auto-generated method stub
		if(posicao != 0) {
			int valor = fila[0];
			
			for(int k = 0; k < tamanho - 1; k++)
				fila[k] = fila[k+1];
			
			posicao--;
			fila[posicao] = null;
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
			System.out.println("Fila Vazia");
		else
			for(int k = 0; k < tamanho; k++)
				if(fila[k] != null)
					System.out.print(fila[k] + " ");
		System.out.print("\n");
	}
	
}
