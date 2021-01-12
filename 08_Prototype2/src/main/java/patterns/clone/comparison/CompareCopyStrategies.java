package patterns.clone.comparison;

public class CompareCopyStrategies {
	private static final int SIZE = 10000;
	private static final int NOFCLONES = 1000;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		double referenceTime = measure(new Dictionary("german", SIZE));
	}

	private static double measure(Dictionary dict) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < NOFCLONES; i++) {
			var clone = dict.clone();
			var c = (Dictionary) clone;
			c.oof.setHappyNumber(222);
			System.out.println(c.oof.getHappyNumber());
		}
		long end = System.currentTimeMillis();
		double t = (end - start) / 1000.0;
		System.out.println("Time used: " + t);
		return t;
	}
}
