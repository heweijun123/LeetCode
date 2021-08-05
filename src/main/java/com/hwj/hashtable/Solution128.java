package com.hwj.hashtable;

import java.util.*;

public class Solution128 {

    public int longestConsecutive(int[] nums) {

        int maxLength=0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {

            int length;
            int pre = nums[i] - 1;
            while(set.remove(pre)) {

                pre--;
            }
            int next = nums[i]+1;
            while(set.remove(next)) {

                next++;
            }
            length = next-pre-1;
            maxLength = Math.max(length, maxLength);
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
