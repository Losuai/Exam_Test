package com.company.exam.test_360.practice;

import java.util.Scanner;

public class Test_360_1 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] x = new long[N];
        long[] y = new long[N];
        long x_max = 0, x_min = 0, y_max = 0, y_min = 0;
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
            if (i == 0) {
                x_max = x_min = x[0];
                y_max = y_min = y[0];
            } else {
                if (x[i] > x_max) x_max = x[i];
                if (x[i] < x_min) x_min = x[i];
                if (y[i] > y_max) y_max = y[i];
                if (y[i] < y_min) y_min = y[i];
            }
        }
        long max1, max2, max;
        if (x_max >= 0 && x_min >= 0) {
            max1 = x_max - x_min;
        } else if (x_min < 0 && x_max < 0) {
            max1 = x_min - x_max;
        }else{
            max1 = x_max - x_min;
        }
        if (y_max >= 0 && y_min >= 0) {
            max2 = y_max - y_min;
        } else if (y_min < 0 && y_max < 0) {
            max2 = y_min - y_max;
        } else {
            max2 = y_max - y_min;
        }
        max = Math.max(Math.abs(max1), Math.abs(max2));
        System.out.println(max * max);
    }
}
