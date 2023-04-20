package jingda.algo.search.tree;

/**
 * 求解二叉树的最大深度和最小深度，深度指的是从根节点到叶子节点的距离
 */
public class TreeMaxMinDepth {

    /**
    *          8
    *         | \
    *        9   3
    *       | \   \
    *      4   2   1
    *           \
    *            7
    */
    public static void main(String[] args) {

        TreeNode root8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        root8.setLeft(node9);
        root8.setRight(node3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        node9.setLeft(node4);
        node9.setRight(node2);
        node3.setRight(node1);

        TreeNode node7 = new TreeNode(7);
        node2.setRight(node7);

        TreeMaxMinDepth maxMinDepth = new TreeMaxMinDepth();
        int minDepth = maxMinDepth.minDepth(root8);
        // 1 -> 3 -> 8
        // 3层
        System.out.println("minDepth = " + minDepth);

        // 7 -> 2 -> 9 -> 8
        // 4层
        int maxDepth = maxMinDepth.maxDepth(root8);
        System.out.println("maxDepth = " + maxDepth);

    }

    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return minDepth(node.right) + 1;
        }
        if (node.right == null) {
            return minDepth(node.left) + 1;
        }
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return maxDepth(node.right) + 1;
        }
        if (node.right == null) {
            return maxDepth(node.left) + 1;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    public static final class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
