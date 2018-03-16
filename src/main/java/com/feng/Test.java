package com.feng;

import com.feng.arrays.LockFreeVector;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by FQ.CHINA on 2017/2/24.
 */
public class Test {
    public static void main(String[] args)throws Exception{
        /*System.out.println("test!!!");
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("refresh!!!");
            }
        },3000L,3000L);

        ThreadLocal threadLocal = new ThreadLocal();*/

        /*Unsafe unsafe = Unsafe.getUnsafe();
        if (unsafe == null) {
            System.out.println("unsafe is null");
        }else {
            System.out.println("ok");
        }*/


        putLong();

        /*LockFreeVector<String> lockFreeVector = new LockFreeVector<>();
        lockFreeVector.add("111");
        lockFreeVector.add("222");
        lockFreeVector.add("333");
        System.out.println(lockFreeVector.size());
        System.out.println(lockFreeVector.get(1));*/
    }

    public static void putLong()throws Exception{
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        // Writing to a memory - MAX VALUE of Long
        //long value = Long.MAX_VALUE;
        long value = 100L;
        long bytes = Long.SIZE;
        // Allocate given memory size
        long memoryAddress = unsafe.allocateMemory(bytes);
        // Write value to the allocated memory
        unsafe.putLong(memoryAddress, value);

        // Output the value written and the memory address
        System.out.println("[Long] Writing " + value + " under the " + memoryAddress + " address.");

        // Read the value from the memory
        long readValue = unsafe.getLong(memoryAddress);

        // Output the value from
        System.out.println("[Long] Reading " + readValue + " from the " + memoryAddress + " address.");

        // C style! Release the Kraken... Memory!! :)
        unsafe.freeMemory(memoryAddress);
    }
}
