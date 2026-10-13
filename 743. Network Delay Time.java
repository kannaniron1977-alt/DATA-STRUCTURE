
import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] d = new int[n + 1];
        Arrays.fill(d, 999999);
        d[k] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] t : times) {
                int u = t[0], v = t[1], w = t[2];

                if (d[u] != 999999 && d[u] + w < d[v]) {
                    d[v] = d[u] + w;
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] == 999999) return -1;
            max = Math.max(max, d[i]);
        }

        return max;
    }
}
