package com.programming.algthds.crackingcodinginterview.treesgraphs;

import com.programming.algthds.crackingcodinginterview.treesgraphs.classes.TreeNode;

public class FirstCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeForFirstCommonAncestor();

        TreeNode result = solve(new TreeNode(1), new TreeNode(4), root);

        System.out.println(result.data);
    }

    public static TreeNode solve(TreeNode first, TreeNode second, TreeNode root) {
        AlgthClass result = recursive(first, second, root);
        return result.ancestor;
    }

    private static AlgthClass recursive(TreeNode first, TreeNode second, TreeNode root) {
        if(root == null) {
            return new AlgthClass(false);
        }
        AlgthClass findFirst = recursive(first, second, root.left);
        AlgthClass findSecond = recursive(first, second, root.right);

        if(findFirst.ancestor != null) {
            return new AlgthClass(findFirst.ancestor, true);
        }

        if(findSecond.ancestor != null) {
            return new AlgthClass(findSecond.ancestor, true);
        }

        if(findFirst.found && findSecond.found) {
            return new AlgthClass(root, true);
        }

        if(findFirst.found || findSecond.found) {
            return new AlgthClass(true);
        }
        if(root.data == first.data || root.data == second.data) {
            return new AlgthClass(true);
        }
        return new AlgthClass(false);
    }



    public static class AlgthClass {
        public TreeNode ancestor;
        public boolean found;

        public AlgthClass(boolean found) {
            this.found = found;
        }

        public AlgthClass(TreeNode ancestor, boolean found) {
            this.ancestor = ancestor;
            this.found = found;
        }
    }
}
