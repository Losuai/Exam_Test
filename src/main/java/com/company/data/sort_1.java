package com.company.data;

public class sort_1 {
    public static void main(String[] args) {
        String m = "1flower";
        String n = "flow";
        System.out.println(m.indexOf(n));
       // System.out.println(lengthOfLongestSubstring("as"));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int count = 1;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<ch.length; i++){
            char temp = ch[i];
            int j=i;
            while(i>0){
                if(temp != ch[i-1]){
                    count++;
                    i--;
                }else {
                    break;
                }
            }
            i=j;
            max = Math.max(max, count);
        }
        return max;
    }
}
