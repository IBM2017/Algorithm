package 二叉树的下一个结点;

public class GetNextNode {
    TreeLinkNode treeLinkNode;

    public GetNextNode(TreeLinkNode treeLinkNode) {
        this.treeLinkNode = treeLinkNode;
    }

    public TreeLinkNode nextNode(){
        if (treeLinkNode.next == null)
            return judgeRight(treeLinkNode.right);
        else if (treeLinkNode.next.left == treeLinkNode){
            if (treeLinkNode.right == null) return treeLinkNode.next;
            else return judgeRight(treeLinkNode.right);
        }
        else {
            if (treeLinkNode.right != null)
                return judgeRight(treeLinkNode.right);
            else {
                TreeLinkNode root = treeLinkNode.next;
                while (root.next!=null&&root==root.next.right)
                    root = root.next;
                return root.next;
            }
        }
    }
    public TreeLinkNode judgeRight(TreeLinkNode root){
        if (root.left == null) return root;
        else return judgeRight(root.left);
    }
}
