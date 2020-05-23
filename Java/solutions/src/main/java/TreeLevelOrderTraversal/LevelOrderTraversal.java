package TreeLevelOrderTraversal;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String []args){
        LevelOrderTraversal instance=new LevelOrderTraversal();
        TreeNode root=new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),new TreeNode(7)));
        List<List<Integer>> result=instance.levelOrder(root);
        System.out.println("Level order Traversal is : "+ Arrays.deepToString(result.toArray()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();

        if(root==null) return result;

        queue.add(root);queue.add(null);
        int level=0;
        while(!queue.isEmpty()){
            TreeNode currentNode=queue.pop();
            if (result.size() == level) {
                result.add(level, new ArrayList<Integer>());
            }
            if(currentNode !=null ) {
                result.get(level).add(currentNode.val);
                if(currentNode.left!=null) queue.addLast(currentNode.left);
                if(currentNode.right!=null)  queue.addLast(currentNode.right);
            }else{
                if(queue.isEmpty()){
                    return result;
                }else{
                    queue.addLast(null);
                    level++;
                }
            }
        }


        return result;
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}