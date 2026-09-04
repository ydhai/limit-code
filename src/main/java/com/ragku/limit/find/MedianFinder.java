package com.ragku.limit.find;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    TreeNode left = null, right = null, cur = null;


    Queue<Integer> aq,bq;
    public MedianFinder() {
        bq = new PriorityQueue<>();
        aq = new PriorityQueue<>((a,b)->b-a);
    }

    /**
     * 双队列，交替入队，写法更加简洁，不过效率不是最高的
     */
    public void addNum(int num) {
        if(aq.size() == bq.size()) {
            bq.add(num);
            aq.add(bq.poll());
        } else {
            aq.add(num);
            bq.add(aq.poll());
        }
    }

    @SuppressWarnings("all")
    public double findMedian(){
        return aq.size() != bq.size() ? aq.peek() : (aq.peek() + bq.peek())/2.0;
    }

    public double findMedian2() {
        if(null != cur) {
            return cur.val;
        }
        return (left.val + right.val) /2.0;
    }

    public void addNum2(int num) {
        if(null == cur) {
            if(null == left || null == right) {
                cur = new TreeNode(num);
            } else {
                if(num < findMedian2()) {
                    left = addNumLeft(left, num);
                    cur = left;
                    left = left.next;

                } else {
                    right = addNumRight(right, num);
                    cur = right;
                    right = right.next;
                }
                cur.next = null;
            }
            return;
        }
        if (null == left || null == right) {
            if(num < cur.val) {
                left = new TreeNode(num);
                right = cur;
            } else {
                right = new TreeNode(num);
                left = cur;
            }

        } else {
            if(num<cur.val) {
                left = addNumLeft(left, num);
                cur.next = right;
                right = cur;
            } else {
                right = addNumRight(right, num);
                cur.next = left;
                left = cur;
            }

        }
        cur = null;
    }

    private TreeNode addNumLeft(TreeNode tr, int num) {
        if(tr.val<num) {
            return new TreeNode(num, tr);
        }
        TreeNode tmp = tr;
        while(tmp.next!=null &&tmp.next.val>num) {
            tmp = tmp.next;
        }
        if(tmp.next == null) {
            tmp.next = new TreeNode(num);
            return tr;
        }
        tmp.next = new TreeNode(num, tmp.next);
        return tr;
    }

    private TreeNode addNumRight(TreeNode tr, int num) {
        if(tr.val>num) {
            return new TreeNode(num, tr);
        }
        TreeNode tmp = tr;
        while(tmp.next!=null &&tmp.next.val<num) {
            tmp = tmp.next;
        }
        if(tmp.next == null) {
            tmp.next = new TreeNode(num);
            return tr;
        }
        tmp.next = new TreeNode(num, tmp.next);
        return tr;
    }



    private static class TreeNode {
        int val;
        TreeNode next;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode tn) {
            this.val = val;
            this.next = tn;
        }
    }
}
