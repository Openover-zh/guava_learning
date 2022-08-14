package com.zhang.splitAndJoiner;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 一个使用分隔符连接文本片段（指定为数组、 Iterable 、可变参数甚至是Map ）的对象。它将结果附加到Appendable或将它们作为String返回。例子：
 *  Joiner joiner = Joiner.on("; ").skipNulls();   . . .  return joiner.join("Harry", null, "Ron", "Hermione");
 * 这将返回字符串"Harry; Ron; Hermione" 。请注意，在追加之前，所有输入元素都使用Object.toString()转换为字符串。
 * 如果既没有skipNulls()也没有指定useForNull(String) ，如果任何给定元素为 null，则连接方法将抛出NullPointerException 。
 * 警告：joiner 实例总是不可变的；诸如useForNull类的配置方法对调用它的实例没有影响！您必须存储和使用该方法返回的新连接器实例。
 * 这使得连接器是线程安全的，并且可以安全地存储为static final常量。
 *  // Bad! Do not do this!
 *  Joiner joiner = Joiner.on(',');
 *  joiner.skipNulls(); // does nothing!
 *  return joiner.join("wrong", null, "wrong");
 * @author zhangJiaHao
 * @date 2022/8/14 15:10
 */
public class JoinerDemo {
    /*
        根据逗号进行分隔,skipNulls方法跳过为null的值
     */
    private static final Joiner joiner = Joiner.on(",").skipNulls();
    /*
    根据逗号分隔 将null值替换为""空字符串
     */
    private static final Joiner joinerNullToStr = Joiner.on(",").useForNull("");

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", null, "3", "4");
        System.out.println(appendTo(list,new StringBuilder(),joiner)); // 追加字符串
        System.out.println(getJoinerStr(list,joiner)); // 根据joiner分隔集合元素
        System.out.println(getJoinerStr(list,joinerNullToStr)); // 将null替换为""
        System.out.println(appendTo(list,new StringBuilder(),joinerNullToStr)); //将null替换为""
    }

    /**
     * 获取分割后的字符串
     * @param list
     * @param joiner
     * @return
     */
    private static String getJoinerStr(List<String> list,Joiner joiner){
        return joiner.join(list);
    }

    /**
     * 获取拼接后的字符串
     * @param list
     * @param builder
     * @param joiner
     * @return
     */
    private  static String appendTo(List<String> list,StringBuilder builder,Joiner joiner){
        // appendTo方法追加字符串
        joiner.appendTo(builder,list);
        return builder.toString();
    }
}
