package com.company.data.sort;
//希尔排序的算法思想：将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
// 每次将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。


public class Shell_Sort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 32, 46, 73, 2, 2, 0};
        for (int item : shellSort(a)) {
            System.out.print(item + " ");
        }
    }

    public static int[] shellSort(int[] a) {
        int gap = a.length / 2, count = 0;
        while (gap >= 1) {
            for (int i = gap; i < a.length; i++) {//分组
                for (int j = i - gap; j >= 0; j--) {//组内直接插入排序
                    if (a[j] > a[j + gap]) {
                        int temp = a[j];
                        a[j] = a[j + gap];
                        a[j + gap] = temp;
                    }
                }
            }
            gap = gap / 2;
            count++;
        }
        System.out.println(count);
        return a;
    }
}
