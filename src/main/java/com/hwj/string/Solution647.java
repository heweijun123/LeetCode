package com.hwj.string;

import java.util.HashMap;
import java.util.Map;

public class Solution647 {

    public int countSubstrings(String s) {

        int rtn = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            //以chars[i]为中心点找出所有奇数长度的回文子串
            int begin = i, end = i;
            while (begin >= 0 && end < chars.length && chars[begin] == chars[end]) {

                begin--;
                end++;
                rtn++;
            }
            //以chars[i]为左中心点找出所有偶数长度的回文子串
            int begin2=i,end2=i+1;
            while(begin2>=0&&end2<chars.length && chars[begin2]==chars[end2]) {

                begin2--;
                end2++;
                rtn++;
            }
        }
        return rtn;
    }

}

