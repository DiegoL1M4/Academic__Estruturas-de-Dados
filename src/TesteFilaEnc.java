
import ClassesEncadeadas.FilaEncadeada;
import ClassesEncadeadas.PilhaEncadeada;

public class TesteFilaEnc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FilaEncadeada<Integer> fila = new FilaEncadeada<Integer>();
		
		fila.insere(13);
		fila.insere(15);
		fila.insere(15);
		
		fila.mostrarFila();
		
		
		PilhaEncadeada<Integer> pilha = new PilhaEncadeada<Integer>();
		
		pilha.mostrarPilha();
		
		pilha.insere(1);
		pilha.insere(2);
		pilha.insere(3);
		pilha.insere(4);
		
		pilha.mostrarPilha();
		
		pilha.remove();
		pilha.mostrarPilha();
		
		pilha.remove();
		pilha.mostrarPilha();
		
		pilha.remove();
		pilha.mostrarPilha();
		
		pilha.remove();
		pilha.mostrarPilha();
		
	}

}
