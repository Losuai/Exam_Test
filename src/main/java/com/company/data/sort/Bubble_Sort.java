package com.company.data.sort;
//冒泡排序
//实现了双层循环，内层循环将相邻两个数进行两两比较，将最大的一个数以冒泡（两两交换）的形式传送最队尾，一次只能将一个最大值传送到队尾；
//而外层循环实现了依次将当前最大值传送，最终实现排序；

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0};
        for (int item : bubbleSort(a)) {
            System.out.print(item + " ");
        }
    }

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
//对于每一轮交换，都将序列当中的左右元素进行比较
//每轮交换当中，由于序列最后的元素一定是最大的，因此每轮循环到序列未排序的位置即可
            for (int j = 0; j < a.length - i - 1; j++) {//
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
