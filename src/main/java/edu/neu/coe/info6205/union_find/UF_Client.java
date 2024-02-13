package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_Client {
    public static Result countConnectionsAndPairs(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        int connections = 0;
        int pairsGenerated = 0;
        Random random = new Random();

        while (uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            pairsGenerated++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                connections++;
            }
        }
        return new Result(pairsGenerated, connections);
    }

    public static void main(String[] args) {
        int[] nValues = {100, 200, 400, 800, 1600, 3200, 6400};

        for (int n : nValues) {
            Result result = countConnectionsAndPairs(n);
            System.out.println("For n = " + n + ", pairs generated: " + result.pairsGenerated + ", connections required: " + result.connections);
        }
    }
    static class Result {
        final int pairsGenerated;
        final int connections;

        Result(int pairsGenerated, int connections) {
            this.pairsGenerated = pairsGenerated;
            this.connections = connections;
        }
    }
}
