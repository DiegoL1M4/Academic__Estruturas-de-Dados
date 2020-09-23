import ClassesEncadeadas.*;
import Auxiliar.NoDuplo;

public class Inverter {

	public static void main(String[] args) {

		ListaDuplEnc<Integer> lista = new ListaDuplEnc<Integer>();
		
		lista.insereFim(new NoDuplo<Integer>(1, null, null));
		lista.insereFim(new NoDuplo<Integer>(2, null, null));
		lista.insereFim(new NoDuplo<Integer>(3, null, null));
		lista.insereFim(new NoDuplo<Integer>(4, null, null));
		lista.insereFim(new NoDuplo<Integer>(5, null, null));
		lista.mostrarLista();
		
		inverter(lista);
		
		lista.mostrarLista();

	}
	
	public static void inverter(ListaDuplEnc<Integer> lista) {
		PilhaEncadeada<Integer> pilha = new PilhaEncadeada<Integer>();
		
		for(int k = 0; k < lista.getTamanho(); k++)
			pilha.insere(lista.getElemento(k));
		
		for(int k = 0; k < lista.getTamanho(); k++)
			lista.setElemento(pilha.remove(), k);
	}

}
