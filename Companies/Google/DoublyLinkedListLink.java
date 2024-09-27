import java.util.HashMap;
import java.util.Map;

/**
 * Input:-
 * [previous->"b", value->"c", next->"d"],
 * [previous->"null", value->"b", next->"c"],
 * [previous->"c", value->"a", next->"null"],
 * [previous->"d", value->"e", next->"null"]
 *
 * Output:-
 * b -> c -> d -> e -> a
 */

class Node {
    String previous;
    String value;
    String next;
    Node prevNode;
    Node nextNode;

    public Node(String previous, String value, String next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "[previous->\"" + (previous != null ? previous : "null") +
                "\", value->\"" + value + "\", next->\"" + (next != null ? next : "null") + "\"]";
    }
}

public class DoublyLinkedListLink {
    public static void main(String[] args) {
        // Unordered list of unlinked nodes
        Node[] unlinkedNodes = {
                new Node("b", "c", "d"),
                new Node("c", "d", null),
                new Node(null, "a", "b"),  // This should be the head node
                new Node("a", "b", "c")
        };

        // Step 1: Insert all nodes into a map by their value
        Map<String, Node> nodeMap = new HashMap<>();
        for (Node node : unlinkedNodes) {
            nodeMap.put(node.value, node);
        }

        // Step 2: Link the nodes using their previous and next fields
        Node head = null;  // This will be the starting node (no previous node points to it)
        for (Node node : nodeMap.values()) {
            if (node.previous != null) {
                node.prevNode = nodeMap.get(node.previous);  // Link previous node
            }
            if (node.next != null) {
                node.nextNode = nodeMap.get(node.next);  // Link next node
            }
        }

        // Step 3: Find the head of the list (which has no previous node linked to it)
        for (Node node : nodeMap.values()) {
            if (node.previous == null) {
                head = node;  // This node has no previous, so it is the head
                break;
            }
        }

        // Step 4: Print the linked list starting from the head
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.nextNode;
        }
    }
}
