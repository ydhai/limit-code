package com.ragku.limit.list;

import junit.framework.TestCase;
import org.junit.Assert;

public class MergeKListsTest extends TestCase {

    MergeKLists mk = new MergeKLists();

    private ListNode build(int[] arr) {
        if(null == arr || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for(int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }

    private ListNode[] buildList(int[][] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        ListNode[] lnArr = new ListNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            lnArr[i] = build(arr[i]);
        }
        return lnArr;
    }

    private void check(ListNode ln, int[] arr) {
        for(int i : arr) {
            Assert.assertEquals(i, ln.val);
            ln = ln.next;
        }
    }

    public void testMergeKLists() {
        int[][] arr = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] lists = buildList(arr);
        ListNode ln = mk.mergeKLists(lists);
        int[] res = {1,1,2,3,4,4,5,6};
        check(ln, res);
    }
}