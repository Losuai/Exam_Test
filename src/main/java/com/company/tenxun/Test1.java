package com.company.tenxun;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

    }
    //合并两个有序数组


    // 时间复杂度 : O((n + m)log(n + m))。
    //空间复杂度 : O(1)。
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums2, m, n);
        Arrays.sort(nums1);
    }
    //双指针，从后往前，时间复杂度：O(m+n),空间复杂度：O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p1>=0 && p2>=0)
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为p2+1
        System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }
}
