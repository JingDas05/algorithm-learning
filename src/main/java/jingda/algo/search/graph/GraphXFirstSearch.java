package jingda.algo.search.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * depthFirstStack1-[0, 2, 4, 1, 3]
 * depthFirstRecursion1-[0, 1, 3, 4, 2]
 * depthFirstStack2-[2, 3, 0, 1]
 * depthFirstRecursion2-[2, 0, 1, 3]
 */
public class GraphXFirstSearch {

    public static void main(String[] args) {

        /*
         * 测试用例1
         *        0
         *       | \
         *       1  2
         *      | \
         *     3   4
         */
        GraphXFirstSearch search1 = new GraphXFirstSearch(5);

        search1.addEdge(0, 1);
        search1.addEdge(0, 2);
        search1.addEdge(1, 3);
        search1.addEdge(1, 4);
        search1.addEdge(2, 4);

        System.out.println("depthFirstStack1-" + search1.depthFirstSearchStack(0));
        boolean[] visited1 = new boolean[5];
        List<Integer> results1 = new ArrayList<>();
        System.out.println("depthFirstRecursion1-" + search1.depthFirstSearchRecursion(0, visited1, results1));
        System.out.println("breadthFirstQueue-" + search1.breadthFirstSearchQueue(0));

        /*
         * 测试用例2
         *        0
         *       | \
         *       1  2
         *           \
         *            3
         */
        GraphXFirstSearch search2 = new GraphXFirstSearch(6);
        search2.addEdge(0, 1);
        search2.addEdge(0, 2);
        search2.addEdge(1, 2);
        search2.addEdge(2, 0);
        search2.addEdge(2, 3);
        search2.addEdge(3, 3);

        System.out.println("depthFirstStack2-" + search2.depthFirstSearchStack(2));
        boolean[] visited2 = new boolean[6];
        List<Integer> results2 = new ArrayList<>();
        System.out.println("depthFirstRecursion2-" + search2.depthFirstSearchRecursion(2, visited2, results2));
        System.out.println("breadthFirstQueue-" + search2.breadthFirstSearchQueue(2));
    }

    private final int nodeCount;
    /**
     * 存储图的关系
     */
    private final LinkedList<Integer>[] nodes;

    public GraphXFirstSearch(int nodeCount) {
        this.nodeCount = nodeCount;
        nodes = new LinkedList[nodeCount];
        for (int i = 0; i < this.nodeCount; i++) {
            // 初始化节点关系
            nodes[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end) {
        nodes[start].add(end);
    }

    public List<Integer> depthFirstSearchRecursion(int start, boolean[] visited, List<Integer> results) {
        visited[start] = true;
        results.add(start);

        LinkedList<Integer> nextNodes = nodes[start];
        for (Integer node : nextNodes) {
            if (!visited[node]) {
                depthFirstSearchRecursion(node, visited, results);
            }
        }
        return results;
    }

    public List<Integer> breadthFirstSearchQueue(int start) {

        boolean[] visited = new boolean[this.nodeCount];
        List<Integer> results = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        // 设置初始值
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            visited[head] = true;
            results.add(head);

            LinkedList<Integer> nextNodes = this.nodes[head];
            for (int next : nextNodes) {
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }
        return results;
    }

    public List<Integer> depthFirstSearchStack(int start) {

        boolean[] visited = new boolean[this.nodeCount];
        visited[start] = true;
        List<Integer> results = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        // 设置初始值
        stack.push(start);

        while (!stack.isEmpty()) {

            Integer pop = stack.pop();
            visited[pop] = true;
            results.add(pop);

            LinkedList<Integer> nextNodes = nodes[pop];
            for (Integer nextNode : nextNodes) {
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                }
            }
        }
        return results;
    }
}
