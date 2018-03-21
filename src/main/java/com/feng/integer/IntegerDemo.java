package com.feng.integer;

public class IntegerDemo {
    public static void main(String[] args) {
        /**
         * 在[-128,127]之间，Integer总是缓存了相应数值对象，这样每次取值时都是同一个对象，而不在此区间时，则不一定会缓存，
         * 那么取出两个同样数值大小的对象则不是同一个对象，每次都会new Integer(i);，所以其对象的地址不同，则用==比较是自然不会成立
         * 为了防止不小心掉入这样的陷阱，对于基本类型的比较，用“==”；而对于基本类型的封装类型和其他对象，
         * 应该调用public boolean equals(Object obj)方法(复杂对象需要自己实现equals方法)。
         */
        Integer a = 100;
        Integer b = 100;
        Integer c = 300;
        Integer d = 300;
        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}
