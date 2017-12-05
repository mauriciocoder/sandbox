package com.bon.sand;

import com.google.common.collect.ImmutableList;
import lombok.val;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void should_calculate_tree_height() {
        /**
         *   1
         *   |
         *   2
         *  / \
         * 3   4
         *     |
         *     5
         */
        val node5 = new Node(5, ImmutableList.of());
        val node4 = new Node(4, ImmutableList.of(node5));
        val node3 = new Node(3, ImmutableList.of());
        val node2 = new Node(2, ImmutableList.of(node3, node4));
        val node1 = new Node(1, ImmutableList.of(node2));

        assertThat(node1.getHeight(), is(4));
        assertThat(node2.getHeight(), is(3));
        assertThat(node3.getHeight(), is(1));
        assertThat(node4.getHeight(), is(2));
        assertThat(node5.getHeight(), is(1));
    }

    @Test(expected = NullPointerException.class)
    public void should_fail_with_NPE_when_children_is_null() {
        new Node(1, null);
    }
}