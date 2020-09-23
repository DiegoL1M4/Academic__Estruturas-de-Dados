
import Classes.ListaImp;

public class MainLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaImp numeros = new ListaImp(5);
		
		/*
		numeros.insereInicio(10);
		numeros.mostrarLista();
		numeros.insereInicio(11);
		numeros.mostrarLista();
		numeros.insereInicio(12);
		numeros.mostrarLista();
		numeros.insereInicio(13);
		numeros.mostrarLista();
		numeros.insereInicio(14);
		numeros.mostrarLista();
		numeros.insereInicio(15);
		numeros.mostrarLista();
		*/
		
		numeros.insereFim(31);
		numeros.mostrarLista();
		numeros.insereFim(30);
		numeros.mostrarLista();
		numeros.insereFim(2);
		numeros.mostrarLista();
		numeros.insereFim(50);
		numeros.mostrarLista();
		
		System.out.println(numeros.antepenultimo());
		
		numeros.insereOrdenado(40);
		numeros.mostrarLista();
		
		numeros.esvaziarLista();
		numeros.mostrarLista();
		
		/*
		numeros.insereOrdenado(59);
		numeros.mostrarLista();
		
		numeros.ordenarListaCresc();
		
		numeros.insereOrdenado(59);
		numeros.mostrarLista();
		
		numeros.inserePosicao(19,0);
		numeros.mostrarLista();
		
		System.out.println(numeros.index(15));
		
		numeros.removeInicio();
		numeros.mostrarLista();
		numeros.removeInicio();
		numeros.mostrarLista();
		numeros.removeInicio();
		numeros.mostrarLista();
		numeros.removeInicio();
		numeros.mostrarLista();
		numeros.removeInicio();
		numeros.mostrarLista();
		numeros.removePosicao(4);
		numeros.mostrarLista();
		
		numeros.removeFim();
		numeros.mostrarLista();
		numeros.removeFim();
		numeros.mostrarLista();
		numeros.removeFim();
		numeros.mostrarLista();
		numeros.removeFim();
		numeros.mostrarLista();
		numeros.removeFim();
		numeros.mostrarLista();
		numeros.removeFim();
		numeros.mostrarLista();
		*/
	}

}
