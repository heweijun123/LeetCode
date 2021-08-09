package com.hwj.arr;

public class Solution645 {

    public int[] findErrorNums(int[] nums) {

        int[] rtn = new int[2];
        int[] tmp = new int[nums.length + 1];
        for(int val:nums) {

            tmp[val]++;
        }
        for (int i = 1; i < tmp.length; i++) {

            if(tmp[i]==2) {

                rtn[0]=i;
            }
            if(tmp[i]==0) {

                rtn[1]=i;
            }
        }
        return rtn;
    }
}
