package com.liuchang.p2.util;
//导入java util 工具类 用于用户输入的功能类

import java.util.*;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 18/7/2022下午9:14
 */
public class CMUUtility {
    //用户输入的功能对象实例
    //System.in表示用户输入的内容
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @param
     * @return char
     * @Description 用于界面菜单的选择 该方法读取键盘 如果用户键入'1'-'5'中的任意字符 则方法返回
     * 返回值为用户输入的char型字符
     * @author Cc
     * @date 18/7/2022 下午9:25
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误,请重新输入：");
            } else break;
        }
        return c;
    }

    /**
     * @param
     * @return null
     * @Description 从键盘读取一个字符 并将其作为方法的返回值.
     * @author Cc
     * @date 18/7/2022 下午9:26
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * @param
     * @return null
     * @Description 从键盘读取一个长度不超过2位的整数 并将其作为方法的返回值
     * @author Cc
     * @date 18/7/2022 下午9:28
     */
    public static int readInt() {
        int n;
        while (true) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * @param
     * @return null
     * @Description 从键盘读取一个长度不超过2的整数 并将其作为方法的返回值
     * @author Cc
     * @date 18/7/2022 下午9:31
     */
    public static int readInt(int defaultValue) {
        int n;
        while (true) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * @param
     * @return null
     * @Description 从键盘读取一个长度不超过limit的字符串 并将其作为方法的返回值
     * 如果用户不输入字符而直接回车 方法将以defaultValue 作为返回值
     * @author Cc
     * @date 18/7/2022 下午9:33
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    public static String readString(int limit) {
        String str = readKeyBoard(limit, false);
        return str;
    }

    /**
     * @param
     * @return null
     * @Description 用于确认选择的输入 该方法从键盘读取‘Y’或‘N’ 并将其作为方法的返回值
     * @author Cc
     * @date 18/7/2022 下午9:34
     */
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            //转化为char型
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * @param
     * @return null
     * @Description 用于返回用户键入的字符串 判断是否大于键入的长度 并且 判断是否需要识别回车
     * @author Cc
     * @date 18/7/2022 下午9:37
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "或者小于" + limit + ")错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}
