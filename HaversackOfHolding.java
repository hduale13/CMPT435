public class HaversackOfHolding implements EnchantedContainer {
    public Node top;

    public class Node {
        String itemName;
        Node next;

        Node(String itemName, Node next) {
            this.itemName = itemName;
            this.next = next;
        }
    }

    public void stow(String itemName) {
        top = new Node(itemName, top);
    }

    public String peek() {
        if (top == null) {
            return null;
        }
        return top.itemName;
    }

    public void use() {
        if (top == null) {
            return;
        }
        top = top.next;
    }
}