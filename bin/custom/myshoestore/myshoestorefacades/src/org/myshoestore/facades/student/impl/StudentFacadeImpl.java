package org.myshoestore.facades.student.impl;

import de.hybris.platform.converters.Converters;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.myshoestore.core.service.impl.StudentServices;
import org.myshoestore.facades.Student.data.StudentData;
import org.myshoestore.facades.student.StudentFacade;
import org.studentcommercewebservices.model.StudentDetailsModel;

import java.util.List;

public class StudentFacadeImpl implements StudentFacade
{

    private StudentServices studentServices;
    private Converter<StudentDetailsModel, StudentData> studentConverter;

    @Override
    public List<StudentData> getStudentDetails(final String studentId)
    {
        final List<StudentDetailsModel> studentDetailsModels = studentServices.getStudentDetails(studentId);
        return Converters.convertAll(studentDetailsModels, getStudentConverter());
    }

    public StudentServices getStudentServices()
    {
        return studentServices;
    }

    public void setStudentServices(final StudentServices studentServices)
    {
        this.studentServices = studentServices;
    }

    public Converter<StudentDetailsModel, StudentData> getStudentConverter()
    {
        return studentConverter;
    }

    public void setStudentConverter(final Converter<StudentDetailsModel, StudentData> studentConverter)
    {
        this.studentConverter = studentConverter;
    }


}