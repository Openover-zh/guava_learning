package com.zhang.splitAndJoiner;

import com.google.common.base.CharMatcher;

/**
 * 字符串匹配器
 * @author zhangJiaHao
 * @date 2022/8/14 16:15
 */
public class CharMatcherDemo {
    // 匹配所有的*号或者空格
    public static final CharMatcher charMatcher = CharMatcher.is('*').or(CharMatcher.whitespace());
    public static final CharMatcher ab = CharMatcher.anyOf("ab");
    public static void main(String[] args) {
        String s = "*123 28**4.*";
        System.out.println(charMatcher.removeFrom(s)); // 123284. removeFrom从字符串中去除匹配的字符
        System.out.println(charMatcher.collapseFrom(s,'-')); // -123-28-4.-  collapseFrom将所有连续匹配的字符替换为一个'-'
        System.out.println(charMatcher.replaceFrom(s,"-")); // -123-28--4.-  replaceFrom将所有匹配的字符替换为'-'
        System.out.println(charMatcher.retainFrom(s)); // * ***  只获取所有匹配的字符
        System.out.println(charMatcher.trimFrom(s)); // 去除前面和后面匹配的字符

        String p = "abgfbdagab";
        System.out.println(ab.removeFrom(p)); // 删除所有的a或者b
    }
}
