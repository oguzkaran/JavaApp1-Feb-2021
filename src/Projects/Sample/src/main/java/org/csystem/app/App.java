/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Bir collection içerisindeki tüm elemanların tekil (unique) olup olmadığını test eden
    generic bir metot yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.data.factory.ProductFactory;
import org.csystem.data.product.ProductInfo;
import org.csystem.util.Console;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        try {
            var productFactory = ProductFactory.loadFromTextFile("products-org.csv").get();
            var products = new ArrayList<ProductInfo>();
            var random = new Random();

            for (int i = 0; i < 300; ++i) {
                var product = productFactory.getRandomProduct(random);

                products.add(product);
            }

            for (var p : products)
                Console.writeLine(p);

            Console.writeLine(CollectionUtil.areAllDistinct(products));
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}

final class CollectionUtil {
    private CollectionUtil()
    {
    }

    public static <T> boolean areAllDistinct(Collection<? extends T> collection)
    {
        return collection.size() == new HashSet<>(collection).size();
    }
}

