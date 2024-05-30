package org.marius.school2api.converters;

import org.marius.school2api.dto.StudentResponse;
import org.marius.school2api.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {
    public static StudentResponse convertStudentEntityToResponse(Student student) {
        StudentResponse studentResponse = null;
        if (student != null) {
            studentResponse = new StudentResponse();
            studentResponse.setId(student.getId());
            studentResponse.setName(student.getName());
            studentResponse.setLastname(student.getLastname());
            studentResponse.setBirthdate(student.getBirthdate());
            studentResponse.setPhoneNo(student.getPhoneNo());

        }
        return studentResponse;
    }

    public static List<StudentResponse> convertStudentEntityListToResponseList(List<Student> students) {
        List<StudentResponse> studentResponses = null;
        if (students != null) {
            studentResponses = new ArrayList<>();
            for (Student student : students) {
                studentResponses.add(convertStudentEntityToResponse(student));
            }
        }
        return studentResponses;
    }
}
