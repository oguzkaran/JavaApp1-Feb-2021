package org.csystem.application.simpleplugin;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public final class SimplePluginApplication {
    private static void printMetadata(Class<?> cls)
    {
        System.out.println("------------------------------------");

        System.out.println("Declared methods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.printf("%s %s(", method.getReturnType().getSimpleName(), method.getName());
            for (Parameter parameter : method.getParameters())
                System.out.printf("%s %s,", parameter.getType().getName(), parameter.getName());
            System.out.println(")");
        }

        System.out.println("------------------------------------");
    }

    private static void doWork(String [] args)
    {
        Scanner kb = new Scanner(System.in);

        for (String typeName : args) {
            try {
                Class<?> cls = Class.forName(typeName);

                System.out.printf("%s byte code is found%n", typeName);
                printMetadata(cls);
            }
            catch (ClassNotFoundException ignore) {
                System.err.printf("%s type not found%n", typeName);
            }
            catch (NoClassDefFoundError ignore) {
                System.err.printf("%s type is not appropriate%n", typeName);
            }
        }
    }

    private SimplePluginApplication()
    {
    }

    public static void run(String [] args)
    {
        if (args.length == 0) {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }
        doWork(args);
    }
}
