package com.ragku.limit.sort;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Queue<KV> queue = new PriorityQueue<>(Comparator.comparingInt(KV::getV));
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer v = map.get(n);
            v = null == v ? 1 : v + 1;
            map.put(n, v);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new KV(entry.getKey(),entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            if(queue.isEmpty()) {
                break;
            }
            arr[i] = queue.poll().getK();
        }
        return arr;
    }

    private static class KV {
        Integer k;
        int v;

        public KV(int k, int v) {
            this.k = k;
            this.v = v;
        }

        public int getV(){
            return v;
        }
        public int getK() {
            return k;
        }
    }
}
