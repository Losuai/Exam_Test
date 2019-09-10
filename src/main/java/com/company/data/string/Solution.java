package com.company.data.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<String>> lists1 = partition1("aad");
        List<List<String>> lists2 = partition("aad");
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s,  new ArrayList<String>());
        return res;
    }

    private static void backtrack(List<List<String>> res, String s, ArrayList<String> tmp) {
        if (s == null || s.length() == 0) res.add(new ArrayList<>(tmp));
        for (int i = 1; i <= s.length(); i++) {
               if (isPalidrome(s.substring(0, i))) {
                // System.out.println(s.substring(0, i));
                tmp.add(s.substring(0, i));
                backtrack(res, s.substring(i, s.length()), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private static boolean isPalidrome(String sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
    public static List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) dp[j][i] = true;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        dfs(res, dp, 0, n, s, new ArrayList<String>());
        return res;

    }

    private static void dfs(List<List<String>> res, boolean[][] dp, int i, int n, String s, ArrayList<String> tmp) {
        if (i == n) res.add(new ArrayList<>(tmp));
        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                tmp.add(s.substring(i, j + 1));
                dfs(res, dp, j + 1, n, s, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
