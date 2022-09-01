package com.jason.leetcode;

/**
 * @author jason
 * @date 2022/8/31
 */
public class _13_RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 循环查询对应结果的时候, 如果下一个大于自己1或2个位置, 并且自己是1,10之类的.需要做特殊计算.
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        char[] symbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        int rtn = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j] == c) {
                    if (j%2 == 0 && i < s.length() - 1 && j < symbols.length - 1 && symbols[j+1] == s.charAt(i+1)) {
                        rtn += value[j + 1] - value[j];
                        i++;
                    } else if (j%2 == 0 && i < s.length() - 1 && j < symbols.length - 2 && symbols[j+2] == s.charAt(i+1)) {
                        rtn += value[j + 2] - value[j];
                        i++;
                    } else {
                        rtn += value[j];
                    }
                    break;
                }
            }
        }
        return rtn;
    }
}
