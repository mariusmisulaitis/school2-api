package org.marius.school2api.services;

import lombok.RequiredArgsConstructor;
import org.marius.school2api.entities.Student;
import org.marius.school2api.entities.School;
import org.marius.school2api.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return this.schoolRepository.findAll();
    }

    public School getSchoolById(Long schoolId) {
        return schoolRepository.findById(schoolId).orElse(null);
    }

    public List<Student> getAllStudentsBySchoolId(Long schoolId) {
        return getSchoolById(schoolId).getStudents();
    }

    public Student getStudentBySchoolIdAndStudentId(Long schoolId, Long studentId) {
//        School school = getSchoolById(schoolId);
//        for (Student student : school.getStudents()) {
//            if (student.getId().equals(studentId)) {
//                return student;
//            }
//        }
//        return null;
        return getSchoolById(schoolId).getStudents().stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElse(null);
    }
}
