/*----------------------------------------------------------------------------------------------------------------------
    ExamSimulation sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.simulation.exam;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private final String m_lectureName;
    private int [][] m_grades;
    private double [] m_averages;
    private double m_average;

    private void fillGrades()
    {
        Random r = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.printf("%s sınavına girecek şube sayısını giriniz:", m_lectureName);
        m_grades = new int[Integer.parseInt(kb.nextLine())][];
        m_averages = new double[m_grades.length];

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube öğrenci sayısını giriniz:", i + 1);
            int count = Integer.parseInt(kb.nextLine());

            m_grades[i] = ArrayUtil.getRandomArray(r, count, 0, 101);
        }
    }

    private void findAverages()
    {
        int totalNumberStudents = 0;
        int totalGrades = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int total = ArrayUtil.sum(m_grades[i]);

            m_averages[i] = (double)total / m_grades[i].length;
            totalGrades += total;
            totalNumberStudents += m_grades[i].length;
        }

        m_average = (double)totalGrades / totalNumberStudents;
    }

    public ExamSimulation(String name)
    {
        m_lectureName = name;
    }

    public void run()
    {
        fillGrades();
        findAverages();
    }

    public int getClassesCount()
    {
        return m_grades.length;
    }

    public int getGrade(int classIndex, int studentIndex)
    {
        return m_grades[classIndex][studentIndex];
    }

    public void displayGrades()
    {
        System.out.printf("%s dersinin sınav notları:%n", m_lectureName);
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube sınav notları:", i + 1);
            ArrayUtil.display(3, m_grades[i]);
        }
        System.out.println("----------------------------------------------------------------");
    }

    public void displayResults()
    {
        displayGrades();
        System.out.printf("%s dersi için ortalamalar:%n", m_lectureName);
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < m_averages.length; ++i)
            System.out.printf("%d. şubenin ortalaması:%f%n", i + 1, m_averages[i]);

        System.out.printf("Okul ortalaması:%f%n", m_average);
        System.out.println("----------------------------------------------------------------");
    }
}
