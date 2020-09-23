import java.util.Scanner;

import ClassesEncadeadas.FilaEncadeada;
import ClassesEncadeadas.PilhaEncadeada;

public class ImparesPares {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		PilhaEncadeada<Integer> pilha = new PilhaEncadeada<Integer>();
		PilhaEncadeada<Integer> pilhaAux = new PilhaEncadeada<Integer>();
		FilaEncadeada<Integer> filaImpar = new FilaEncadeada<Integer>();
		FilaEncadeada<Integer> filaPar = new FilaEncadeada<Integer>();
		
		System.out.println("Insira os numeros:");
		
		while(true) {
			int elemento = in.nextInt();
			if(elemento < 0)
				break;
			
			pilha.insere(elemento);
		}
		
		int tamanho = pilha.getTamanho();
		
		for(int k = 0; k < tamanho; k++) {
			Integer valor = pilha.remove();
			if(valor%2 == 0)
				filaPar.insere(valor);
			else
				filaImpar.insere(valor);
			pilhaAux.insere(valor);
		}
		
		for(int k = 0; k < tamanho; k++) {
			Integer valor = pilhaAux.remove();
			pilha.insere(valor);
		}
		
		System.out.println("Pilha:");
		pilha.mostrarPilha();
		System.out.println("Impares:");
		filaImpar.mostrarFila();
		System.out.println("Pares:");
		filaPar.mostrarFila();
		
		in.close();

	}

}
