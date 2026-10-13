
import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] safe = new boolean[n];

        for (int i = 0; i < n; i++) {
            isSafe(i, graph, safe, new boolean[n]);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    boolean isSafe(int node, int[][] graph,
                   boolean[] safe, boolean[] path) {
        if (safe[node]) return true;
        if (path[node]) return false;

        path[node] = true;

        for (int next : graph[node]) {
            if (!isSafe(next, graph, safe, path)) {
                return false;
            }
        }

        path[node] = false;
        safe[node] = true;
        return true;
    }
}
