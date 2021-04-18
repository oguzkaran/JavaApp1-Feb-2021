/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Android programlamada kullanılan R sınıfı ve içerisinde bulunan static sınıflar simüle
    edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String[] args)
    {
        Context context = new Context();

        Toast.makeText(context, R.string.warning, Toast.LENGTH_LONG).show();
    }
}

class Context {
    //...
}

class Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = -2;

    public static Toast makeText(Context context, int resId, int duration)
    {
        ///...
        return new Toast();
    }

    public void show()
    {
        //...
    }
}

class R {
    public static class id {
        public static int mainActivityButtonOK = 0x1234;
        public static int mainActivityTextViewName = 0x12345;
    }

    public static class drawable {
        public static final int myShip = 0x1FC0;
        //...
    }

    public static class string {
        public static final int warning = 0x1FC1;
    }

    //...
}