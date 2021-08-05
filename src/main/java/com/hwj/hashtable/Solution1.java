package com.hwj.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        int[] rtn = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])) {

                rtn[1]=i;
                rtn[0]=map.get(nums[i]);
                return rtn;
            }

            //补数作为key放入map中
            map.put(target-nums[i],i);
        }
        return rtn;
    }

}
