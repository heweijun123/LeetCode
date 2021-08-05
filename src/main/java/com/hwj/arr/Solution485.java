package com.hwj.arr;

public class Solution485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int rtn=0,count = 0;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]==0) {

                rtn = Math.max(rtn,count);
                count=0;
            }else {

                count+=nums[i];
            }
        }
        rtn = Math.max(rtn,count);
        return rtn;
    }
}
