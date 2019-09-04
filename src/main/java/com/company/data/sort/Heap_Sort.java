package com.company.data.sort;

public class Heap_Sort {
    static int len;
    public static void main(String[] args) {
        int[] N = new int[]{1,4,2,6,7,4,2,2,3,7,6};
        len = N.length;
        buildMaxHeap(N);
        while (len > 0){
            swap(N, 0, len-1);
            len--;
            buildMaxHeap(N);
        }
        for (int n:N) {
            System.out.print(n+" ");
        }
    }
    public static void buildMaxHeap(int[] array){
        for(int i=(len/2-1) ;i>=0; i--){
            adjustHeap(array, i);
        }
    }
    public static void adjustHeap(int[] array, int i){
        int maxIndex = i;
        if(2*i < len && array[2*i] > array[maxIndex]){
            maxIndex = 2*i;
        }
        if((2*i+1) < len && array[2*i+1] > array[maxIndex]){
            maxIndex = 2*i+1;
        }
        if(maxIndex != i){
            swap(array, i, maxIndex);
            adjustHeap(array, maxIndex);
        }
    }
    public static void swap(int[] array, int i, int maxIndex){
        int temp = array[i];
        array[i] = array[maxIndex];
        array[maxIndex] = temp;
    }
}
