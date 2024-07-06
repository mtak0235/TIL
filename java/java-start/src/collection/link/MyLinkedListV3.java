package collection.link;

public class MyLinkedListV3<E> {
	private Node<E> first;
	private int size = 0;

	public void add(E e) {
		Node<E> node = new Node<E>(e);
		if (first == null) {
			first = node;
		} else {
			Node<E> lastNode = getLastNode(node);
			lastNode.next = node;
		}
		size++;
	}

	public Node<E> getLastNode(Node<E> node) {
		Node<E> x = first;
		while (x.next != null) {
			x = x.next;
		}
		return x;
	}

	//code added
	public void add(int index, E e) {
		Node<E> newNode = new Node<E>(e);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node<E> prev = getNode(index - 1);
			newNode.next = prev.next;
			prev.next = newNode;
		}
		++size;
	}

	public Object set(int index, E e) {
		Node<E> x = getNode(index);
		E oldValue = x.item;
		x.item = e;
		return oldValue;
	}

	public Object remove(int index) {
		Node<E> removeNode = getNode(index);
		Object oldItem = removeNode.item;
		if (index == 0) {
			first = removeNode.next;
		} else {
			Node<E> prev = getNode(index - 1);
			prev.next = removeNode.next;
		}
		removeNode.item = null;
		removeNode.next = null;
		size--;
		return oldItem;
	}

	public E get(int index) {
		Node<E> node = getNode(index);
		return node.item;
	}

	public Node<E> getNode(int index) {
		Node<E> x = first;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}

	public int indexOf(Object e) {
		int index = 0;
		for (Node<E> x = first; x != null; x = x.next) {
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

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item) {
			this.item = item;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node<E> x = this;
			sb.append("[");
			while (x != null) {
				sb.append(x.item);
				if (x.next != null) {
					sb.append("->");
				}
				x = x.next;
			}
			sb.append("]");
			return sb.toString();
		}
	}
}
