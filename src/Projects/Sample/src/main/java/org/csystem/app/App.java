/*----------------------------------------------------------------------------------------------------------------------
    Birden fazla elipsis parametreli metot yazılamacağı için böyle bir durumda elipsis parametresi bir tane olup
    geri kalanlar [] ile bildirilebilir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Sample.foo();
    }
}

class Sample {
    public static void foo(int b, double a)
    {
        int x = 10;
        int y = 20;

        System.out.println(y);
    }
}

