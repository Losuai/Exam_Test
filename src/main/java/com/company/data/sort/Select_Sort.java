package com.company.data.sort;

//简单选择排序核心思想：
// 首先在未排序序列中找到最小的元素，存放到排序序列的起始位置，然后，再从剩余未排序的元素中寻找最小的元素，放到排序序列起始位之后。依次类推，直到所有的元素均排序完毕。
public class Select_Sort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        for (int item : selectSort(a)) {
            System.out.print(item + " ");
        }
    }

    public static int[] selectSort(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int currMin = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < currMin) {
                    int temp = a[j];
                    a[j] = currMin;
                    currMin = temp;
                }
            }
            a[i] = currMin;
            count++;
        }
        System.out.println(count);
        return a;
    }
}
