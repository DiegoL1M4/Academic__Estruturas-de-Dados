import ClassesEncadeadas.BuscaLink;

public class Sites {

	public static void main(String[] args) {
		
		BuscaLink sites = new BuscaLink();
		
		sites.inserirInicio("Google", "google.com");
		sites.inserirFim("Yahoo", "yahoo.com");
		sites.inserirFim("Globo", "g1.com");
		sites.inserirFim("Hardware", "hard.com");
		sites.mostrarLista();
		
		sites.busca("Globo");
		sites.mostrarLista();
		
		sites.busca("Yahoo");
		sites.mostrarLista();
		
		sites.busca("Yahoo");
		sites.mostrarLista();
		
		sites.busca("Hardware");
		sites.mostrarLista();

	}

}
