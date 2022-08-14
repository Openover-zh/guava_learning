package com.zhang.collection;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangJiaHao
 * @date 2022/8/14 18:51
 */
public class MultiSetDemo {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3","2","1","1");
        // 内部原理还是一个HashMap<String,Count>
        HashMultiset<String> multiset = HashMultiset.create(list);
        System.out.println(multiset.size());
        System.out.println(multiset.count("1"));


    }
}
