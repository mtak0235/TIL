package collection.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfMain {
	public static void main(String[] args) {
		//편리한 불변 collection
		List<Integer> list = List.of(1, 2, 3);
		// list.add(1); 변경 불가능
		Set<Integer> set = Set.of(1, 2, 3);
		Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");
		System.out.println("list.getClass() = " + list.getClass());
		System.out.println("set.getClass() = " + set.getClass());
		System.out.println("map.getClass() = " + map.getClass());


	}
}
