package com.programming.algthds.crackingcodinginterview.treesgraphs;

import com.programming.algthds.crackingcodinginterview.treesgraphs.classes.TreeNode;
import com.sun.source.tree.Tree;

public class CheckSubtree {
    public static void main(String[] args) {
        TreeNode larger = TreeNode.createLargerTreeForCheckSubtree();
        TreeNode smaller = TreeNode.createSmallerTreeForCheckSubtree();
        System.out.println(recurseLargerTree(larger, smaller));
    }

    public static boolean recurseLargerTree(TreeNode larger, TreeNode smaller) {
        if(larger == null) {
            return false;
        }

        if(larger.data == smaller.data) {
            if(recurseBoth(larger, smaller)) {
                return true;
            }
        }
        return recurseLargerTree(larger.left, smaller) || recurseLargerTree(larger.right, smaller);
    }

    private static boolean recurseBoth(TreeNode larger, TreeNode smaller) {
        if(larger == null && smaller != null) {
            return false;
        } else if(larger == null && smaller == null) {
            return true;
        }

        if(larger.data == smaller.data) {
            return recurseBoth(larger.left, smaller.left) && recurseBoth(larger.right, smaller.right);
        }
        return false;
    }
}
