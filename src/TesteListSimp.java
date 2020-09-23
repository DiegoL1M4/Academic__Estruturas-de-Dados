import ClassesEncadeadas.ListaSimpEnc;

public class TesteListSimp {

	public static void main(String[] args) {
		
		ListaSimpEnc<Integer> lista = new ListaSimpEnc<Integer>();
		
		System.out.println("Testes de Adição:");
		lista.inserirInicio(15);
		lista.mostrarLista();
		
		System.out.println(lista.removerInicio());
		lista.mostrarLista();
		
		lista.inserirFim(1);
		lista.mostrarLista();
		
		lista.inserirFim(2);
		lista.mostrarLista();
		
		lista.inserirPosicao(17, 3);
		lista.mostrarLista();
		
		lista.inserirPosicao(13, 1);
		lista.mostrarLista();
		
		lista.inserirPosicao(47, 0);
		lista.mostrarLista();
		
		lista.addAntes(4, 2);
		lista.mostrarLista();
		
		lista.addApos(72, 3);
		lista.mostrarLista();
		
		lista.inserirPosicao(50, 6);
		lista.mostrarLista();
		
		System.out.println("\nAqui");
		lista.primeiroUltimoCriando();
		lista.mostrarLista();
		
		lista.inverterCriando();
		lista.mostrarLista();
		
		lista.ordenarLista();
		lista.mostrarLista();
		
		System.out.println("\nTestes de Chamada de Elementos:");
		
		lista.mostrarLista();
		System.out.println(lista.first());
		System.out.println(lista.last());
		System.out.println(lista.anterior(4));
		System.out.println(lista.posterior(4));	
		
		System.out.println("\nTestes de Remoção:");
		
		System.out.println(lista.removeElemento(13));
		lista.mostrarLista();
		
		System.out.println(lista.removerPosicao(0));
		lista.mostrarLista();
		
		System.out.println(lista.removerPosicao(2));
		lista.mostrarLista();
		
		System.out.println(lista.removerFim());
		lista.mostrarLista();
		
		System.out.println(lista.removerInicio());
		lista.mostrarLista();
		
		
	}

}
