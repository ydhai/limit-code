package com.ragku.limit.sort;

import java.util.ArrayList;
import java.util.List;

public class SortLinkList {

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head !=null) {
            ListNode tmp = head.next;
            head.next = null;
            list.add(head);
            head = tmp;
        }
        list = merge(list);
        if(list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    private List<ListNode> merge(List<ListNode> list) {
        List<ListNode> res = new ArrayList<>();
        while(!list.isEmpty()) {
            ListNode a = list.removeFirst();
            if(list.isEmpty()) {
                res.add(a);
            } else {
                res.add(mergeNode(a, list.removeFirst()));
            }
        }
        if(res.size() > 1) {
            res = merge(res);
        }
        return res;
    }

    private ListNode mergeNode(ListNode a, ListNode b) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode pre = head;
        while (a!=null || b != null) {
            if(a == null) {
                pre.next = b;
                b = null;
            } else if(b == null) {
                pre.next = a;
                a = null;
            } else {
                ListNode tmp;
                if(a.val<b.val) {
                    tmp = a;
                    a = a.next;
                } else {
                    tmp = b;
                    b = b.next;
                }
                tmp.next = null;
                pre.next = tmp;
            }
            while (pre.next!=null){pre = pre.next;}
        }
        return head.next;
    }
}
