import java.util.*;

class Node {
    String previous;
    String value;
    String next;
    Node prevNode;
    Node nextNode;

    Node(String previous, String value, String next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }
}

public class DoublyLinkedListLink {
    public static Node linkNodes(List<Node> nodes) {
        // Step 1: Create a map of value to Node
        Map<String, Node> nodeMap = new HashMap<>();
        for (Node node : nodes) {
            nodeMap.put(node.value, node);
        }

        // Step 2: Link the nodes
        Node head = null;
        for (Node node : nodes) {
            node.prevNode = nodeMap.get(node.previous);
            node.nextNode = nodeMap.get(node.next);
            if (node.prevNode == null) {
                head = node;  // This is the head node
            }
        }

        if (head == null) {
            throw new IllegalArgumentException("Invalid input: No head node found");
        }

        return head;
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[previous->\"" + current.previous + "\", value->\"" + current.value + "\", next->\"" + current.next + "\"], ");
            current = current.nextNode;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample unordered list of nodes
        List<Node> nodes = Arrays.asList(
            new Node("b", "c", "d"),
            new Node(null, "b", "c"),
            new Node("c", "a", null),
            new Node("d", "e", null)
        );

        System.out.println("Original unordered nodes:");
        for (Node node : nodes) {
            System.out.print("[previous->\"" + node.previous + "\", value->\"" + node.value + "\", next->\"" + node.next + "\"], ");
        }
        System.out.println();

        // Link the nodes
        Node head = linkNodes(nodes);

        System.out.println("Linked list:");
        printList(head);
    }
}