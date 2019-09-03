package com.company.zijie;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++)
                m[i][j] = sc.nextInt();
        }

    }
    public static int[][] getRs(int n, int[][] m){
        if(n == 1){
            for (int i=1; i<4; i++){
                for (int j=0; j<4; j++){
                      if(m[i][j] == m[i-1][j] && m[i][j] != 0){
                          m[i-1][j] = 2*m[i][j];
                      }
                }
            }
        }
        return null;
    }
}
