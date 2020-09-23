import Auxiliar.NoDuplo;
import ClassesEncadeadas.ListaDuplEnc;

public class Igualdade {

	public static void main(String[] args) {

		ListaDuplEnc<Integer> lista1 = new ListaDuplEnc<Integer>();
		lista1.insereFim(new NoDuplo<Integer>(1, null, null));
		lista1.insereFim(new NoDuplo<Integer>(2, null, null));
		lista1.insereFim(new NoDuplo<Integer>(3, null, null));
		ListaDuplEnc<Integer> lista2 = new ListaDuplEnc<Integer>();
		lista2.insereFim(new NoDuplo<Integer>(1, null, null));
		lista2.insereFim(new NoDuplo<Integer>(2, null, null));
		lista2.insereFim(new NoDuplo<Integer>(3, null, null));
		
		System.out.println(iguais(lista1, lista2));
		
		lista2.insereFim(new NoDuplo<Integer>(3, null, null));
		
		System.out.println(iguais(lista1, lista2));

	}
	
	public static boolean iguais(ListaDuplEnc<Integer> lista1, ListaDuplEnc<Integer> lista2) {
		int igualdades = 0;
		if(lista1.getTamanho() == lista2.getTamanho())
			for(int k = 0; k < lista1.getTamanho(); k++)
				if(lista1.getElemento(k) == lista2.getElemento(k))
					igualdades++;
				
		if(igualdades == lista1.getTamanho())
			return true;
		
		return false;
	}

}
