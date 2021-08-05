package com.hwj.string;

import java.util.HashMap;
import java.util.Map;

public class Solution409 {

    public int longestPalindrome(String s) {

        int r_count=0;
        Map<Character, Object> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if(map.containsKey(chars[i])) {

                map.remove(chars[i]);
                r_count++;
            }else {

                map.put(chars[i],null);
            }
        }
        if(r_count==0 && map.size()!=1)
            return 1;
        if(map.size()==0)
            return r_count*2;
        return r_count*2+1;
    }

    public int longestPalindrome2(String s) {

        int rtn =0;
        char[] chars = s.toCharArray();
        int[] arr = new int[58];
        for (int i = 0; i < chars.length; i++) {

            arr[chars[i] - 'A']++;
        }

        for(int c:arr) {

            rtn+=c/2*2;
            if(rtn %2==0 && c %2==1)
                rtn+=1;
        }
        return rtn;
    }

}

