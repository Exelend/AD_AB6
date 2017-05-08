package sampling;

import java.util.List;

import algo.BetterQS;
import algo.RandomQS;
import algo.Sortobject;

public class Sampling {

	public static FileWrapper files;

	private static RandomQS random;
	private static BetterQS better;

	private static int base = 10;
	private static int maxExpo = 6;
	private static int minKey = 700;
	private static int maxKey = 800;

	private static int maxLoop = 20;

	private static List<Sortobject<?>> list;

	static public void main(String[] args) {
		long[] resMove = new long[maxLoop];
		long[] resCompare = new long[maxLoop];
		long[] resTotal = new long[maxLoop];
		long[] resTime = new long[maxLoop];
		long time = System.currentTimeMillis();
		files = new FileWrapper("move.txt", "compare.txt", "total.txt", "time.txt");

		random = new RandomQS();
		better = new BetterQS();
		for (int expo = 1; expo <= maxExpo; expo++) {
			long N = (int) Math.pow(base, expo);
			System.err.format("%d \n", N);
			for (int j = 0; j < 4; j++) {
				files.write(j, String.format("%d", N));
			}

			// RANDOM
			for (int i = 0; i < maxLoop; i++) {
				list = Sortobject.getRandomList(N, minKey * N, maxKey * N);
				time = System.currentTimeMillis();
				random.sort(list);
				resTime[i] = System.currentTimeMillis() - time;
				resMove[i] = random.moveCount;
				resCompare[i] = random.cmpCount;
				resTotal[i] = random.getTotalCount();
			}
			files.write(0, getMean(resMove));
			files.write(1, getMean(resCompare));
			files.write(2, getMean(resTotal));
			files.write(3, getMean(resTime));

			for (int stop = 10; stop < 60; stop += 10) {
				// BETTER
				better = new BetterQS();
				for (int i = 0; i < maxLoop; i++) {
					list = Sortobject.getRandomList(N, minKey * N, maxKey * N);
					time = System.currentTimeMillis();
					better.sort(list);
					resTime[i] = System.currentTimeMillis() - time;
					resMove[i] = better.moveCount;
					resCompare[i] = better.cmpCount;
					resTotal[i] = better.getTotalCount();
				}
				files.write(0, getMean(resMove));
				files.write(1, getMean(resCompare));
				files.write(2, getMean(resTotal));
				files.write(3, getMean(resTime));

				
				}
			for (int j = 0; j < 4; j++) {
				files.write(j, "\n");
			}
		

		}

		files.close();

	}

	private static String getMean(long[] arr) {
		long res = 0;
		for (long l : arr) {
			res += l;
		}
		res /= arr.length;
		return String.format(";%d", res);
	}
	/*
	 * private static void printlist(){ for (Sortobject<?> so: list){
	 * System.err.format("%d;",so.getKey()); } System.err.println(); }
	 */

}