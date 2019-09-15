package com.company.exam.beike;

import java.util.Arrays;
import java.util.Scanner;

//题目描述：
//        小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。虽然小希并不知道密码具体是什么，但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列
//        a (-10^9 <= a[i] <= 10^9)的范围内。下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，
//        例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。

//        输入
//        第1行：1个数N，N为序列的长度(2<=N<=50000)
//
//        第2到 N+1行：每行1个数，对应序列的元素(-10^9 <= a[i] <= 10^9)
//
//        输出
//        一个正整数表示严格最长上升子序列的长度
//
//
//        样例输入
//        8
//        5
//        1
//        6
//        8
//        2
//        4
//        5
//        10
//        样例输出
//        5
//参考如下链接的三种方法求出LIS
// https://blog.csdn.net/lxt_Lucia/article/details/81206439
public class Beike_test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextLong();
        }
        long rs = method_2(N, num);
        System.out.println(rs);
    }

    //动态规划，时间复杂度O(n^2)
    public static long method_dp(int N, long[] res) {
        long[] dp = new long[N];
        dp[0] = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < i; j++)
                if (res[j] < res[i])
                    dp[i] = Math.max(dp[j], dp[j] + 1);
        return Arrays.stream(dp).max().orElse(0);
    }

    //贪心+二分，时间复杂度O(nLogn)
    public static long method_2(int N, long[] res) {
        long[] low = new long[N];
        low[0] = res[0];
        int ans = 1;
        for(int i=1; i<N; i++){
            if(res[i] > low[ans]){
                low[++ans] = res[i];
            }else {
                low[binary_search(low, ans)] =  res[i];
            }
        }
        return ans;
    }

    public static int binary_search(long[] res, int ans){
        int l=0, r=res.length, mid;
        while (l < r){
            mid = (l+r) >>> 1;
            if(res[mid] <= ans)
                r = mid;
            else 
                l = mid + 1;
        }
        return l;
    }

}
