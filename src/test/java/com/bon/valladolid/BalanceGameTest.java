package com.bon.valladolid;

import org.junit.Assert;
import org.junit.Test;

public class BalanceGameTest {
    @Test
    public void should_return_5_ways() {
        BalanceGame balanceGame = new BalanceGame();
        int w = 140;
        int t1 = 20;
        int t2 = 40;
        int t3 = 50;
        int tokenQty = 3;
        int differentWaysToBalance = balanceGame.findDifferentWaysToBalance(w, t1, t2, t3, tokenQty);
        Assert.assertEquals(5, differentWaysToBalance);
    }

    @Test
    public void should_return_0_way() {
        BalanceGame balanceGame = new BalanceGame();
        int w = 105;
        int t1 = 20;
        int t2 = 40;
        int t3 = 50;
        int tokenQty = 3;
        int differentWaysToBalance = balanceGame.findDifferentWaysToBalance(w, t1, t2, t3, tokenQty);
        Assert.assertEquals(0, differentWaysToBalance);
    }

    @Test
    public void should_return_XX_way() {
        BalanceGame balanceGame = new BalanceGame();
        int w = 5000000;
        int t1 = 10;
        int t2 = 500;
        int t3 = 1000;
        int tokenQty = 5000;
        int differentWaysToBalance = balanceGame.findDifferentWaysToBalance(w, t1, t2, t3, tokenQty);
        //Assert.assertEquals(0, differentWaysToBalance);
    }
}
