package com.hwj.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution205 {

    public boolean isIsomorphic(String s, String t) {

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {

            if(map.containsKey(chars1[i])) {

                if(!Objects.equals(map.get(chars1[i]),chars2[i]))
                    return false;
            }else {

                if(map.containsValue(chars2[i]))
                    return false;
            }
            map.put(chars1[i],chars2[i]);
        }
        return true;
    }
}

