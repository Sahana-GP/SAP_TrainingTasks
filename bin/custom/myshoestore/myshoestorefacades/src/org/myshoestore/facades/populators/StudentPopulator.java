package org.myshoestore.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.myshoestore.facades.Student.data.StudentData;
import org.studentcommercewebservices.model.StudentDetailsModel;

public class StudentPopulator implements Populator<StudentDetailsModel, StudentData>
{

    @Override
    public void populate(final StudentDetailsModel source, final StudentData target)
            throws ConversionException
    {
        target.setStudentId(source.getStudentId());
        target.setStudentPlace(source.getStudentPlace());
        target.setStudentName(source.getStudentName());
        target.setStudentGuardian(source.getStudentGuardian());

    }
}