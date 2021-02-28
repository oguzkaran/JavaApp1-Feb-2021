package org.csystem.app.samples.studentinfoapp;

public class StudentInfoParser {
    private final StudentInfo m_studentInfo;

    public StudentInfoParser(String str)
    {
        String[] studentInfoStr = str.split("[:]+");

        //...

        m_studentInfo = new StudentInfo();
        m_studentInfo.name = studentInfoStr[0];
        m_studentInfo.birthDate = studentInfoStr[1];
        m_studentInfo.lectureName = studentInfoStr[2];
        m_studentInfo.midtermGrade = Integer.parseInt(studentInfoStr[3]);
        m_studentInfo.finalGrade = Integer.parseInt(studentInfoStr[4]);
    }

    public StudentInfo getStudentInfo()
    {
        return m_studentInfo;
    }
}
