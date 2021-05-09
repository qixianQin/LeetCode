package com.simple;

/**
 * @Description: 反转字符串
 * @Author:qixian
 * @Date: 2021/4/25 9:12 下午
 * @Version: v1.0.0
 */
public class ReverStr {


    public static void main(String[] args) {
        System.out.println(rever("I am a boy."));
        System.out.println(reverseStr("I am a boy."));
    }

    public static String rever(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        int lastIndex = str.length();
        for (int i = str.length() - 1; i >=0; i--) {
            if (str.charAt(i) == ' ') {
                result.append(str.substring(i, lastIndex));
                result.append(' ');
                lastIndex = i + 1;
            }
        }

        return result.toString();

    }

    public  static void swap(char[] ch,int a,int b) {
        char tmp;
        for(;a < b;a++,b--) {
            tmp = ch[a];
            ch[a] = ch[b];
            ch[b] = tmp;
        }
    }

    public static String reverseStr(String str) {
        char[] chars = str.toCharArray();
        swap(chars,0,chars.length-1);
        int start = 0;
        for(int i = 1;i < chars.length;i++) {
            if(chars[i] == ' ') {
                swap(chars,start,i-1);
                start = i+1;
            }
        }
        return String.valueOf(chars);
    }


}
