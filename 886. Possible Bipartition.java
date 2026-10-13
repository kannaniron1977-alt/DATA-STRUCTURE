
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] d : dislikes) {
            graph[d[0]][d[1]] = 1;
            graph[d[1]][d[0]] = 1;
        }

        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                java.util.Queue<Integer> q = new java.util.LinkedList<>();
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int j = 1; j <= n; j++) {
                        if (graph[node][j] == 1) {
                            if (color[j] == 0) {
                                color[j] = -color[node];
                                q.add(j);
                            } else if (color[j] == color[node]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
