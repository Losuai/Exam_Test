package com.company.data.sort;
//快速排序算法：
//原理：选择一个数组值作为基准，从数组两边开始遍历整个数组，我们选取一个基准值，从右侧开始遍历，找到小于基准的数，就替换掉基准位的值，
// 接下来从左开始遍历，找到大于基准的值，就填补右侧之前替换掉基准位的值的位置空缺，左右的遍历依次交换进行，直到左右两个遍历相遇，将基准值放入相遇的位置。
// 此时左侧全部为小于基准的值，右侧全为大于基准的值。之后对于前后段的排序也递归采用前面的方式，直到排序结束。


public class Quick_Sort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 4, 3, 2, 1};
        quickSort(a, 0, a.length - 1);
        for (int item : a) {
            System.out.print(item + " ");
        }
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        int key = a[start];
        while (i < j) {
            while (i < j && a[j] > key) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < key) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = key;
        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);
    }
}
