import Auxiliar.NoDuplo;
import ClassesEncadeadas.ListaDuplEnc;

public class TesteListDupl {

	public static void main(String[] args) {
		
		ListaDuplEnc<Integer> lista = new ListaDuplEnc<Integer>();
		
		System.out.println("Testes de Adicao:");
		lista.insereInicio(new NoDuplo<Integer>(15, null, null));
		lista.mostrarLista();
		
		lista.insereFim(new NoDuplo<Integer>(17, null, null));
		lista.mostrarLista();
		
		lista.inserePosicao(new NoDuplo<Integer>(50, null, null), 2);
		lista.mostrarLista();
		
		lista.insereFim(new NoDuplo<Integer>(19, null, null));
		lista.mostrarLista();
		
		System.out.println("Index: " + lista.index(50));
		
		System.out.println("\nTestes de Chamada de Elementos:");
		lista.mostrarLista();
		System.out.println(lista.first());
		System.out.println(lista.last());
		System.out.println(lista.anterior(2));
		System.out.println(lista.posterior(2));	

		
		System.out.println("\nTestes de Remocao:");
		System.out.println(lista.removeElemento(17));
		lista.mostrarLista();
		
		System.out.println(lista.removePosicao(0));
		lista.mostrarLista();
		
		System.out.println(lista.removeFim());
		lista.mostrarLista();
		
		System.out.println(lista.removeInicio());
		lista.mostrarLista();
		
		

	}

}
