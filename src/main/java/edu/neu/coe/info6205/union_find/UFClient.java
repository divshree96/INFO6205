package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {
    public static int count(int n) {
        int count = 0;

        for(int i=0; i< 1000; i++) {
            UF_HWQUPC uf = new UF_HWQUPC(n, true);
            int pairCount = 0;

            while (uf.components() != 1) {
                int pair[] = create_random_pair(n);
                pairCount++;

                if (!uf.connected(pair[0], pair[1])) {
                    uf.union(pair[0], pair[1]);
                }
            }
            count += pairCount;
        }

        return count/1000;
    }

    private static int[] create_random_pair(int n) {
        Random ran = new Random();
        int p1 = ran.nextInt(n);
        int p2 = ran.nextInt(n);

        while(p1 == p2) {
            p2 = ran.nextInt(n);
        }

        return new int[]{p1, p2};

    }

    public static void main(String[] args) {
        int[] n = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000};

        for(int i=0; i<n.length; i++) {
            int connections = count(n[i]);
            System.out.print("Number of sites : " + n[i]  +"; ");
            System.out.println("Number of connections: " + connections);
        }
    }
}
