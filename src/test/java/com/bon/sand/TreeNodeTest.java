package com.bon.sand;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

public class TreeNodeTest {
    private TreeNode root;

    @Before
    public void setup() {
        root = new TreeNode(1, new HashSet<>(), null);

        TreeNode n2 = root.addChild(2);
        TreeNode n3 = root.addChild(3);

        TreeNode n4 = n2.addChild(4);
        TreeNode n5 = n2.addChild(5);

        TreeNode n6 = n3.addChild(6);
        TreeNode n7 = n3.addChild(7);

        TreeNode n8 = n4.addChild(8);
        TreeNode n9 = n8.addChild(9);

        TreeNode n10 = n5.addChild(10);
        TreeNode n11 = n10.addChild(11);
        TreeNode n12 = n10.addChild(12);
    }

    @Test
    public void should_return_3_for_node_10_height() {
        Assert.assertEquals(3, root.findChildHeight(10));
    }

    @Test
    public void should_return_3_for_node_8_height() {
        Assert.assertEquals(3, root.findChildHeight(8));
    }

    @Test
    public void should_return_4_for_node_11_height() {
        Assert.assertEquals(4, root.findChildHeight(11));
    }

    @Test
    public void should_return_1_for_node_2_height() {
        Assert.assertEquals(1, root.findChildHeight(2));
    }

    @Test
    public void should_return_1_for_node_3_height() {
        Assert.assertEquals(1, root.findChildHeight(3));
    }

    @Test
    public void should_return_0_for_node_1_height() {
        Assert.assertEquals(0, root.findChildHeight(1));
    }

}
