package com.ragku.limit.find;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length + 1)/2 - 1;
        int[] index = {-1,-1,mid,0};
        int[][] data = {nums1, nums2};
        while(true) {
            find(data, index);
            int del = index[2] - (index[0]+index[1]) - 1;
            if(del == 0) {
                break;
            }
        }
        int v = data[index[3]][index[index[3]]];
        if((nums1.length + nums2.length)%2==0){
            index[2]++;
            find(data, index);
            return (v+data[index[3]][index[index[3]]])/2.0;
        }
        return v;
    }

    // index={0,0,0,0} data0's index; data1's index; total index; target data index;
    private void find(int[][] data, int[] index) {
        int del = index[2] - (index[0]+index[1]) - 1;
        if(index[2]<0 || del == 0 || del > data[0].length+data[1].length) {
            return;
        }

        boolean index0 = index[0]<data[0].length;
        boolean index1 = index[1]<data[1].length;
        int dataIndex = -1;
        if(!index1&&index0) {
            dataIndex = 0;
        } else if(!index0&&index1) {
            dataIndex = 1;
        }

        if(dataIndex == -1) {
            del = del >=2 ? del/2 : del;
            boolean b0 = index[0]+del < data[0].length;
            boolean b1 = index[1]+del < data[1].length;
            if(!b0) {
                index[1]+=del;
                index[3] = 1;
            } else if(!b1) {
                index[0]+=del;
                index[3] = 0;
            } else {
                if(data[0][index[0]+del]<=data[1][index[1]+del]) {
                    index[0]+=del;
                    index[3] = 0;
                } else {
                    index[1]+=del;
                    index[3] = 1;
                }
            }

        } else {
            index[dataIndex]+=del;
            index[3] = dataIndex;
        }

    }
}
