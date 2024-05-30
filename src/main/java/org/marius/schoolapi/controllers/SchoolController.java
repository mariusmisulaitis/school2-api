package org.marius.schoolapi.controllers;

import lombok.RequiredArgsConstructor;
import org.marius.schoolapi.entities.School;
import org.marius.schoolapi.entities.Student;
import org.marius.schoolapi.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public List<School> getAllSchools() {
        return this.schoolService.getAllSchools();
    }

    @GetMapping("/{schoolId}")
    public School getSchoolById(@PathVariable Long schoolId) {
        return this.schoolService.getSchoolById(schoolId);
    }

    @GetMapping("/{schoolId}/students")
    public List<Student> getStudentsBySchoolId(@PathVariable Long schoolId) {
        return this.schoolService.getAllStudentsBySchoolId(schoolId);
    }

    @GetMapping("/{schoolId}/students/{studentId}")
    public Student getStudentBySchoolIdAndStudentId(@PathVariable Long schoolId, @PathVariable Long studentId) {
        return this.schoolService.getStudentBySchoolIdAndStudentId(schoolId, studentId);
    }
}
