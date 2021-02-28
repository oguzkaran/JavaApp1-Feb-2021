/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden aşağıdaki formatta girilen bilgiyi ayrıştırarak aşağıdaki açıklamaya göre
    sonucu ekrana yazdıran programı yazınız.
    <isim>:<gg/aa/yyyy>:<ders adı>:<vize>:<final>
    Oğuz Karan:10/09/1976:Matematik:67:78
    Ali Vefa Serçe:10/09/1976:Matematik:67:78

    Açıklamalar:
    - Formatla ilgili geçerlilik kontrolü yapılmayacaktır
    - Bu formatta kişin vize final notlarından vize * %40 + final * %60 fomülüne göre geçme notu hesaplanacaktır. Sonuçta
    50 ve üstü alan başarılı olacaktır
    - Bu işlemlerden sonra öğrencinin ismi, hangi güne geldiği bilgisi ile doğum tarihi, geçme notu ve başarı durumu
    ekrana yazdırılacaktır. Örnek:
    Oğuz Karan, 10/09/1976 Cuma, 73.6, Başarılı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.studentinfoapp;

import java.util.Scanner;

public class StudentInfoParserApp {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if ("quit".equals(str))
                break;

            StudentInfoParser studentInfoParser = new StudentInfoParser(str);

            System.out.println(studentInfoParser.getStudentInfo().toString());
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
