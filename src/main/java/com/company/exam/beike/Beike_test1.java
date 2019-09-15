package com.company.exam.beike;

import java.util.Scanner;

//给出n个正整数，要求找出相邻两个数字中差的绝对值最小的一对数字，如果有差的绝对值相同的，则输出最前面的一对数。
//
//        2<n<=100，正整数都在10^16范围内
//
//        输入
//        输入包含2行，第一行为n，第二行是n个用空格分隔的正整数。
//
//        输出
//        输出包含一行两个正整数，要求按照原来的顺序输出
//
//
//        样例输入
//        9
//        1 3 4 7 2 6 5 12 32
//        样例输出
//        3 4

public class Beike_test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] m = new long[n];
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextLong();
        }
        long[] rs = find(n, m);
        System.out.println(rs[0] + " " + rs[1]);
    }

    public static long[] find(int n, long[] nums) {
        if (nums.length == 0 || n < 2)
            return new long[]{};
        long[] rs = new long[2];
        long min = Long.MAX_VALUE;
        for (int i = n - 1; i > 0; i--) {
            long temp = Math.abs((nums[i] - nums[i-1]));
            if(temp <= min){
                min = temp;
                rs[0] = nums[i-1];
                rs[1] = nums[i];
            }
        }
        return rs;
    }
}
