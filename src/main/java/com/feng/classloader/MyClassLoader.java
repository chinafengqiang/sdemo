package com.feng.classloader;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("D:/People.class");
        try {
            byte[] bytes = getClassBytes(file);
            //defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            return this.defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getClassBytes(File file)throws Exception{
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true){
            int i = fc.read(by);
            if(i == 0 || i == -1) {
                break;
            }
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

    public static void main(String[] args)throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = Class.forName("People",true,myClassLoader);
        /*Object obj = clazz.newInstance();
        System.out.println(obj);*/
        /*Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj,"ttttt");*/
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        Object obj = constructor.newInstance("2222");
        Method method = clazz.getDeclaredMethod("print");
        method.invoke(obj);

        Method method1 = clazz.getMethod("add",int.class,int.class);
        Object res = method1.invoke(obj,3,3);
        System.out.println(res);

        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj.getClass().getClassLoader().getParent());
    }
}
