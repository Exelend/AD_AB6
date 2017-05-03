package Sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import Sort.QuickSort.PivotElementSuche;

public class TestQuickSort {

	int N = 2500;

	@Test
	public void testVORNE() {
		List<Datensatz<String>> testListe = new ArrayList<>();
		List<Datensatz<String>> testListe2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			testListe.add(new Datensatz<String>(i, "Test"));
			testListe2.add(new Datensatz<String>(i, "Test"));
		}
		Collections.shuffle(testListe);
		QuickSort<String> qSort = new QuickSort<String>();
		qSort.quicksortStart(testListe, 0, N - 1, PivotElementSuche.VORNE);
		for (int i = 0; i < N; i++) {
			assertEquals(String.format("Liste falsch sortiert an Stelle %d", i), testListe2.get(i).getKey(),
					testListe.get(i).getKey());
		}
	}

	@Test
	public void testMITTE() {
		List<Datensatz<String>> testListe = new ArrayList<>();
		List<Datensatz<String>> testListe2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			testListe.add(new Datensatz<String>(i, "Test"));
			testListe2.add(new Datensatz<String>(i, "Test"));
		}
		Collections.shuffle(testListe);
		QuickSort<String> qSort = new QuickSort<String>();
		qSort.quicksortStart(testListe, 0, N - 1, PivotElementSuche.MITTE);
		for (int i = 0; i < N; i++) {
			assertEquals(String.format("Liste falsch sortiert an Stelle %d", i), testListe2.get(i).getKey(),
					testListe.get(i).getKey());
		}
	}

	@Test
	public void testHINTEN() {
		List<Datensatz<String>> testListe = new ArrayList<>();
		List<Datensatz<String>> testListe2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			testListe.add(new Datensatz<String>(i, "Test"));
			testListe2.add(new Datensatz<String>(i, "Test"));
		}
		Collections.shuffle(testListe);
		QuickSort<String> qSort = new QuickSort<String>();
		qSort.quicksortStart(testListe, 0, N - 1, PivotElementSuche.HINTEN);
		for (int i = 0; i < N; i++) {
			assertEquals(String.format("Liste falsch sortiert an Stelle %d", i), testListe2.get(i).getKey(),
					testListe.get(i).getKey());
		}
	}

	@Test
	public void testMEDIAN() {
		List<Datensatz<String>> testListe = new ArrayList<>();
		List<Datensatz<String>> testListe2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			testListe.add(new Datensatz<String>(i, "Test"));
			testListe2.add(new Datensatz<String>(i, "Test"));
		}
		Collections.shuffle(testListe);
		QuickSort<String> qSort = new QuickSort<String>();
		qSort.quicksortStart(testListe, 0, N - 1, PivotElementSuche.MEDIAN);
		for (int i = 0; i < N; i++) {
			assertEquals(String.format("Liste falsch sortiert an Stelle %d", i), testListe2.get(i).getKey(),
					testListe.get(i).getKey());
		}
	}

	@Test
	public void testZUFAELLIG() {
		List<Datensatz<String>> testListe = new ArrayList<>();
		List<Datensatz<String>> testListe2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			testListe.add(new Datensatz<String>(i, "Test"));
			testListe2.add(new Datensatz<String>(i, "Test"));
		}
		Collections.shuffle(testListe);
		QuickSort<String> qSort = new QuickSort<String>();
		qSort.quicksortStart(testListe, 0, N - 1, PivotElementSuche.ZUFAELLIG);
		for (int i = 0; i < N; i++) {
			assertEquals(String.format("Liste falsch sortiert an Stelle %d", i), testListe2.get(i).getKey(),
					testListe.get(i).getKey());
		}
	}

}
