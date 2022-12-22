package org.myshoestore.core.service.impl;


import org.myshoestore.core.dao.StudentDao;
import org.studentcommercewebservices.model.StudentDetailsModel;

import javax.annotation.Resource;
import java.util.List;

public class StudentServices {
    @Resource
    private StudentDao studentDao;

    public List<StudentDetailsModel> getStudentDetails(final String studentId)
    {
        List<StudentDetailsModel> studentModels=studentDao.getStudentDetailsByCode(studentId);
        return studentModels;
    }
}