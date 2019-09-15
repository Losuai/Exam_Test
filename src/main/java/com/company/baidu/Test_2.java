package com.company.baidu;

import java.util.Scanner;

public class Test_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k =scanner.nextInt();
        System.out.println(find(n, k));
    }
    public static int find(int n, int k){
        if(n-k < 1) return 1;
        int count = 0;
        if((n-k) % 2 == 0 && (n-k) / 2 >0){
            count += find((n-k) / 2 , k);
            count += find(n - ((n-k) / 2), k);
        }else{
            count++;
        }
        return count;
    }
}
