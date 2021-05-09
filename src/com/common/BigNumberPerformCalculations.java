package com.common;

/**
 * @Description: 大数四则运算
 * @Author:qixian
 * @Date: 2021/4/22 10:08 下午
 * @Version: v1.0.0
 */
public class BigNumberPerformCalculations {


    public static void main(String[] args) {
//        System.out.println(subtract("29", "93"));
        System.out.println(add("99", "99"));
    }

    /**
     *  两个正大数相减， 主要考虑 借位相减的问题
     * @param n1
     * @param n2
     * @return
     */
    public static String subtract(String n1, String n2) {
        /* 负号 */
        String nounFlag = "";
        int len1 = n1.length();
        int len2 = n2.length();
        // 若 n1 < n2 , 这符号就是负的， 保证 n1 比 n2 大
        if ((len1 == len2 && n1.compareTo(n2) < 0) || len1 < len2) {
            nounFlag = "-";
            String temp = n1;
            n1 = n2;
            n2 = temp;
        }
        // 给 n2 补齐0 长度， 使他们的长度是一致的
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            n2 = '0' + n2;
        }

        StringBuilder result = new StringBuilder();
        int w = 0;
        for (int i = n1.length() - 1; i >= 0; i--) {
            // 计算每一个w位置上的差，再加上错位的 值  w
            int c = n1.charAt(i) - n2.charAt(i) + w;
            // 若 c  小于 0, 说明需要 借位，c += 10, 然后 w = -1,  否者 借位 = 0
            if (c < 0) {
                c += 10;
                w = -1;
            } else {
                w = 0;
            }
            result.append(c);
        }

        StringBuilder returnResult = new StringBuilder(nounFlag);
        returnResult.append(result.reverse());

        return returnResult.toString();
    }


    /**
     * 两正 大数相加
     * @param n1
     * @param n2
     * @return
     */
    public static String add(String n1, String n2) {
        if (n1 == null || n1.length() == 0) {
            return n2;
        }
        if (n2 == null || n2.length() == 0) {
            return n1;
        }
        int len1 = n1.length();
        int len2 = n2.length();
        // 将最大的数，都用n1 表示
        if (len1 < len2) {
            String temp = n1;
            n1 = n2;
            n2 = temp;
        }
        // 将两个数的长度，补齐一致
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            n2 = '0' + n2;
        }

        StringBuilder result = new StringBuilder();
        int w = 0;
        for (int i = n1.length() - 1; i >= 0; i--) {
            // 字符 减去 48 变成 int 类型， 两个则减去96
            int c = n1.charAt(i) + n2.charAt(i) - 96 + w;
            if (c > 10) {
                w = c / 10;
                c = c % 10;
            } else {
                w = 0;
            }
            result.append(c);
        }
        // 判断是否还有进位，若有，则需要加上
        if (w != 0) {
            result.append(w);
        }

        StringBuilder returnResult = new StringBuilder();
        returnResult.append(result.reverse());
        return returnResult.toString();
    }

    /**
     * 大数相乘： 模拟人工计算， 把一个数拆分出来，然后进行一个一个处理，累加
     * 如： 123 * 45 = 123 * 40 + 123 * 5
     * @param n1
     * @param n2
     * @return
     */
    public static String muilt(String n1, String n2) {
        String result = "";
        // 把 n2 字符串拆成一个一个的
        for (int i = 0; i < n2.length() -1; i++) {
            String temp = per(n1, n2.charAt(i));
            result = add(result, add_0(temp, n2.length() - 1 -i));
        }
        return result;
    }

    public static String per(String n1, char c) {
        int n = c - '0';
        String result = "";
        int w = 0;
        for (int i = n1.length() - 1; i >= 0; i--) {
            // 计算当前的积
            int m = (n1.charAt(i) - '0') * n + w;
            w = m / 10;
            result = m % 10 + result;
        }
        if (w != 0) {
            result = w + result;
        }
        return result;
    }

    public static String add_0(String temp, int i) {
        for (int j = 0; j < i; j++) {
            temp = temp + '0';
        }
        return temp;
    }
}
