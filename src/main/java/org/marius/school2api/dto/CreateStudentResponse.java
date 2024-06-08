package org.marius.school2api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateStudentResponse extends CreateSchoolResponse {
    private List<StudentResponse> students;

    public CreateStudentResponse(SchoolResponse schoolResponse, List<StudentResponse> students) {
        super(schoolResponse);
        this.students = students;
    }
}
