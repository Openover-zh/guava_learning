package com.zhang.collection;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.*;

/**
 * @author zhangJiaHao
 * @date 2022/8/14 20:57
 */
public class ImmutableDemo {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add(null);
//         该视图不是真正意义上的不可变 当原有list发生改变后 unmodifiable也会发生改变
//         只有在没有人持有对原始集合的引用时，返回的集合才是真正不可变的
        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);
//        unmodifiableCollection.add("1"); // throw  UnsupportedOperationException
        System.out.println(unmodifiableCollection.size()); // 1
        list.add("2");
        System.out.println(unmodifiableCollection.size()); // 2


        // guava Immutable示例
//        ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3", "4");
        // 注意 每个 Guava 不可变集合实现都拒绝空值 可以使用Collections2进行过滤
        Collection<String> nonNullList = Collections2.filter(list, Objects::nonNull);
        ImmutableList<String> immutableList = ImmutableList.copyOf(nonNullList);
        System.out.println(immutableList.size()); // 2
        list.add("2");
        System.out.println(immutableList.size()); // 2

        // Immutable其他创建方法
        ImmutableList<String> immutableList1 = ImmutableList.<String>builder()
                .addAll(list)
                .add("999")
                .build();

        ImmutableSet<String> immutableSet = ImmutableSet.of("1", "2", "3", "4");




        // ImmutableMap示例
//        ImmutableMap<String, Integer> immutableMap = ImmutableMap.of("1", 2, "2", 2, "3", 3);
//        immutableMap.put("4",4); // throw  UnsupportedOperationException



    }
}
