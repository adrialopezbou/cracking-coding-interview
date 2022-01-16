package com.programming.algthds.crackingcodinginterview.treesgraphs;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences {

    public static void main(String[] args) {
        BSTSequences solver = new BSTSequences();
        NodeTree root = solver.createTree2();
        List<LinkedList<Integer>> results = solver.recurseTree(root);
        for(LinkedList<Integer> result: results) {
            System.out.print("- ");
            for (Integer i: result) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

    public List<LinkedList<Integer>> recurseTree(NodeTree root) {
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

    public void weave(LinkedList<Integer> prefix, LinkedList<Integer> left, LinkedList<Integer> right, List<LinkedList<Integer>> weaved) {
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

    public NodeTree createTree() {
        NodeTree n = createParentWithChildren(new NodeTree(1), new NodeTree(2), 3);
        n = createParentWithChildren(n, new NodeTree(4), 5);
        n = createParentWithChildren(new NodeTree(6), n,  7);
        n.right.right.right = new NodeTree(8);
        return n;
    }

    public NodeTree createTree2() {
        NodeTree n = createParentWithChildren(new NodeTree(1), new NodeTree(3), 2);
        n = createParentWithChildren(n, new NodeTree(5), 4);
        return n;
    }

    public NodeTree createParentWithChildren(NodeTree left, NodeTree right, int data) {
        return new NodeTree(left, right, data);
    }

    public class NodeTree {
        public NodeTree left;
        public NodeTree right;
        public int data;

        public NodeTree() {
        }

        public NodeTree(int data) {
            this.data = data;
        }

        public NodeTree(NodeTree left, NodeTree right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
