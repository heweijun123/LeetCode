package com.hwj.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution128 {

    public int longestConsecutive(int[] nums) {

        int maxLength=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            Integer cur = map.get(nums[i]);
            if(cur!=null)
                continue;
            Integer pre = map.get(nums[i] - 1);
            Integer next = map.get(nums[i] + 1);
            int length =1;
            if(pre!=null) {

                length=length+pre;
            }
            if(next!=null){

                length=length+next;
            }
            if(pre!=null) {

                map.put(nums[i]-1,length);
            }
            if(next!=null){

                map.put(nums[i]+1,length);
            }
            map.put(nums[i],length);
            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        int[] a = new int[]{0,3,7,2,5,8,4,6,0,1};
        Solution128 solution = new Solution128();
        int i = solution.longestConsecutive(a);
        System.out.println(i);
    }
}
