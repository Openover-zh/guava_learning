package com.zhang.splitAndJoiner;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * @author zhangJiaHao
 * @date 2022/8/14 15:46
 */
public class SplitterDemo {
    /**
     * 根据,逗号进行分隔
     * omitEmptyStrings 忽略空的字符串
     * trimResults 忽略前后空格
     */
    public static final Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
    public static void main(String[] args) {
        String s = "1,2,,3,4,";
        List<String> strings = splitToList(s);
        System.out.println(strings);
        for (String string : strings) {
            System.out.println(string);
        }
        // 将字符串以:分隔为map
        String p = "zhang:25,li:13,oo:23";
        Map<String, String> map = splitToMap(p);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

    }

    /**
     * 分隔字符串返回list
     * @param s
     * @return
     */
    private static List<String> splitToList(String s){
        return splitter.splitToList(s);
    }

    /**
     * 将字符串分割为map
     * @param s - 传入的字符串
     * @return
     */
    private static Map<String,String> splitToMap(String s){
        Splitter.MapSplitter mapSplitter = splitter.withKeyValueSeparator(":");
        return mapSplitter.split(s);
    }
}
