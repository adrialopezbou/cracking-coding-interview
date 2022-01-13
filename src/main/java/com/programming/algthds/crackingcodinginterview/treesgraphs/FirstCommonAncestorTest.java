package com.programming.algthds.crackingcodinginterview.treesgraphs;

public class FirstCommonAncestorTest {
    public static void main(String[] args) {
        FirstCommonAncestor solver = new FirstCommonAncestor();

        FirstCommonAncestor.NodeTree root = solver.createTree();

        FirstCommonAncestor.NodeTree result = solver.solve(solver.new NodeTree(1), solver.new NodeTree(4), root);

        System.out.println(result.data);
    }
}
