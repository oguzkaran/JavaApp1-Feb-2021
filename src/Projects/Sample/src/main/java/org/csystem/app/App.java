/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.collection.CSDArrayList;

class App {
    public static void main(String[] args)
    {
        Object obj;

        var names = new CSDArrayList<String>();

        names.add("Onur Gürsoy");
        names.add("Bora Şahin");
        names.add("Taner Genç");
        names.add("Beyza Yazıcı");
        names.add("Turgut Karaağaç");
        names.add("Beyza Yazıcı");

        int index = names.indexOf("Beyza Yazıcı");

        Console.writeLine(index);
    }
}

