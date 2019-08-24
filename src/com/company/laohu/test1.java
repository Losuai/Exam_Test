package com.company.laohu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

    }
    //合并k个排序链表
    // 方法 1：暴力
    //遍历所有链表，将所有节点的值放到一个数组中。
    //将这个数组排序，然后遍历所有元素得到正确顺序的值。
    //用遍历得到的值，创建一个新的有序链表。
    public static ListNode merge1(ListNode[] lists){
        ListNode rs = new ListNode(0);
        ListNode p = rs;
        List<Integer> resList = new ArrayList<>();
        for(ListNode node: lists){
            while(node != null){
                resList.add(node.val);
                node=node.next;
            }
        }
        Collections.sort(resList);
        for(int i: resList){
            p.next = new ListNode(i);
            p = p.next;
        }
        return rs.next;
    }
    public static ListNode merge2(ListNode[] lists){
        ListNode rs = new ListNode(0);
        ListNode p = rs;
        while(true){
            int min = Integer.MAX_VALUE;
            int position = 0;
            for(int i=0; i<lists.length; i++){
                if(lists[i] != null){
                    if(min > lists[i].val){
                        min = lists[i].val;
                        position = i;
                    }
                }
            }
            if(min ==Integer.MAX_VALUE) break;
            p.next = new ListNode(min);
            p = p.next;
            lists[position] = lists[position].next;
        }
        return rs.next;
    }

    public static ListNode merge3(ListNode[] lists){
        ListNode head = new ListNode(0);
        ListNode point = head;
        for(ListNode node:lists){
            point.next=mergeTwoLists(point.next, node);
        }
        return head.next;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


}
