package com.company.exam.tenxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//题目描述：
//        某校在积极推行无人监考制度，但是总有学生是不自觉的，如果将两个很熟的异性朋友放在同一个考场里，他们就会交流甚至作弊。因此一个考场中不能允许两个很熟的异性朋友存在，学校希望通过搬出一部分学生的方法来改善这一问题。
//
//        但是又因为教室数量有限，因此希望一个教室中容下的学生尽可能多，即需要搬出教室的学生数量尽可能少，请你输出搬出教室人数最少，且字典序最小的方案。
//
//        输入
//        输入第一行有两个整数n和m，分别表示有n个男生和n个女生，有m个朋友关系。
//
//        (1<=n<=500,1<=m<=100000)
//
//        接下来m行，每行有两个整数，x和y，表示第x号男生和第y号女生是朋友。男生的编号均为[1,n]，女生的编号为[n+1,2n]。
//
//        输出
//        输出第一行包含一个整数a，表示最少需要搬出教室的人数。
//
//        输出第二行有a个整数，即a个需要搬出教室的人的编号，要求人数最少，且字典序最小。
//
//
//        样例输入
//        2 2
//        3 1
//        1 4
//        样例输出
//        1
//        1
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] boy = new int[m];
        int[] girl = new int[m];
        for(int i=0; i<m; i++){
            boy[i] = sc.nextInt();
            girl[i] = sc.nextInt();
        }
        result(boy, girl, m);

    }
    public static void result(int[] boy, int[] girl, int m){
        Arrays.sort(boy);
        Arrays.sort(girl);
        int max_b = 1;
        int max_g = 1;
        List<Integer> boyList = new ArrayList<>();
        boyList.add(boy[0]);
        List<Integer> girlList = new ArrayList<>();
        girlList.add(girl[0]);
        for(int i=1; i<m; i++){
            if(boy[i] != boy[i-1]){
                max_b++;
                boyList.add(boy[i]);
            }
            if(girl[i] != girl[i-1]){
                max_g++;
                girlList.add(girl[i]);
            }
        }
        if(max_b > max_g){
            System.out.println(max_g);
            girlList.forEach(System.out::println);
        }else {
            System.out.println(max_b);
            boyList.forEach(System.out::println);
        }
    }
}
