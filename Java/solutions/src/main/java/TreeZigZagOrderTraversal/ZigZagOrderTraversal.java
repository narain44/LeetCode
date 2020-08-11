package TreeZigZagOrderTraversal;

import java.util.*;

public class ZigZagOrderTraversal {
    public static void main(String[] args) {
        ZigZagOrderTraversal instance = new ZigZagOrderTraversal();
        TreeNode root = new TreeNode(-10,
                new TreeNode(9, new TreeNode(6), new TreeNode(11)),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = instance.levelOrder(root);
        System.out.println("ZigZag order Traversal is : " + Arrays.deepToString(result.toArray()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return result;

        queue.add(root);
        queue.add(null);
        int level = 0;
        while (!queue.isEmpty()) {
            TreeNode currentNode = null;
            result.add(level, new ArrayList<Integer>());
            int n=queue.size(); //snapshot size
            for(int i=0;i<n;i++) {
                currentNode = queue.pollFirst();
                if (currentNode != null) {
                    result.get(level).add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    if (queue.isEmpty()) {
                        for(int j=0;j<result.size();j++) {
                            if (j % 2 == 1) {
                                List<Integer> levelList = result.get(j);
                                Collections.reverse(levelList);
                            }
                        }
                        return result;
                    } else {
                        queue.addLast(null);
                        level++;
                    }
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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}