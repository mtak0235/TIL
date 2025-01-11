package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

		Integer reducedParallel = Arrays.asList(1, 2, 3)
			.parallelStream()
			.reduce(10,
				Integer::sum,
				(a, b) -> {
					System.out.println("combiner was called");
					return a + b;
				});
	}
}
