package jingda.algo.search.tree;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.In;

/**
 *
 */
public class TreeTraverse {

    public static void main(String[] args) {

        /*
         * preOrder
         *            2
         *         |     \
         *        3       4
         *       | \     | \
         *      8   9   6   7
         */
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode2.setLeft(treeNode3);
        treeNode2.setRight(treeNode4);

        treeNode3.setLeft(treeNode8);
        treeNode3.setRight(treeNode9);

        treeNode4.setLeft(treeNode6);
        treeNode4.setRight(treeNode7);

        TreeTraverse treeTraverse = new TreeTraverse();
        System.out.println("pre" + treeTraverse.preOrder(treeNode2));

        System.out.println("in" + treeTraverse.inOrder(treeNode2));

        System.out.println("post" + treeTraverse.postOrder(treeNode2));
    }

    private List<Integer> preOrder(TreeNode node) {

        List<Integer> values = new ArrayList<>();
        if (node == null) {
            return values;
        }
        values.add(node.getValue());
        values.addAll(preOrder(node.getLeft()));
        values.addAll(preOrder(node.getRight()));
        return values;
    }

    private List<Integer> inOrder(TreeNode node) {

        List<Integer> values = new ArrayList<>();
        if (node == null) {
            return values;
        }
        values.addAll(inOrder(node.getLeft()));
        values.add(node.getValue());
        values.addAll(inOrder(node.getRight()));
        return values;
    }

    private List<Integer> postOrder(TreeNode node) {

        List<Integer> values = new ArrayList<>();
        if (node == null) {
            return values;
        }
        values.addAll(postOrder(node.getLeft()));
        values.addAll(postOrder(node.getRight()));
        values.add(node.getValue());
        return values;
    }

    private static final class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
