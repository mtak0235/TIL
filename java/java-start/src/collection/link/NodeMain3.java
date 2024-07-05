package collection.link;

public class NodeMain3 {
    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        System.out.println(first);

        System.out.println("모든 노드 탐색");
        printAll(first);

        System.out.println("마지막 노드 조회하기");
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        System.out.println("특정 인덱스의 노드 조회하기");
        int index = 2;
        Node index2Node = getNode(first, index);
        System.out.println("index2Node = " + index2Node);

        System.out.println("데이터 추가하기");
        add(first, "D");
        System.out.println("first = " + first);
    }

    private static void add(Node node, String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

    private static Node getNode(Node first, int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x  = x.next;
        }
        return x;
    }

    public static Node getLastNode(Node first) {
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    private static void printAll(Node first) {
        Node x = first;
        while (x != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }
}
