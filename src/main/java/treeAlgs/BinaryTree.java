package treeAlgs;

public class BinaryTree {
    private TreeNode root;

    private BinaryTree(TreeNode root) {
        this.root = root;
    }

    private static class TreeNode {
        int key;
        String name;
        TreeNode right = null;
        TreeNode left = null;

        TreeNode(int key, String name) {
            this.key = key;
            this.name = name;
        }

        private static int compare(TreeNode n1, TreeNode n2) {
            return Integer.compare(n1.key, n2.key);
        }

        private boolean greater(TreeNode node) {
            return compare(this, node) > 0;
        }

        public TreeNode getDescByNodeKey(int nodeKey) {
            if (this.key > nodeKey) return this.left;
            else return this.right;
        }

        void addPetal(TreeNode treeNode) {
            if (this.greater(treeNode)) {
                if (this.left == null) {
                    this.left = treeNode;
                } else {
                    this.left.addPetal(treeNode);
                }
            } else {
                if (this.right == null) {
                    this.right = treeNode;
                } else {
                    this.right.addPetal(treeNode);
                }
            }
        }

        public TreeNode findNode(int nodeKey) {
            if (this.key == nodeKey) return this;
            if (this.left != null && this.key > nodeKey) return this.left.findNode(nodeKey);
            else if (this.right != null && this.key < nodeKey) return this.right.findNode(nodeKey);
            throw new IllegalArgumentException("Put correct nodeKey");
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void addNode(int nodeKey, String nodeName) {
        TreeNode treeNode = new TreeNode(nodeKey, nodeName);
        root.addPetal(treeNode);
    }

    public static BinaryTree createTree(int rootKey, String rootName) {
        return new BinaryTree(new TreeNode(rootKey, rootName));
    }

    public void deleteNode(int nodeKey) {
        TreeNode parentNode = null;
        TreeNode currentNode = root;
        while (currentNode.key != nodeKey) {
            parentNode = currentNode;
            currentNode = currentNode.getDescByNodeKey(nodeKey);
        }
        assert parentNode != null;
        if (currentNode.left == null && currentNode.right == null) {
            if (parentNode.greater(currentNode)) parentNode.left = null;
            else parentNode.right = null;
        } else if (currentNode.right == null || currentNode.left == null) {
            if (currentNode.right == null) {
                if (parentNode.greater(currentNode)) parentNode.left = currentNode.left;
                else parentNode.right = currentNode.left;
            }
            if (currentNode.left == null) {
                if (parentNode.greater(currentNode)) parentNode.left = currentNode.right;
                else parentNode.right = currentNode.right;
            }
        } else {
            TreeNode leftMostNode = currentNode.right;
            TreeNode parentOfLeftMostNode = null;
            while (leftMostNode.left != null) {
                parentOfLeftMostNode = leftMostNode;
                leftMostNode = leftMostNode.left;
            }

            if (parentOfLeftMostNode != null) {
                parentOfLeftMostNode.left = leftMostNode.right;
            }

            leftMostNode.right = currentNode.right;
            leftMostNode.left = currentNode.left;

            if (parentNode.greater(currentNode)) parentNode.left = leftMostNode;
            else parentNode.right = leftMostNode;

        }
    }

    public void deleteNode(TreeNode node) {
        deleteNode(node.key);
    }

    public TreeNode findNode(int nodeKey) {
        return root.findNode(nodeKey);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.createTree(180, "b");
        binaryTree.addNode(15, "c");
        binaryTree.addNode(200, "d");
        binaryTree.addNode(10, "e");
        binaryTree.addNode(60, "f");
        binaryTree.addNode(45, "g");
        binaryTree.addNode(55, "h");
        binaryTree.addNode(90, "i");
        binaryTree.addNode(70, "j");
        binaryTree.addNode(150, "k");
        binaryTree.deleteNode(15);
    }
}
