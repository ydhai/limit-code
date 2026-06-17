package com.ragku.limit.tree;

import com.ragku.limit.TreeNode;

import java.util.Arrays;
import java.util.List;

public class TreeTraversal {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
//        root.left.right.left = new TreeNode(10);
//        root.left.right.right = new TreeNode(11);
//        root.right.left.left = new TreeNode(12);
//        root.right.left.right = new TreeNode(13);
//        root.right.right.left = new TreeNode(14);
//        root.right.right.right = new TreeNode(15);
//        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        System.out.println(list);
//        list.clear();
//        preOrder(root, list);
//        System.out.println(list);
//        list.clear();
//        postOrder(root, list);
//        System.out.println(list);
    }

    public TreeNode generateTree(int[] inorder, int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                if (i > 0) {
                    root.left = generateTree(Arrays.copyOf(inorder, i), Arrays.copyOfRange(preorder, 1, i + 1));
                }
                if (i < inorder.length - 1) {
                    root.right = generateTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(preorder, i + 1, preorder.length));
                }
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                if (i > 0) {
                    root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOf(inorder, i));
                }
                if (i < inorder.length - 1) {
                    root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                }
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                if (i > 0) {
                    root.left = buildTree2(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOf(inorder, i));
                }
                if (i < inorder.length - 1) {
                    root.right = buildTree2(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                }
                break;
            }
        }
        return root;
    }


    // left-mid-right
    private void inOrder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // mid-left-right
    private void preOrder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);

    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
