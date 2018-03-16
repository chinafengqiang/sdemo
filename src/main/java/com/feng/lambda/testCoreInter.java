package com.feng.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.*;

/**
 * Created by FQ.CHINA on 2017/10/23.
 */
public class testCoreInter {
    /**
     * Java8里面提供了四大核心的函数式供我们使用
     * @param args
     */
    public static void main(String[] args) {
        /**
         * @name 消费型接口
         * @use Consumer<T>
         * @param T 传入参数
         * @fun 接受一个参数 无返回值
         * */
        Consumer<String> consumer = str-> System.out.println(str);
        consumer.accept("测试");

        /**
         * @name 供给型接口
         * @use Supplier<R>
         * @param R 返回值类型
         * @fun 无参数 有返回值
         * */
        Supplier<Date> date = ()->new Date();
        System.out.println("当前时间："+date.get());

        Supplier<String> str = ()->"测试供给型接口";
        System.out.println(str.get());


        TestInterface<Date> o = ()->new Date();
        System.out.println(o.to());

        /**
         * @name 函数型接口
         * @use Function<T,R>
         * @param T 传入参数
         * @return R 返回值类型
         * @fun 接受一个参数 有返回值
         * */
        Function<String,String> function = str1 -> "Hello "+str1;
        String res = function.apply("China");
        System.out.println(res);

        /**
         * @name 断定型接口
         * @use Predicate<T>
         * @param T 传入参数
         * @return Boolean 返回一个Boolean型值
         * @fun 接受一个参数 返回Boolean型值
         * */
        Predicate<String> predicate = str2->str2.equals("Hello");
        System.out.println(predicate.test("test"));

        IntPredicate intPredicate = num->num > 0;
        System.out.println(intPredicate.test(8));


    }


}
