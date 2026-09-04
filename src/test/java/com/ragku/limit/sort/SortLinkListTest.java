package com.ragku.limit.sort;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class SortLinkListTest extends TestCase {

    private ListNode build(int[] arr) {
        ListNode root = null , tmp = null;
        for(int i : arr) {
            if(null == root) {
                root = new ListNode(i);
                tmp = root;
            } else {
                tmp.next = new ListNode(i);
                tmp = tmp.next;
            }
        }
        return root;
    }

    private void check(ListNode root, int[] arr) {
        for(int i : arr) {
            Assert.assertNotNull(root);
            Assert.assertEquals(i, root.val);
            root = root.next;
        }
    }

    SortLinkList sortLinkList = new SortLinkList();
    public void testSortList() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(3);
        root = sortLinkList.sortList(root);
        for(int i = 1; i<=4; i++) {
            Assert.assertEquals(i, root.val);
            root = root.next;
        }
    }

    public void testSortList2() {
        int[] arr = {-1,5,3,4,0};
        ListNode root =  build(arr);
        root = sortLinkList.sortList(root);
        Arrays.sort(arr);
        check(root, arr);
    }

    public void testSortList3() {
        int[] arr = {4,2,1,3};
        ListNode root =  build(arr);
        root = sortLinkList.sortList(root);
        Arrays.sort(arr);
        check(root, arr);
    }
}