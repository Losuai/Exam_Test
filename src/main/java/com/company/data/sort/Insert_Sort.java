package com.company.data.sort;
//直接排序：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过
//当对位置 i 处的元素进行排序时，[0,i-1]上的元素一定是已经有序的了。


public class Insert_Sort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1};
        for (int item : insertSort(a)) {
            System.out.print(item + " ");
        }
    }

    public static int[] insertSort(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                count++;
            }
        }
        System.out.println(count);
        return a;
    }

}
