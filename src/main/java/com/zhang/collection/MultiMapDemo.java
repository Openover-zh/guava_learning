package com.zhang.collection;

import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangJiaHao
 * @date 2022/8/14 22:12
 */
public class MultiMapDemo {
    public static void main(String[] args) {
        // 不允许相同键里面有重复值
        HashMultimap<@Nullable Object, @Nullable Object> objectObjectHashMultimap = HashMultimap.create();

        ArrayListMultimap<@Nullable Object, @Nullable Object> objectObjectArrayListMultimap = ArrayListMultimap.create();

        ListMultimap<@Nullable Object, @Nullable Object> hashListMultiMap = MultimapBuilder.hashKeys().arrayListValues().build();

        SetMultimap<@Nullable String, @Nullable String> hashSetMultiMap = MultimapBuilder.hashKeys().hashSetValues().build();
        hashSetMultiMap.put("zhang","1");
        hashSetMultiMap.put("zhang","2");
        hashSetMultiMap.put("zhang","6");
        hashSetMultiMap.put("zhang","6");
        hashSetMultiMap.put("li","1");
        // 如果获取不存在的键会返回空集合而不是null
        Set<@Nullable String> values = hashSetMultiMap.get("zhang"); // SetMultiMap回去重 ListMultiMap不会去重
        System.out.println("multiMap.get()== "+values); // [1, 2, 6]
        // MultiMap的entries方法返回 所有键的所有值 如果想获取所有键对应的集合条目 使用hashListMultiMap.asMap().entrySet()
        Set<Map.Entry<@Nullable String, @Nullable String>> entries = hashSetMultiMap.entries();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry); //zhang=1 zhang=2 zhang=6 li=1
        }
        // Multimap.size()返回整个multimap中的条目数，而不是独立键的数量。使用Multimap.keySet().size()来获取独立键的数量。
        System.out.println("multiMap.Size== "+ hashSetMultiMap.size());  // 4
        // 如果喜欢map的方式获取 可以使用asMap方法
        // 可以将asMap返回的集合转换为对应的Set和List
        Map<@Nullable String, Collection<@Nullable String>> collectionMap = hashSetMultiMap.asMap();
        // 如果获取不存在的键 会返回null 而不是空集合
        Set<@Nullable String> setValues = (Set<String>) collectionMap.get("zz");
        System.out.println(setValues); // null
        // keyset返回所有key的一个集合 不重复
        System.out.println("multiMap.keySet()== "+ hashSetMultiMap.keySet()); // [zhang, li]
        // keys返回一个MultiSet
        Multiset<@Nullable String> keys = hashSetMultiMap.keys();
        System.out.println("multiMap.Keys()== "+keys.count("zhang")); // 3


    }
}
