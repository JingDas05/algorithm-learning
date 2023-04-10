package jingda.algo.search.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历，也是广度优先遍历
 */
public class TreeLevelTraversal {

    public static void main(String[] args) {
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeLevelTraversal solution = new TreeLevelTraversal();
        List<List<Integer>> result = solution.levelTraversal(root);
        // [[3], [9, 20], [15, 7]]
        System.out.println(result);
    }

    public List<List<Integer>> levelTraversal(TreeNode root) {

        // 存储遍历的数据，每层的数据在各自的list里
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> leveData = new ArrayList<>();

            // 确定当前queue中数据的数量，为了下面的本次遍历
            int size = queue.size();
            // 遍历此时此刻 queue 中的值，并且将下一层node的数据添加到 queue 中
            // 用于下一轮遍历
            for (int i = 0; i < size; i++) {

                TreeNode queueNode = queue.poll();
                // 遍历的数据添加到结果集中
                leveData.add(queueNode.getValue());

                // 将下层节点添加到队列中，为了后面的遍历
                if (queueNode.getLeft() != null) {
                    queue.offer(queueNode.getLeft());
                }
                if (queueNode.getRight() != null) {
                    queue.offer(queueNode.getRight());
                }
            }
            // 记录每层数据
            result.add(leveData);
        }
        return result;
    }

    public static final class TreeNode {
        private final int value;
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

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
