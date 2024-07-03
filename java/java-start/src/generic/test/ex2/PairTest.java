package generic.test.ex2;

class Pair<K,V> {
	private K first;
	private V second;

	public void setFirst(K first) {
		this.first = first;
	}

	public void setSecond(V second) {
		this.second = second;
	}

	public K getFirst() {
		return first;
	}

	public V getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "Pair{" +
			"first=" + first +
			", second=" + second +
			'}';
	}
}
public class PairTest {
	public static void main(String[] args) {
		Pair<Integer, String> pair1 = new Pair<>();
		pair1.setFirst(1);
		pair1.setSecond("data");
		System.out.println(pair1.getFirst());
		System.out.println(pair1.getSecond());
		System.out.println("pair1 = " + pair1);
		Pair<String, String> pair2 = new Pair<>();
		pair2.setFirst("key");
		pair2.setSecond("value");
		System.out.println(pair2.getFirst());
		System.out.println(pair2.getSecond());
		System.out.println("pair2 = " + pair2);
	}
}
