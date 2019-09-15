package com.company.exam.beike;

import java.util.Arrays;
import java.util.Scanner;

//题目描述：
//        小C在做一种特殊的服务器负载测试，对于一个请求队列中的请求，每一个请求都有一个负荷值，为了保证服务器稳定，
//        请求队列中的请求负荷必须按照先递增后递减的规律(仅递增，仅递减也可以)，比如[ 1，2，8，4，3 ]，[ 1，3，5 ]和[ 10 ]这些是满足规律的，
//        还有一些不满足的，比如[ 1，2，2，1 ]，[ 2，1，2 ]和[ 10，10 ]。现在给你一个请求队列，你可以对请求的负荷值进行增加，要求你调整队列中请求的负荷值，
//        使数组满足条件。最后输出使队列满足条件最小的增加总和。
//
//        输入
//        输入有两行，第一行是N (1≤n≤5000) ，代表请求队列中的请求数量。
//
//        第二行有N个数字 a1,a2…an  (1≤ai≤10^9)。Ai是第i个请求的负荷值。
//
//        输出
//        输出这个最小增加总和
//
//
//        样例输入
//        5
//        1 4 3 2 5
//        样例输出
//        6
//
//        提示
//        样例解释，此时合法队列为[1,4,5,6,5]，最小增加和为6
public class Beike_test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(minSum(N, num));
    }

    public static long minSum(int n ,long[] nums) {
        if(n == 1)
            return 0;
        if(n == 2 && nums[0] == nums[1])
            return 1;
        if(n == 2 && nums[0] != nums[1])
            return 0;

        long[] temp = Arrays.copyOf(nums, n);

        int i = 0;
        while(i < n-1 && nums[i] < nums[i+1])
            i++;
        int j = n-1;
        while(j > 0 && nums[j] < nums[j-1])
            j--;

        while(i < j) {
            if(nums[i] < nums[j]) {
                if(nums[i+1] < nums[i]+1)
                nums[i+1] = nums[i] +  1;
                i++;
            } else {
                if(nums[j-1] < nums[j]+1)
                nums[j-1] = nums[j]+1;
                j--;
            }
        }
        return Arrays.stream(nums).sum() - Arrays.stream(temp).sum();
    }


}
