
import Classes.*;

public class MainPilha {

	public static void main(String[] args) {
		
		polindromo();
	}
	
	static void inverter() {
		PilhaImp pilha = new PilhaImp(5);
		int lista[] = {1,2,3,4};
		
		for(int k = 0; k < lista.length; k++)
			pilha.inserirElemento(lista[k]);
		
		pilha.mostrarEstrutura();
		
		for(int k = 0; k < lista.length; k++)
			lista[k] = pilha.removerElemento().intValue();
		
		System.out.println();
		for(int k = 0; k < lista.length; k++)
			System.out.print(lista[k] + " ");
	}
	
	
	static void polindromo() {
		PilhaImp pilha1 = new PilhaImp(5);
		PilhaImp pilha2 = new PilhaImp(5);
		
		int cont = 0;
		int lista[] = {1,2,3,6,1};
		
		int ciclos = lista.length / 2;
		
		for(int k = 0; k < ciclos; k++) {
			pilha1.inserirElemento(lista[k]);
			pilha2.inserirElemento(lista[lista.length - 1 - k]);
		}
		
		for(int k = 0; k < ciclos; k++) {
			if(pilha1.removerElemento() == pilha2.removerElemento())
				cont++;
		}
		
		if(cont == ciclos)
			System.out.print("Deu bom!");
		else
			System.out.print("Deu ruim!");
		
	}
	
}
