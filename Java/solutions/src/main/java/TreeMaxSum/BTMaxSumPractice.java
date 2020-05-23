package TreeMaxSum;

public class BTMaxSumPractice {
    public static void main(String[] args) {
        BinaryTreeMaxSum instance = new BinaryTreeMaxSum();
        TreeNode root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));
        int maxSum = instance.maxPathSum(root);
        System.out.println("Max Sum is : " + maxSum);
    }

    private Integer maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recurseHelper(root);
        return maxSum;

    }

    private int recurseHelper(TreeNode node) {
       if (node == null) return 0;
       int ltreeSum=Math.max(recurseHelper(node.left),0);
       int rtreeSum=Math.max(recurseHelper(node.right),0);

       int currentMaxSum=node.val+ltreeSum+rtreeSum;

       maxSum=Math.max(currentMaxSum,maxSum);

       return node.val+Math.max(ltreeSum,rtreeSum);

    }
}



