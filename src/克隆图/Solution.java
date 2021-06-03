package 克隆图;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> saves = new HashMap<>();
        if(node == null) return node;
        return cloneGraph(node,saves);
    }

    private Node cloneGraph(Node node,Map<Node,Node> saves){
        saves.put(node,new Node(node.val));
        for (Node node1:node.neighbors){
            if (saves.containsKey(node1)){
                saves.get(node).neighbors.add(saves.get(node1));
            }else {
                saves.get(node).neighbors.add(cloneGraph(node1,saves));
            }
        }
        return saves.get(node);
    }
}
