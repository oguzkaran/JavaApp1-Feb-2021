package org.csystem.app.samples.studentinfoapp;

import org.csystem.util.datetime.Date;

public class StudentInfo {
    public String name;
    public String birthDate;
    public String lectureName;
    public int midtermGrade;
    public int finalGrade;

    //...

    public double getGrade()
    {
        return midtermGrade * 0.4 + finalGrade * 0.6;
    }

    public String getBirthDateStrTR()
    {
        String [] birthDateInfo = birthDate.split("[/]");

        int day = Integer.parseInt(birthDateInfo[0]);
        int month = Integer.parseInt(birthDateInfo[1]);
        int year = Integer.parseInt(birthDateInfo[2]);
        Date date = new Date(day, month, year);

        return date.toLongDateStringTR();
    }

    public String toString()
    {
        double grade = getGrade();

        return String.format("%s, %s, %f, %s", name, getBirthDateStrTR(), grade, grade >= 50 ? "Başarılı" : "Başarısız");
    }
}
