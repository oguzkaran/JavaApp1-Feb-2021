/*----------------------------------------------------------------------------------------------------------------------
    CommanLineUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

import static org.csystem.util.CommandLineUtil.getCommandLineArgsJoin;

class App {
    public static void main(String[] args)
    {
        var text = getCommandLineArgsJoin(args, "Input your text:", "");

        Console.writeLine(StringUtil.isPalindrome(text) ? "Palindrom" : "Palindrom değil");
        Console.writeLine("C and System Programmers Association");
    }
}

