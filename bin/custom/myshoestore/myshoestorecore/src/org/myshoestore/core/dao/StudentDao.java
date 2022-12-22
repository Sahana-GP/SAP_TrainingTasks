package org.myshoestore.core.dao;

import de.hybris.platform.servicelayer.internal.dao.Dao;
import org.studentcommercewebservices.model.StudentDetailsModel;

import java.util.List;

public interface StudentDao extends Dao
{
    List<StudentDetailsModel> getStudentDetailsByCode(String studentId);
}