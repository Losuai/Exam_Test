package com.company.data.string;

import java.util.*;

public class WordsSplit {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak("leetcode", list);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet<>(wordDict), 0);
    }

    public static boolean word_Break(String s, Set<String> wordDict, int start){
        if (start == s.length()) return true;
        for (int end = start+1; end <= s.length(); end++){
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) return true;
        }
        return false;
    }
}
