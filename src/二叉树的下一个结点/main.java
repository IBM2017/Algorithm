package 二叉树的下一个结点;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[]a){
        Map<Integer,TreeLinkNode> nodes = new HashMap<>();
        int ceng = 4;
        for (int i=0;i<ceng;i++){
            for (int j=0;j<Math.pow(2,i);j++){
                TreeLinkNode node = new TreeLinkNode(i*10+j);
                nodes.put(node.val,node);
                if (nodes.containsKey((i-1)*10+j/2)){
                    node.next=nodes.get((i-1)*10+j/2);
                    if (j%2==0){
                        node.next.left = node;
                    }else node.next.right = node;
                }
            }
        }
        GetNextNode getNextNode = new GetNextNode(nodes.get(37));
        System.out.println(getNextNode.nextNode().val);
    }
}
