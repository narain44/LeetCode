package TreeBoundaryOfBinaryTree;


import java.util.ArrayList;
import java.util.List;

public class BoundryOfBinaryTree {
    List<Integer> output = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null ) return output;
        output.add(root.val);
        addLeftBoundary(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        addRightBoundary(root.right);
        return output;
    }

    private void addLeftBoundary(TreeNode node) {
        if (node == null || node.left == null && node.right == null) return;
        output.add(node.val);
        if (node.left != null)
            addLeftBoundary(node.left);
        else
            addLeftBoundary(node.right);

    }

    private void addRightBoundary(TreeNode node) {
        if (node == null || node.left == null && node.right == null) return;
        if (node.right != null) {
            addRightBoundary(node.right);
        } else {
            addRightBoundary(node.left);
        }
        output.add(node.val);
    }

    private void addLeaves(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            output.add(node.val);
        addLeaves(node.left);
        addLeaves(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        BoundryOfBinaryTree instance = new BoundryOfBinaryTree();
        List<Integer> output = instance.boundaryOfBinaryTree(root);
        System.out.println(output.toString());
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