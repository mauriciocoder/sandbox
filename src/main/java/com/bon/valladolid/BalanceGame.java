package com.bon.valladolid;

import java.util.Arrays;

public class BalanceGame {
    public int findDifferentWaysToBalance(int w, int t1, int t2, int t3, int tokenQty) {
        int waysToBalance = 0;
        //int[] combinations = new int[6];
        for (int x = 0; x <= tokenQty; x++) {
            for (int y = 0; y <= tokenQty; y++) {
                for (int z = 0; z <= tokenQty; z++) {
                    int leftSide = w;
                    leftSide += t1 * x;
                    leftSide += t2 * y;
                    leftSide += t3 * z;
                    for (int i = 0; i <= tokenQty; i++) {
                        if (i > 0 && x > 0) {
                            continue;
                        }
                        for (int j = 0; j <= tokenQty; j++) {
                            if (j > 0 && y > 0) {
                                continue;
                            }
                            for (int k = 0; k <= tokenQty; k++) {
                                if (k > 0 && z > 0) {
                                    continue;
                                }
                                int rightSide = 0;
                                rightSide += t1 * i;
                                rightSide += t2 * j;
                                rightSide += t3 * k;
                                if (leftSide == rightSide) {
                                    System.out.println("### EQUALITY ###");
                                    System.out.println(Arrays.asList(x, y, z, i, j, k));
                                    waysToBalance++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return waysToBalance;
    }

    public static void main(String... args) {
        new BalanceGame().findDifferentWaysToBalance(140, 20, 50, 40, 3);
    }
}
