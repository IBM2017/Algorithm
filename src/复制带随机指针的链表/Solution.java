package 复制带随机指针的链表;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val);

        this.visitedHash.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
