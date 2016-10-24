package com.deepakm.datastructures.tree.puzzles;

import com.deepakm.datastructures.tree.BinaryTree;
import com.deepakm.datastructures.tree.TreeNode;

/**
 * Created by dmarathe on 10/24/16.
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.levelOrderTraversal();
    }
}
