public class BandolierOfConvenience implements EnchantedContainer {
    public Node head;
    public Node tail;

    private class Node {
        String itemName;
        Node next;
        Node prev;

        Node(String itemName, Node next, Node prev) {
            this.itemName = itemName;
            this.next = next;
            this.prev = prev;
        }
    }

    public void stow(String itemName) {
        Node newNode = new Node(itemName, null, tail);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public String peek() {
        if (head == null) {
            return null;
        }
        return head.itemName;
    }

    public void use() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
    }
}