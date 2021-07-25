package com.hwj.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Solution217 {

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i]))
                return true;
            map.put(nums[i],null);
        }
        return false;
    }
}
