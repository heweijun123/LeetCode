package com.hwj.string;

import java.util.HashMap;
import java.util.Map;

public class Solution696 {

    public int countBinarySubstrings(String s) {

        int rtn =0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int begin=i,end=i+1;
            while(begin>=0&& end<chars.length && chars[begin]!=chars[end]) {

                if(end-begin>1 && (chars[begin]!=chars[begin+1] || chars[end]!=chars[end-1]))
                    break;
                rtn++;
                begin--;
                end++;
            }
        }
        return rtn;
    }
}

