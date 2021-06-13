/*----------------------------------------------------------------------------------------------------------------------
    enum türünden nesne reflection kullanılarak da yaratılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import java.lang.reflect.InvocationTargetException;

class App {
    public static void main(String[] args)
    {
        try {
            Class<?> cls = Singleton.class;

            for (int i = 0; i < 10; ++i) {
                var ctor = cls.getDeclaredConstructor();

                ctor.setAccessible(true);
                var obj = ctor.newInstance();
                ctor.setAccessible(false);

                //...
            }
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException
                | IllegalAccessException e) {
            var cause = e.getCause();

            System.out.println(cause == null ? e.getMessage() : cause.getMessage());
            e.printStackTrace();
        }
    }
}

enum Singleton {
    INSTANCE;
    private int m_x;

    Singleton()
    {}

    public int getX()
    {
        return m_x;
    }

    public void setX(int x)
    {
        //...
        m_x = x;
    }

}
