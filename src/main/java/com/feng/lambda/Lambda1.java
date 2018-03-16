package com.feng.lambda;

/**
 * Created by FQ.CHINA on 2017/10/19.
 */
public class Lambda1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

       /* new Thread(()-> System.out.println("run thread")).start();

        new Thread(() -> {
            System.out.println("run 1111");
        }).start();*/



       /*int res = new IData(){
           @Override
           public int getNumber(int a, int b) {
               return a+b;
           }
       }.getNumber(3,4);

       IData data = new IData() {
           @Override
           public int getNumber(int a, int b) {
               return a+b;
           }
       };

       int res1 = data.getNumber(1,5);
       System.out.println(res);
       System.out.println(res1);*/


       DataService service = new DataService();

      /*
       int res2 = service.addNumber(new IData() {
           @Override
           public int getNumber(int a, int b) {
               return a+b;
           }
       });
       System.out.println(res2);*/

      int res3 = service.addNumber((a,b)->{
          return a+b;
      });
        System.out.println(res3);


    }

}
