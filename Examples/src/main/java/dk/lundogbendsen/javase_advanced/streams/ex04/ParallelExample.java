package dk.lundogbendsen.javase_advanced.streams.ex04;

import java.time.Duration;
import java.util.stream.IntStream;

import dk.lundogbendsen.javase_advanced.streams.ex03.TimingUtil;

public class ParallelExample {
	public static void main(final String[] args) {
		final int N = 140;
		final int WAITMS = 80;
		final boolean mustWork = false;

		System.out.println("Start the system cpu monitor");

		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
			if (i > 0)
				sleep(1000);
		}

		System.out.println("Total execution time expected for sequential processing (N*WAITMS ms): "
				+ (N * WAITMS) / 1000 + " sec");

		IntStream s1 = IntStream.range(0, N);

		Duration t1 = TimingUtil.time("Sequential", (t) -> {
			s1.forEach((i) -> {
				if (mustWork)
					work();
				else
					sleep(WAITMS);
			});
		});
		System.out.println(t1);

		IntStream s2 = IntStream.range(0, N);

		Duration t2 = TimingUtil.time("Parallel", (t) -> {
			s2.parallel().forEach((i) -> {
				if (mustWork)
					work();
				else
					sleep(WAITMS);
			});
		});
		System.out.println(t2);

		System.out.println("Speed up factor: " + (double) t1.toMillis() / (double) t2.toMillis());
	}

	private static void sleep(final int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private static double work() {
		double s = 0.0;
		for (int i = 0; i < 1000000; i++)
			s += Math.sqrt(Math.abs(Math.sin(i / 100000.0)));
		return s;
	}
}
