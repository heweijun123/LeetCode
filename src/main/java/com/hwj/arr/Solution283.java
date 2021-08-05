package com.hwj.arr;

import java.util.HashMap;
import java.util.Map;

public class Solution283 {

    public void moveZeroes(int[] nums) {

        int j=0;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]!=0) {

                nums[j++]=nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {

            nums[i]=0;
        }
    }

    private void swap(int[] nums, int a, int b) {

        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
