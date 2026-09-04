package com.ragku.limit.list;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int min = 10001, max = -10001;
        for(ListNode ln : lists) {
            while (ln != null) {
                min = Math.min(min, ln.val);
                max = Math.max(max, ln.val);
                ln = ln.next;
            }
        }
        if(min > 10000 || max < -10000) {
            return null;
        }
        int[] arr = new int[max-min+1];
        for(ListNode ln : lists) {
            while (ln != null) {
                arr[ln.val-min]++;
                ln = ln.next;
            }
        }
        ListNode root = null;
        ListNode ln = null;
        for(int i = 0; i<arr.length;i++) {
            while (--arr[i]>=0) {
                if(null == ln) {
                    ln = new ListNode(i+min);
                    root = ln;
                } else {
                    ln.next = new ListNode(i+min);
                    ln = ln.next;
                }
            }
        }
        return root;
    }
}
