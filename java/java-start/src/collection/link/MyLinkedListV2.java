package collection.link;

public class MyLinkedListV2 {
	private Node first;
	private int size = 0;

	public void add(Object e) {
		Node node = new Node(e);
		if (first == null) {
			first = node;
		} else {
			Node lastNode = getLastNode(node);
			lastNode.next = node;
		}
		size++;
	}

	public Node getLastNode(Node node) {
		Node x = first;
		while (x.next != null) {
			x = x.next;
		}
		return x;
	}

	//code added
	public void add(int index, Object e) {
		Node newNode = new Node(e);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node prev = getNode(index - 1);
			newNode.next = prev.next;
			prev.next = newNode;
		}
		++size;
	}

	public Object set(int index, Object e) {
		Node x = getNode(index);
		Object oldValue = x.item;
		x.item = e;
		return oldValue;
	}

	public Object remove(int index) {
		Node removeNode = getNode(index);
		Object oldItem = removeNode.item;
		if (index == 0) {
			first = removeNode.next;
		} else {
			Node prev = getNode(index - 1);
			prev.next = removeNode.next;
		}
		removeNode.item = null;
		removeNode.next = null;
		size--;
		return oldItem;
	}

	public Object get(int index) {
		Node node = getNode(index);
		return node.item;
	}

	public Node getNode(int index) {
		Node x = first;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}

	public int indexOf(Object e) {
		int index = 0;
		for (Node x = first; x != null; x = x.next) {
			if (e.equals(x.item)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "MyLinkedListV1{" +
			"first=" + first +
			", size=" + size +
			'}';
	}
}
