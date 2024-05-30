package com.liuweiTest;

import java.util.LinkedList;

public class CharacterTest2 {

    public static String replaceString(String s) {
        LinkedList<Character> list = new LinkedList<>();
        
        // 将字符串转换为字符链表
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        boolean replaced;
        do {
            replaced = false;
            LinkedList<Character> newList = new LinkedList<>();
            int i = 0;
            while (i < list.size()) {
                char current = list.get(i);
                int count = 1;
                
                // 计算当前字符连续出现的次数
                while (i + count < list.size() && list.get(i + count) == current) {
                    count++;
                }
                
                // 如果连续出现的字符数大于或等于3，则替换
                if (count >= 3) {
                    newList.add((char) (current - 1));
                    i += count;
                    replaced = true;
                } else {
                    for (int j = 0; j < count; j++) {
                        newList.add(current);
                    }
                    i += count;
                }
            }
            if (replaced) {
                // 打印替换后的结果
                System.out.println("-> " + listToString(newList));
                list = newList;
            }
        } while (replaced);

        // 最终结果
        return listToString(list);
    }

    // 辅助方法，将 LinkedList<Character> 转换为字符串
    private static String listToString(LinkedList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcccbad";
        System.out.println("Input: " + str);
        System.out.println("Output:");
        String result = replaceString(str);
        System.out.println("-> " + result);
    }
}