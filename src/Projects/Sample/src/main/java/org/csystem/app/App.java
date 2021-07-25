/*----------------------------------------------------------------------------------------------------------------------
    Soru: Stack kullanarak bir yazıyı ekrana tersten yazdıran printReverse isimli metodu Util sınıfı içerisinde yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Stack;

class App {
    public static void main(String[] args)
    {
        for (;;) {
            var str = Console.read("Bir yazı giriniz:");

            Util.printReverse(str);

            if ("elma".equals(str))
                break;
        }
    }
}

class Util {
    public static void printReverse(String str)
    {
        var charStack = new Stack<Character>();
        var length = str.length();

        for (var i = 0; i < length; ++i)
            charStack.push(str.charAt(i));

        while (!charStack.isEmpty())
            Console.write(charStack.pop());

        Console.writeLine();
    }
}