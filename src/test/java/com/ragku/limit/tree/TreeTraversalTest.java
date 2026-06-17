package com.ragku.limit.tree;

import com.ragku.limit.TreeNode;
import junit.framework.TestCase;
import org.junit.Assert;

public class TreeTraversalTest extends TestCase {


    /**
     * 8,4,9,2,10,5,11,1,12,6,13,3,14,7,15,
     * 1,2,4,8,9,5,10,11,3,6,12,13,7,14,15,
     * 8,9,4,10,11,5,2,12,13,6,14,15,7,3,1,
     * [8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15]
     * [1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15]
     * [8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1]
     */


    public void testGenerateTree() {
        TreeTraversal tt = new TreeTraversal();
        int[] preArr = {3, 9, 20, 15, 7};
        int[] inArr = {9, 3, 15, 20, 7};
        TreeNode tn = tt.generateTree(inArr, preArr);
        TreeNode tn1 = tt.buildTree(preArr, inArr);
        TreeNode tn2 = new TreeNode(3);
        tn2.left = new TreeNode(9);
        tn2.right = new TreeNode(20);
        tn2.right.left = new TreeNode(15);
        tn2.right.right = new TreeNode(7);
        equal(tn, tn2);
        equal(tn1, tn2);
    }

    private static void equal(TreeNode tn1, TreeNode tn2) {
        if(tn1 == null && tn2 == null) {
            return;
        }
        Assert.assertFalse(tn1 == null || tn2 == null);
        Assert.assertEquals(tn1.val, tn2.val);
        equal(tn1.left, tn2.left);
        equal(tn1.right, tn2.right);
    }
}