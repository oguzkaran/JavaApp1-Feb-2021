/*----------------------------------------------------------------------------------------------------------------------
    CompanyApp örneği
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.app.samples.simulation.randomobjectgenerator.RandomObjectArrayGenerator;

class App {
    public static void main(String [] args)
    {
        RandomObjectArrayGenerator rog = new RandomObjectArrayGenerator(10);

        rog.run();

        for (Object obj : rog.getObjects()) {
            Class<?> cls = obj.getClass();

            System.out.println("-------------------");
            System.out.printf("Fullname:%s%n", cls.getName());
            System.out.printf("Name:%s%n", cls.getSimpleName());
            System.out.println("-------------------");
        }
    }
}

