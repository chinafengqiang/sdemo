package com.feng;

/**
 * Created by FQ.CHINA on 2017/2/24.
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出 StackOverflowError 异常。
 * 如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出 OutOfMemoryError 异常。
 */
public class TestStackOverflowError {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[]args)throws Throwable {
        TestStackOverflowError sofe=new TestStackOverflowError();
        try{
            sofe.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length:" + sofe.stackLength);
            throw e;
        }

    }
}
