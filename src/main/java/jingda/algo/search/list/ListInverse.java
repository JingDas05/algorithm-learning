package jingda.algo.search.list;

public class ListInverse {

    public static void main(String[] args) {
        // 3 7 5 9
        Node node3 = new Node("3");
        Node node7 = new Node("7");
        Node node5 = new Node("5");
        Node node9 = new Node("9");

        node3.setNode(node7);
        node7.setNode(node5);
        node5.setNode(node9);

        ListInverse listInverse = new ListInverse();

        System.out.println(listInverse.print(node3));

        listInverse.inverse(node3);

        System.out.println(listInverse.print(node9));
    }

    public String print(Node node) {
        StringBuilder stringBuilder = new StringBuilder();

        Node current = node;
        while (current != null) {
            stringBuilder.append(current.getValue());
            current = current.getNode();
        }
        return stringBuilder.toString();
    }

    public void inverse(Node node) {

        Node pre = null;
        Node current = node;

        while (current != null) {

            // 暂存当前节点的下一个节点
            Node next = current.getNode();
            // 当前节点指向前一个节点
            current.setNode(pre);

            // 指针移位
            pre = current;
            current = next;
        }
    }


    private static final class Node {
        private Node node;
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
