package jingda.algo.search.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * test if graph contains circle by top sort
 */
public class GraphCircleTest {

    public static void main(String[] args) {
        GraphCircleTest graphCircleTest = new GraphCircleTest();
//        int numCourses = 3;
//        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 0}};
//        int[] ints = graphCircleTest.topSort(numCourses, prerequisites);
//        System.out.println(Arrays.toString(ints));

        int numCourses2 = 5;
        int[][] prerequisites2 = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
        int[] ints2 = graphCircleTest.topSort(numCourses2, prerequisites2);
        System.out.println(Arrays.toString(ints2));
    }

    public int[] topSort(int numCourses, int[][] prerequisites) {
        // 用于存储每个顶点的入度
        int[] indegrees = new int[numCourses];
        // 存储每个顶点的邻接列表
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            // 添加一条有向边 from -> to
            adjList.get(from).add(to);
            // 更新 to 的入度
            indegrees[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                // 将入度为 0 的顶点加入队列
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        // 记录已经输出的顶点数
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 将当前顶点加入结果数组
            res[count] = cur;
            count++;
            for (int neighbor : adjList.get(cur)) {
                // 将相邻顶点的入度减 1
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    // 将入度变为 0 的顶点加入队列
                    queue.offer(neighbor);
                }
            }
        }

        if (count != numCourses) {
            // 有环，返回空数组
            return new int[0];
        }
        return res;
    }
}

