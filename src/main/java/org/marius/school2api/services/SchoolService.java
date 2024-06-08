package org.marius.school2api.services;

import lombok.RequiredArgsConstructor;
import org.marius.school2api.dto.CreateSchoolRequest;
import org.marius.school2api.dto.CreateStudentRequest;
import org.marius.school2api.entities.Student;
import org.marius.school2api.entities.School;
import org.marius.school2api.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        School school = getSchoolById(schoolId);
        if (school != null) {
            return school.getStudents();
        }
        return null;
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

    public School addSchool(CreateSchoolRequest createSchoolRequest) {
        School school = new School();
        school.setTitle(createSchoolRequest.getTitle());
        school.setAddress(createSchoolRequest.getAddress());
        school.setPhoneNo(createSchoolRequest.getPhoneNo());
        school.setStudents(new ArrayList<>());
        return this.schoolRepository.saveAndFlush(school);
    }

    public School addStudentToSchoolBySchoolId(Long schoolId, CreateStudentRequest createStudentRequest) {
        School school = getSchoolById(schoolId);
        if (school != null) {
            Student student = new Student();
            student.setName(createStudentRequest.getName());
            student.setLastname(createStudentRequest.getLastname());
            student.setBirthdate(createStudentRequest.getBirthdate());
            student.setPhoneNo(createStudentRequest.getPhoneNo());

            school.getStudents().add(student);

            return this.schoolRepository.saveAndFlush(school);

        }
        return school;

    }

    public School patchSchoolByIdTitle(Long id, String newTitle) {
        School school = getSchoolById(id);
        if (school != null) {
            school.setTitle(newTitle);
            return this.schoolRepository.saveAndFlush(school);
        }
        return school;
    }
}
