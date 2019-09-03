package com.company.data.sort;

//归并排序算法：
//原理：首先使用分割法将这个序列分割成一个一个已经排好了序的子序列，然后利用归并的方法将一个一个的子序列合并成排好的序列
public class Merge_Sort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 3, 8, 0, 1};
        sort(a);
        for (int item : a) {
            System.out.print(item + " ");
        }
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        //在排序前，先建好一个长度等于原数组长度的临时数组，
        //避免递归中频繁开辟空间
        margeSort(arr, 0, arr.length - 1, temp);
    }

    public static void margeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            margeSort(arr, left, mid, temp);
            //左边归并排序，使得左子序列有序
            margeSort(arr, mid + 1, right, temp);
            //右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);
            //将两个有序子数组合并操作
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
