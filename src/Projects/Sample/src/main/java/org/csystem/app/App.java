/*----------------------------------------------------------------------------------------------------------------------
    Collection arayüzünün toCharArray metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.data.product.ProductFactory;
import org.csystem.data.product.ProductInfo;
import org.csystem.util.Console;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        try {
            var random = new Random();
            var factoryOpt = ProductFactory.loadFromTextFile("products-org.csv");
            if (factoryOpt.isEmpty())
                return;

            var factory = factoryOpt.get();

            factory.PRODUCTS.forEach(Console::writeLine);

            Console.writeLine("---------------------------------------------------------");

            for (var pi : factory.PRODUCTS)
                Console.writeLine(pi);
        }
        catch (Throwable ex) {
            Console.Error.writeLine(ex.getMessage());
        }
    }
}
