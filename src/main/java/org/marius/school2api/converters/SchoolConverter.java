package org.marius.school2api.converters;

import org.marius.school2api.dto.CreateSchoolResponse;
import org.marius.school2api.dto.CreateStudentResponse;
import org.marius.school2api.dto.SchoolResponse;
import org.marius.school2api.entities.School;

import java.util.ArrayList;
import java.util.List;

public abstract class SchoolConverter {

    private SchoolConverter(){}

    public static SchoolResponse convertSchoolEntityToResponse(School school) {
        SchoolResponse schoolResponse = null;
        if (school != null) {
            schoolResponse = new SchoolResponse();
            schoolResponse.setId(school.getId());
            schoolResponse.setTitle(school.getTitle());
            schoolResponse.setAddress(school.getAddress());
            schoolResponse.setPhoneNo(school.getPhoneNo());

        }
        return schoolResponse;
    }

    public static CreateSchoolResponse convertSchoolEntityToCreateResponse(School school) {
        return new CreateSchoolResponse(convertSchoolEntityToResponse(school));
    }

    public static List<SchoolResponse> convertSchoolEntityListToResponse(List<School> schools) {
        List<SchoolResponse> schoolResponses = null;
        if (schools != null) {
            schoolResponses = new ArrayList<>();
            for (School school : schools) {
                schoolResponses.add(convertSchoolEntityToResponse(school));
            }
        }
        return schoolResponses;
    }

    public static CreateStudentResponse convertSchoolToCreateStudentResponse(School school) {
        CreateStudentResponse createStudentResponse = null;
        if (school != null) {
            createStudentResponse = new CreateStudentResponse(SchoolConverter.convertSchoolEntityToResponse(school), StudentConverter.convertStudentEntityListToResponse(school.getStudents()));
        }
        return createStudentResponse;
    }
}
