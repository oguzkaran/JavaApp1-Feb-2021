package org.csystem.app.samples.dateapp;

import java.util.Random;

public class DateApplicationTest {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Bir sayı giriniz:");
        int n = Integer.parseInt(kb.nextLine());

        Random r = new Random();

        for (int i = 0; i  < n; ++i) {
            DateApp dateApp = new DateApp(r);

            dateApp.display();
            System.out.println("/////////////////////");
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}


