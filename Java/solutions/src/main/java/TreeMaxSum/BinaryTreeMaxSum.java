package TreeMaxSum;


public class BinaryTreeMaxSum {
    public static void main(String []args){
        BinaryTreeMaxSum instance=new BinaryTreeMaxSum();
        TreeNode root=new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                    new TreeNode(15),new TreeNode(7)));
        int maxSum=instance.maxPathSum(root);
        System.out.println("Max Sum is : "+maxSum);
    }

    private Integer maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recurseHelper(root);
        return maxSum;
    }

    private int recurseHelper(TreeNode node){
        if(node == null) return 0;
        int lMaxSum=Math.max(recurseHelper(node.left),0);
        int rMaxSum=Math.max(recurseHelper(node.right),0);

        int currentMaxSum=node.val+lMaxSum+rMaxSum;

        maxSum = Math.max(maxSum, currentMaxSum);

        return node.val+Math.max(lMaxSum,rMaxSum);
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