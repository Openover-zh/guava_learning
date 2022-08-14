package com.zhang.basicType;


import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @author zhangJiaHao
 * @date 2022/8/14 17:35
 */
public class Demo01 {
    public static void main(String[] args) {
        // 快速将元素转换到集合中
        List<Integer> integers = Ints.asList(1, 2, 3, 4, 5);
        System.out.println(integers); // [1,2,3,4,5]
        // 将值转换为逗号分割的字符串
        System.out.println(Ints.join(",",1,2,3,4,5)); // 1,2,3,4,5

        int[] array = Ints.concat(new int[]{1, 2, 3, 4, 5}, new int[]{4, 7, 8});
        System.out.println(array.length); // 8
//        Arrays.stream(array).forEach(System.out::println); // 1 2 3 4 5 4 7 8
        Ints.reverse(array); // 反转数组元素
//        Arrays.stream(array).forEach(System.out::println); // 8 7 4 5 4 3 2 1
        System.out.println(Ints.max(array)+","+Ints.min(array)); // 获取最大最小值 8,1
        // 判断是否包含给定元素
        System.out.println(Ints.contains(array,1)); // true
        // 数组转换为list
        List<Integer> integers1 = Ints.asList(array);
        System.out.println(integers1);

    }
}
