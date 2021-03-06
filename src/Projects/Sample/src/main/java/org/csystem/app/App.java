/*----------------------------------------------------------------------------------------------------------------------
    Değişken sayıda argüman alan metotlar (varargs methods) "...(elipsis)" parametre ile yazılır. Elipsis parametresi
    metot açısından bir dizi referansıdır. Çağıran açısından ise hem dizi referansı hem de aynı türden değişken sayıda
    argüman geçmek için kullanılabilir. Metoda varargs paramteresi için argüman olarak bir diz referansı verilmiyorsa
    derleyici çağırma sırasında dizi yaratılmasını sağlayan kodu üretir. varargs parametresine hiç argüman geçilmezse
    bu durumda boş dizi (eleman sayısı sıfır olan dizi) argüman olarak verilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {

    }
}

class Util {
    public static int sum(int...a) //error
    {
        int total = 0;

        for (var val : a)
            total += val;

        return total;
    }

    public static int sum(int[]a) //error
    {
        int total = 0;

        for (var val : a)
            total += val;

        return total;
    }
}
