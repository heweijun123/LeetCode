package com.hwj.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution594 {

    //遍历两次循环
    public int findLHS(int[] nums) {

        int maxLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            int equal_num = 1, gnum = 0, lnum = 0;
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] == nums[i])
                    equal_num++;
                if (nums[j] - nums[i] == 1)
                    gnum++;
                if (nums[i] - nums[j] == 1)
                    lnum++;
            }
            int length = 0;
            if (gnum != 0 || lnum != 0)
                length = equal_num + gnum > equal_num + lnum ? equal_num + gnum : equal_num + lnum;
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength;
    }

    //先排序，后运用双指针
    public int findLHS2(int[] nums) {

        //排序
        Arrays.sort(nums);

        int res=0,begin=0;
        for (int end = 0; end < nums.length; end++) {

            while(nums[end]-nums[begin]>1)
                begin++;

            if(nums[end]-nums[begin]==1) {

                 res = Math.max(end - begin + 1, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] data = new int[8];
        data[0] = 1;
        data[1] = 3;
        data[2] = 2;
        data[3] = 2;
        data[4] = 5;
        data[5] = 2;
        data[6] = 3;
        data[7] = 7;
        Solution594 solution594 = new Solution594();
        solution594.findLHS(data);
    }
}
