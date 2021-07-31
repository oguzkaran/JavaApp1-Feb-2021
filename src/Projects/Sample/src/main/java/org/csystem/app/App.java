/*----------------------------------------------------------------------------------------------------------------------
    Stream arayüzlerinin map metotları
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.data.factory.ProductFactory;
import org.csystem.data.product.ProductInfo;
import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String[] args)
    {
        try {
            var productFactory = ProductFactory.loadFromTextFile("products.csv");
            if (productFactory.isEmpty())
                return;

            var products = productFactory.get().PRODUCTS;

            products.stream()
                    .filter(p -> p.getTotal().compareTo(new BigDecimal("300000")) < 0 && p.getName().contains("-"))
                    .map(ProductInfo::getCost)
                    .forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
