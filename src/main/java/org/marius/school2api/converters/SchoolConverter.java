package org.marius.school2api.converters;

import org.marius.school2api.dto.SchoolResponse;
import org.marius.school2api.entities.School;

import java.util.ArrayList;
import java.util.List;

public class SchoolConverter {

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

    public static List<SchoolResponse> convertSchoolEntityListToResponseList(List<School> schools) {
        List<SchoolResponse> schoolResponses = null;
        if (schools != null) {
            schoolResponses = new ArrayList<>();
            for (School school : schools) {
                schoolResponses.add(convertSchoolEntityToResponse(school));
            }
        }
        return schoolResponses;
    }
}
