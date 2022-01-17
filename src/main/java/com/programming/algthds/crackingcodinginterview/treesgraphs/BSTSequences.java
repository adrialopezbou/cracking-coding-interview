package com.programming.algthds.crackingcodinginterview.treesgraphs;

import com.programming.algthds.crackingcodinginterview.treesgraphs.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeForBSTSequences();
        List<LinkedList<Integer>> results = recurseTree(root);
        for(LinkedList<Integer> result: results) {
            System.out.print("- ");
            for (Integer i: result) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

    public static List<LinkedList<Integer>> recurseTree(TreeNode root) {
        List<LinkedList<Integer>> results = new ArrayList<>();
        if(root == null) {
            LinkedList<Integer> result = new LinkedList<>();
            results.add(result);
            return results;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.data);

        List<LinkedList<Integer>> leftSide = recurseTree(root.left);
        List<LinkedList<Integer>> rightSide = recurseTree(root.right);

        for(LinkedList<Integer> left: leftSide) {
            for(LinkedList<Integer> right: rightSide) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weave(prefix, left, right, weaved);
                results.addAll(weaved);
            }
        }

        return results;
    }

    private static void weave(LinkedList<Integer> prefix, LinkedList<Integer> left, LinkedList<Integer> right, List<LinkedList<Integer>> weaved) {
        if(left.isEmpty() || right.isEmpty()) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(left);
            result.addAll(right);
            weaved.add(result);
            return;
        }

        Integer headVal = left.pop();
        prefix.add(headVal);
        weave(prefix, left, right, weaved);
        prefix.removeLast();
        left.addFirst(headVal);

        headVal = right.pop();
        prefix.add(headVal);
        weave(prefix, left, right, weaved);
        prefix.removeLast();
        right.addFirst(headVal);
    }

}
