package com.programming.algthds.crackingcodinginterview.treesgraphs;

public class FirstCommonAncestor {

    public NodeTree solve(NodeTree first, NodeTree second, NodeTree root) {
        AlgthClass result = recursive(first, second, root);
        return result.ancestor;
    }

    private AlgthClass recursive(NodeTree first, NodeTree second, NodeTree root) {
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

    public NodeTree createTree() {
        NodeTree n = createParentWithChildren(new NodeTree(1), new NodeTree(2), 3);
        n = createParentWithChildren(n, new NodeTree(4), 5);
        n = createParentWithChildren( new NodeTree(6), n,  7);
        n.right.right.right = new NodeTree(8);
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

    public class AlgthClass {
        public NodeTree ancestor;
        public boolean found;

        public AlgthClass(boolean found) {
            this.found = found;
        }

        public AlgthClass(NodeTree ancestor, boolean found) {
            this.ancestor = ancestor;
            this.found = found;
        }
    }
}
