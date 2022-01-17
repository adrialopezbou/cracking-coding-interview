package com.programming.algthds.crackingcodinginterview.treesgraphs.classes;

import com.programming.algthds.crackingcodinginterview.treesgraphs.FirstCommonAncestor;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode left, TreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public static TreeNode createLargerTreeForCheckSubtree() {
        TreeNode n = createParentWithChildren(new TreeNode(1), new TreeNode(2), 3);
        n = createParentWithChildren(n, new TreeNode(2), 5);
        return n;
    }

    public static TreeNode createSmallerTreeForCheckSubtree() {
        return createParentWithChildren(new TreeNode(1), new TreeNode(2), 3);
    }

    public static TreeNode createTreeForFirstCommonAncestor() {
        TreeNode n = createParentWithChildren(new TreeNode(1), new TreeNode(2), 3);
        n = createParentWithChildren(n, new TreeNode(4), 5);
        n = createParentWithChildren( new TreeNode(6), n,  7);
        n.right.right.right = new TreeNode(8);
        return n;
    }

    public static TreeNode createTreeForBSTSequences() {
        TreeNode n = createParentWithChildren(new TreeNode(1), new TreeNode(3), 2);
        n = createParentWithChildren(n, new TreeNode(5), 4);
        return n;
    }


    public static TreeNode createParentWithChildren(TreeNode left, TreeNode right, int data) {
        return new TreeNode(left, right, data);
    }
}
