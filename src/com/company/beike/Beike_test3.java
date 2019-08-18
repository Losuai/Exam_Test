package com.company.beike;

import java.util.Arrays;
import java.util.Scanner;

//题目描述：
//        举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
//
//        输入
//        第一行N，表示参赛人数（2<=N<=10^5）
//
//        第二行N个正整数表示体重（0<体重<=10^8）
//
//        输出
//        一个数，表示最多能进行的比赛场数
//
//
//        样例输入
//        5
//        1 1 1 1 1
//        样例输出
//        10

public class Beike_test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        int count = 0;
        Arrays.sort(num);
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(num[i] < num[j]*0.9) count++;
            }
        }
        System.out.println(((N-1)*N)/2 - count);

    }
}
