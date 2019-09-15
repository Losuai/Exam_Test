package com.company.clone;

public class A implements Cloneable{
    public String name[];
    public String age;
    public A() {
        name = new String[2];
    }
    public Object clone() {
        A obj = null;
        try {
            obj = (A)super.clone();
            obj.name = this.name.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        A a1 = new A();
        A a2 = new A();
        a1.name[0]="a";
        a1.name[1]="1";
        a2=(A)a1.clone();
        a2.name[0]="b";
        a2.name[1]="1";
        System.out.println("a1.name="+a1.name);
        System.out.println("a1.name="+a1.name[0]+a1.name[1]);
        System.out.println("a2.name="+a2.name);
        System.out.println("a2.name="+a2.name[0]+a2.name[1]);
        /*分析：
         * 可以看到我们的a1.name输出的是name数组的地址
         * 且输出的a1.name和a2.name都是b1,说明在进行对象复制的时候对name数组只是复制了它的地址，如果要解决这种情况的话，我们就要采用深层复制
         */

        A a3=new A();
        A a4=new A();
        a1.age="a1";
        a2=(A)a1.clone();
        a2.age="a2";
        System.out.println("a1.name="+a1.age);
        System.out.println("a2.name="+a2.age);
        //此时输出的结果是：
        //a1.age=a2
        //a2.age=a2
    }
}
