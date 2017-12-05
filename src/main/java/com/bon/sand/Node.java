package com.bon.sand;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;
import lombok.val;

@Value
public class Node {
    int value;
    @NonNull
    ImmutableList<Node> children;

    public int getHeight() {
        val maxChildrenHeight = children.stream().mapToInt(Node::getHeight).max();
        return maxChildrenHeight.orElse(0) + 1;
    }
}