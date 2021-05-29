/*----------------------------------------------------------------------------------------------------------------------
    Deprecated annotation'ına Java 9 ile birlikte forRemoval ve since elemanları eklenmiştir. forRemoval default olarak
    false değerindedir. Deprecated işaretlenen bir elemanın ileride silinip silinmeyeceğini belirtmek için kullanılır.
    since elemanı ise String türündendir, default değeri boş string'dir. Genel olarak deprecate olan versiyonu belirtmek
    için kullanılır
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {

    }
}


@FunctionalInterface
interface IBinaryOperation<T, R> {
    R apply(T t);
    void foo();
}