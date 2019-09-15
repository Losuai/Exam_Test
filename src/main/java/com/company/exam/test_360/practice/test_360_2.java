package com.company.exam.test_360.practice;

import java.util.Scanner;

public class test_360_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            s[i] = sc.nextInt();
        }
        int sum = 0;
        int rs = -1;
        if (N > 2) {
            for (int j = 0; j < N; j++) {
                sum += s[j];
                if (j + 1 <= N && sum >= s[j + 1]) {
                    rs = j + 1 + 1;
                    System.out.println(rs + "  sdf");
                    break;
                }
            }
        }
        System.out.println(rs);
    }
}
