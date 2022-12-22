package org.myshoestore.facades.student;


import org.myshoestore.facades.Student.data.StudentData;

import java.util.List;


public interface StudentFacade
{
    public List<StudentData> getStudentDetails(String studentId);
}