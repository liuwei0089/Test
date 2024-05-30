package com.liuweiTest;

import java.util.LinkedList;

public class CharacterTest1 {
    static class CharCount {
        char ch;
        int count;

        CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String removeThreeChar(String s) {
        // 用于存储字符及其计数的链表
        LinkedList<CharCount> list = new LinkedList<>();

        // 遍历输入字符串的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 获取当前字符
            char currentChar = s.charAt(i);
            // 如果链表不为空且最后一个字符与当前字符相同
            if (!list.isEmpty() && list.getLast().ch == currentChar) {
                // 增加最后一个字符的计数
                list.getLast().count++;
                // 如果计数达到3
                if (list.getLast().count == 3) {
                    // 从链表中移除该字符
                    list.removeLast();
                }
            } else {
                // 如果字符不同，则将新字符及其计数1添加到链表
                list.add(new CharCount(currentChar, 1));
            }
        }
        // 用于构建最终结果字符串
        StringBuilder result = new StringBuilder();
        // 遍历链表，根据字符的计数构建结果字符串
        for (CharCount charCount : list) {
            for (int j = 0; j < charCount.count; j++) {
                result.append(charCount.ch);
            }
        }
        // 返回最终结果字符串
        return result.toString();
    }
    public static void main(String[] args) {
        // 测试用例
        String str1 = "aaabbbc";
        System.out.println(removeThreeChar(str1));

        String str2 = "aabbccddeeee";
        System.out.println(removeThreeChar(str2));

        String str3 = "aaaabbbbcccc";
        System.out.println(removeThreeChar(str3));

        String str4 = "aaaabbbaac";
        System.out.println(removeThreeChar(str4));
    }
}
