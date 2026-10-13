
import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges,
            double[] succProb, int start, int end) {

        double[] prob = new double[n];
        prob[start] = 1.0;

        for (int i = 0; i < n; i++) {
            boolean changed = false;

            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double p = succProb[j];

                if (prob[u] * p > prob[v]) {
                    prob[v] = prob[u] * p;
                    changed = true;
                }

                if (prob[v] * p > prob[u]) {
                    prob[u] = prob[v] * p;
                    changed = true;
                }
            }

            if (!changed) break;
        }

        return prob[end];
    }
}
