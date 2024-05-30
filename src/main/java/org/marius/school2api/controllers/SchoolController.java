package org.marius.school2api.controllers;

import lombok.RequiredArgsConstructor;
import org.marius.school2api.converters.SchoolConverter;
import org.marius.school2api.converters.StudentConverter;
import org.marius.school2api.dto.SchoolResponse;
import org.marius.school2api.dto.StudentResponse;
import org.marius.school2api.services.SchoolService;
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
    public List<SchoolResponse> getAllSchools() {
        return SchoolConverter.convertSchoolEntityListToResponseList(this.schoolService.getAllSchools());
    }

    @GetMapping("/{schoolId}")
    public SchoolResponse getSchoolById(@PathVariable Long schoolId) {
        return SchoolConverter.convertSchoolEntityToResponse(this.schoolService.getSchoolById(schoolId));
    }

    @GetMapping("/{schoolId}/students")
    public List<StudentResponse> getStudentsBySchoolId(@PathVariable Long schoolId) {
        return StudentConverter.convertStudentEntityListToResponseList(this.schoolService.getAllStudentsBySchoolId(schoolId));
    }

    @GetMapping("/{schoolId}/students/{studentId}")
    public StudentResponse getStudentBySchoolIdAndStudentId(@PathVariable Long schoolId, @PathVariable Long studentId) {
        return StudentConverter.convertStudentEntityToResponse(this.schoolService.getStudentBySchoolIdAndStudentId(schoolId, studentId));
    }
}
