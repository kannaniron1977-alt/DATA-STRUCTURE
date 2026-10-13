
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] count = new int[n];
        int[] order = new int[n];
        boolean[] visited = new boolean[n];

        for (int[] p : prerequisites) {
            count[p[0]]++;
        }

        int index = 0;

        while (index < n) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (count[i] == 0 && !visited[i]) {
                    visited[i] = true;
                    order[index++] = i;
                    found = true;

                    for (int[] p : prerequisites) {
                        if (p[1] == i) {
                            count[p[0]]--;
                        }
                    }
                }
            }

            if (!found) return new int[0];
        }

        return order;
    }
}
