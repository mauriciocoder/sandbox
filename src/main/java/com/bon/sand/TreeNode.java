package com.bon.sand;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
@EqualsAndHashCode(exclude={"parent", "children"})
public class TreeNode {
    int id;
    Set<TreeNode> children;
    TreeNode parent;

    public int getHeight() {
        if (parent == null) {
            return 0;
        }
        return 1 + parent.getHeight();
    }

    public int findChildHeight(long id) {
        if (id == this.id) {
            return getHeight();
        }
        if (children != null) {
            for (TreeNode child : children) {
                int h = child.findChildHeight(id);
                if (h >= 0) {
                    return h;
                }
            }
        }
        return -1;
    }

    public TreeNode addChild(int i) {
        TreeNode n = new TreeNode(i, new HashSet<>(), this);
        children.add(n);
        return n;
    }
}
