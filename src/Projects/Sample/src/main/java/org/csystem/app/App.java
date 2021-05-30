/*----------------------------------------------------------------------------------------------------------------------
    Lambda ifadesine ilişkin derleyici tarafında yazılan türlerin class referanslarına da getClass metodu ile
    erişilebilir. Aşağıdaki örneği çalıştırırak ekran çıktısını gözlemleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        IX ix1 = () -> Console.writeLine("This is a test");
        IX ix2 = () -> Console.writeLine("This is another test");

        Class<?> cls1 = ix1.getClass();
        Class<?> cls2 = ix2.getClass();

        System.out.println(cls1.getName());
        System.out.println(cls2.getName());
    }
}


interface IX {
    void foo();
}

