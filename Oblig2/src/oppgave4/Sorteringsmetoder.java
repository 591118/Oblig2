package oppgave4;

public class Sorteringsmetoder<T> {

	/**
	 * Utvalgssortering
	 * 
	 * @param data er data som skal sorteres
	 */
	public static <T extends Comparable<T>> void utvalgsSortering(T[] data) {
		int minstePos;
		for (int i = 0; i < data.length - 1; i++) {
			minstePos = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j].compareTo(data[minstePos]) < 0) {
					minstePos = j;
				}
			}

			// byte om
			T tmp = data[i];
			data[i] = data[minstePos];
			data[minstePos] = tmp;
		}
	}

	public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {
		for (int i = 1; i < data.length; i++) {
			T nokkel = data[i];
			int p = i;

			while (p > 0 && nokkel.compareTo(data[p - 1]) < 0) {
				data[p] = data[p - 1];
				p--;
			}

			data[p] = nokkel;
		}
	}

	public static <T extends Comparable<T>> void bobleSortering(T[] data) {
		for (int siste = data.length - 1; siste > 0; siste--) {
			for (int i = 0; i < siste; i++) {
				if (data[i].compareTo(data[i + 1]) > 0) {
					T tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				}
			}
		}

	}

	private static <T> void swap(T[] tab, int i, int j) {
		T tmp = tab[i];
		tab[i] = tab[j];
		tab[j] = tmp;
	}

	private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		T temp, pivot;
		int midten = (min + maks) / 2;
		pivot = data[midten];
		swap(data, midten, min); // bytter om første og midtelementet

		int venstre = min + 1;
		int hoyre = maks;
		while (venstre < hoyre) {// ytre løkke

			/** Søker et element som er > enn pivot */
			/** Sikrer at partisjoneringsprosessen vil fortsette så lenge venstre < hoyre */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}

			/** Søker et element som er <= enn pivot */
			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			/** bytter elementene desom venstre er mindre enn hoyre */
			if (venstre < hoyre) {
				swap(data, venstre, hoyre);
			}

		} // while – ytre løkke

		/** flytter pivot til riktig og sin endelige plass */

		swap(data, min, hoyre);

		return hoyre;

	}// metode

	public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {

		// basis: 0 eller 1 element -> gjer ingenting

		if (min < maks) { // minst to element
			int posPivot = finnPartisjon(data, min, maks);
			// sorter venstre del
			kvikkSort(data, min, posPivot - 1);
			// sorter høgre del
			kvikkSort(data, posPivot + 1, maks);
		}
	}

	private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {
		/*
		 * Fletter to sorterte deltabeller, tabell[forste,midten] og
		 * tabell[midten+1,siste] til en sortert tabell Forkrav: forste <= midten <=
		 * siste Deltabellene tabell[forste … midten] og tabell[midten+1 … siste] er
		 * hver sorterte i ikke- avtagende rekkefølge.
		 * 
		 * ResultatTabell[forste … siste] er sortert.
		 * 
		 * Implementasjon : Denne metoden fletter to deltabeller til en hjelpetabell og
		 * kopierer resultatet til den originale tabellen.
		 */

		int storrelse = siste - forste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[storrelse]);

		int forsteV = forste;
		int sisteV = midten;
		int forsteH = midten + 1;
		int sisteH = siste;

		// indeks i hjelp
		int h = 0;

		while (forsteV <= sisteV && forsteH <= sisteH) {
			if (tabell[forsteV].compareTo(tabell[forsteH]) <= 0) {
				hjelpeTabell[h] = tabell[forsteV];
				forsteV++;
			} else {
				hjelpeTabell[h] = tabell[forsteH];
				forsteH++;
			}
			h++;
		}

		// kopiere resten av venstre del (kan være tom)
		while (forsteV <= sisteV) {
			hjelpeTabell[h] = tabell[forsteV];
			forsteV++;
			h++;
		} // while

		// kopiere resten av høyre del (kan være tom)
		while (forsteH <= sisteH) {
			hjelpeTabell[h] = tabell[forsteH];
			forsteH++;
			h++;
		} // while

		// Kopier resultatet tilbake til den originale tabellen
		h = 0;
		for (int indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}
	}// flette */

	public static <T extends Comparable<T>> void flettSort(T[] tabell, int forste, int siste) {
		// basis: 1 element - > gjer ingenting
		if (forste < siste) { // minst to element
			int midten = (forste + siste) / 2;
			flettSort(tabell, forste, midten);
			flettSort(tabell, midten + 1, siste);
			flette(tabell, forste, midten, siste);
		}
	}

	public static void main(String[] args) {

		Integer[] tab = { 4, 6, 2, 1, 5, 8, 9, 6 };

//		sorteringVedInnsettning(tab);
//		for(int i = 0; i < tab.length; i++) 
//		System.out.print(tab[i] + " ");

		System.out.println();

//		boble(tab);
//		for(int i = 0; i < tab.length; i++) 	
//		System.out.print(tab[i] + " ");

//		System.out.println();

//		utvalgsSortering(tab);
//		for(int i = 0; i < tab.length; i++)	
//		System.out.print(tab[i] + " ");

		System.out.println();

		// kvikkSort(tab, tab[0], tab.length-1);
		// for(int i = 0; i < tab.length; i++)
		// System.out.print(tab[i] + " ");

		System.out.println();

		flette(tab, tab[0], tab[tab.length / 2], tab[tab.length - 1]);
		for (int i = 0; i < tab.length; i++)
			System.out.print(tab[i] + " ");
	}

}
