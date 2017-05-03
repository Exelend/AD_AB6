package Sort;

import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse sortiert ein Array von T-Elementen.
 * 
 * @author Hauke Goldhammer, 2286057
 *
 */
public class QuickSort<T> {

	public enum PivotElementSuche {
		VORNE, MITTE, HINTEN, ZUFAELLIG, MEDIAN
	}

	public long counter = 0;

	public void quicksortStart(List<Datensatz<T>> liste, int links, int rechts, PivotElementSuche pivotSuche) {
		int index = partition(liste, links, rechts, pivotSuche);
		if (links < index - 1) {
			quicksortStart(liste, links, index - 1, pivotSuche);
		}
		if (index < rechts) {
			quicksortStart(liste, index, rechts, pivotSuche);
		}
	}

	private int partition(List<Datensatz<T>> liste, int links, int rechts, PivotElementSuche pivotSuche) {
		int pivot = 0;
		int i, j;

		switch (pivotSuche) {
		case VORNE:
			pivot = liste.get(links).getKey();
			break;
		case MITTE:
			pivot = liste.get((links + rechts) / 2).getKey();
			break;
		case HINTEN:
			pivot = liste.get(rechts - 1).getKey();
			break;
		case ZUFAELLIG:
			pivot = liste.get(pivotZufaellig(rechts)).getKey();
			break;
		case MEDIAN:
			pivot = pivotMedian(liste, links, rechts);
			break;
		}
		counter++;

		i = links;
		j = rechts;

		while (i <= j) {
			while (liste.get(i).getKey() < pivot) {
				i++;
				counter++;
			}

			while (liste.get(j).getKey() > pivot) {
				j--;
				counter++;
			}

			if (i <= j) {
				swap(liste, i, j);
				i++;
				j--;
			}
			counter++;
		}
		return i;
	}

	private int pivotZufaellig(int rechts) {
		return (int) (Math.random() * (rechts));

	}

	private int pivotMedian(List<Datensatz<T>> liste, int links, int rechts) {
		List<Datensatz<String>> keyListe = new LinkedList<Datensatz<String>>();
		keyListe.add(new Datensatz<String>(liste.get(links).getKey(), null));
		keyListe.add(new Datensatz<String>(liste.get((links + rechts) / 2).getKey(), null));
		keyListe.add(new Datensatz<String>(liste.get(rechts).getKey(), null));
		new QuickSort<String>().quicksortStart(keyListe, 0, 2, PivotElementSuche.VORNE);
		return keyListe.get(1).getKey();
	}

	private List<Datensatz<T>> swap(List<Datensatz<T>> liste, int i, int j) {
		counter++;
		Datensatz<T> help;
		help = liste.get(i);
		liste.set(i, liste.get(j));
		liste.set(j, help);
		return liste;
	}
}