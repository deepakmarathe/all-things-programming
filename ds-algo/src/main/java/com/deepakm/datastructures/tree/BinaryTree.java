package com.deepakm.datastructures.tree;

/**
 * Created by dmarathe on 10/24/16.
 */
public class BinaryTree {
    private final TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void levelOrderTraversal() {
        for (int i = 1; i <= height(); i++) {
            levelOrderTraverseUtil(root, i);
        }
    }

    private void levelOrderTraverseUtil(TreeNode node, int level) {
        if (node == null) return;
        if (level == 1) {
            System.out.println(node.getData());
        } else {
            levelOrderTraverseUtil(node.getLeft(), level - 1);
            levelOrderTraverseUtil(node.getRight(), level - 1);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}
