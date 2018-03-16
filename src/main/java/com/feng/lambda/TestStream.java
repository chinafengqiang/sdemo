package com.feng.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by FQ.CHINA on 2017/10/23.
 */
public class TestStream {
    public static void main(String[] args) {
        Random random = new Random();

//        for(int i=0; i < 10; i++){
//            System.out.println(random.nextInt());
//        }

        /*long count = 0;
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        count = strings.stream().filter(str->str.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);
        count = strings.stream().filter(str->str.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);
        List<String> fsorts = strings.stream().filter(str->!str.isEmpty()).collect(Collectors.toList());
        fsorts.forEach(str-> System.out.println(str));
        String strs = strings.stream().filter(str->!str.isEmpty()).collect(Collectors.joining(","));
        System.out.println(strs);*/

        //useParallelStreams();

        userMap1();
    }

    /**
     * 使用并行流
     * <p>
     * 流操作可以是顺序的，也可以是并行的。顺序操作通过单线程执行，而并行操作则通过多线程执行. 可使用并行流进行操作来提高运行效率
     */
    public static void useParallelStreams() {
        // 初始化一个字符串集合
        int max = 1000000;
        List<String> values = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // 使用顺序流排序

        long sequenceT0 = System.nanoTime();
        values.stream().sorted();
        long sequenceT1 = System.nanoTime();

        // 输出:sequential sort took: 51921 ms.
        System.out.format("sequential sort took: %d ms.", sequenceT1 - sequenceT0).println();

        // 使用并行流排序
        long parallelT0 = System.nanoTime();
        // default Stream<E> parallelStream() {
        // parallelStream为Collection接口的一个默认方法
        values.parallelStream().sorted();
        long parallelT1 = System.nanoTime();

        // 输出:parallel sort took: 21432 ms.
        System.out.format("parallel sort took: %d ms.", parallelT1 - parallelT0).println();

        // 从输出可以看出：并行排序快了一倍多

    }

    public static void userMap(){
        Map<Integer, String> map = new HashMap<>();
        // 如果map中有对应K映射的V且不为null则直接返回;否则执行put
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "value" + i);
        }
        map.forEach((id,str)-> System.out.println(id+" "+str));
    }


    public static void userMap1(){
        Map<String, String> map = new HashMap<>();
        // 如果map中有对应K映射的V且不为null则直接返回;否则执行put
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent("key"+i, "value" + i);
        }

        map.computeIfPresent("key2",(key,value)->key+value+"aaa");

        map.forEach((id,str)-> System.out.println(id+" "+str));

        String retV = map.getOrDefault("key22", "not found");
        System.out.println(retV);

        String newValue1 = map.merge("key99", "valueddd", (value, newValue) -> value.concat(newValue));
        System.out.println(newValue1);
        System.out.println(map.get(9));
    }


}
