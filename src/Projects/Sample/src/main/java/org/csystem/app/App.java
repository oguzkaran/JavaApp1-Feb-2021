/*----------------------------------------------------------------------------------------------------------------------
    Stack sınıfının pop metodu stack boş ise EmptyStackException nesnesi fırlatır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;

class App {
    public static void main(String[] args)
    {
        Vector<Integer> stack = new Vector<>();

        for (int i = 0; i < 10; ++i)
            stack.add(i * 10);

        Console.writeLine("Peek:%d", stack.get(stack.size() - 1));

        for (int i = stack.size() - 1; i >= 0; --i)
            Console.write("%d ", stack.get(i));

        Console.writeLine();
    }
}



