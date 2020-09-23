import Arvores.*;
import Auxiliar.NoArv;

public class Arvore {

	public static void main(String[] args) {

		ArvoreBin<Integer> arvore = new ArvoreBin<Integer>();
		
		arvore.inserirRaiz(33);
		
		arvore.inserirEsq(15, arvore.getRaiz());
		NoArv<Integer> raizDir = arvore.inserirDir(41, arvore.getRaiz());
		
		NoArv<Integer> raizDirEsq = arvore.inserirEsq(38, raizDir);
		NoArv<Integer> raizDirDir = arvore.inserirDir(47, raizDir);
		
		arvore.inserirEsq(34, raizDirEsq);
		
		arvore.inserirEsq(43, raizDirDir);
		arvore.inserirDir(49, raizDirDir);
		
//		arvore.prefixado(arvore.getRaiz());
		arvore.posfixado(arvore.getRaiz());
//		arvore.interfixado(arvore.getRaiz());
		
		/*
		// RR
		arvore.inserir2(arvore.raiz, 10);
		arvore.inserir2(arvore.raiz, 20);
		arvore.inserir2(arvore.raiz, 30);
		
		// LL
		arvore.inserir2(arvore.raiz, 30);
		arvore.inserir2(arvore.raiz, 20);
		arvore.inserir2(arvore.raiz, 10);
		
		// RL
		arvore.inserir2(arvore.raiz, 20);
		arvore.inserir2(arvore.raiz, 30);
		arvore.inserir2(arvore.raiz, 25);
		*/
		// LR
//		arvore.inserir2(arvore.raiz, 30);
//		arvore.inserir2(arvore.raiz, 20);
//		arvore.inserir2(arvore.raiz, 25);
		
		/*
		arvore.inserir2(arvore.raiz, 14);
		arvore.inserir2(arvore.raiz, 5);
		arvore.inserir2(arvore.raiz, 28);
		arvore.inserir2(arvore.raiz, 2);
		arvore.inserir2(arvore.raiz, 8);
		arvore.inserir2(arvore.raiz, 1);
		arvore.inserir2(arvore.raiz, 3);
		arvore.inserir2(arvore.raiz, 4);
		arvore.inserir2(arvore.raiz, 6);
		arvore.inserir2(arvore.raiz, 7);
		arvore.inserir2(arvore.raiz, 11);
		arvore.inserir2(arvore.raiz, 10);
		arvore.inserir2(arvore.raiz, 12);
		arvore.inserir2(arvore.raiz, 13);
		arvore.inserir2(arvore.raiz, 18);
		arvore.inserir2(arvore.raiz, 33);
		arvore.inserir2(arvore.raiz, 15);
		arvore.inserir2(arvore.raiz, 20);
		arvore.inserir2(arvore.raiz, 16);
		arvore.inserir2(arvore.raiz, 19);
		arvore.inserir2(arvore.raiz, 21);
		arvore.inserir2(arvore.raiz, 22);
		arvore.inserir2(arvore.raiz, 30);
		arvore.inserir2(arvore.raiz, 40);
		arvore.inserir2(arvore.raiz, 29);
		arvore.inserir2(arvore.raiz, 31);
		arvore.inserir2(arvore.raiz, 32);
		arvore.inserir2(arvore.raiz, 36);
		arvore.inserir2(arvore.raiz, 42);
		arvore.inserir2(arvore.raiz, 34);
		arvore.inserir2(arvore.raiz, 37);
		arvore.inserir2(arvore.raiz, 38);
		arvore.inserir2(arvore.raiz, 43);
		*/

		
//		System.out.println("\nBefore:");
//		arvore.mostrarInterfixado();
//		System.out.println();
//
//		
//		arvore.fatoresArvore(arvore.raiz);
//		arvore.mostrarEstruturado();
//		System.out.println();

		/*
		arvore.mostrarInterfixado();
		System.out.println();
		
		System.out.println("Altura: " + arvore.altura(no));
		System.out.println("Menor: " + arvore.menorValor(no).getElemento());
		
		arvore.remover(no);
		
		arvore.mostrarPrefixado();
		System.out.println();
		*/
		
		
	}

}
