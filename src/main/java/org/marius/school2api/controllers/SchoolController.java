package org.marius.school2api.controllers;

import lombok.RequiredArgsConstructor;
import org.marius.school2api.converters.SchoolConverter;
import org.marius.school2api.converters.StudentConverter;
import org.marius.school2api.dto.*;
import org.marius.school2api.entities.School;
import org.marius.school2api.entities.Student;
import org.marius.school2api.services.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<SchoolResponse>> getAllSchools() {
        List<School> schools = this.schoolService.getAllSchools();
        SchoolConverter.convertSchoolEntityListToResponse(schools);
        if (schools.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(SchoolConverter.convertSchoolEntityListToResponse(schools));
    }

    @PostMapping
    public ResponseEntity<CreateSchoolResponse> addSchool(@RequestBody CreateSchoolRequest createSchoolRequest) {
        CreateSchoolResponse responseBody = SchoolConverter.convertSchoolEntityToCreateResponse(this.schoolService.addSchool(createSchoolRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolResponse> getSchoolById(@PathVariable Long schoolId) {
        School school = this.schoolService.getSchoolById(schoolId);
        if (school == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.ok(SchoolConverter.convertSchoolEntityToResponse(school));
    }

    @PatchMapping("/{schoolId}/title")
    public ResponseEntity<SchoolResponse> patchSchoolByIdTitle(@PathVariable Long schoolId, @RequestBody String newTitle) {
        School school = this.schoolService.patchSchoolByIdTitle(schoolId, newTitle);
        if (school == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(SchoolConverter.convertSchoolEntityToResponse(school));
    }

    @GetMapping("/{schoolId}/students")
    public ResponseEntity<List<StudentResponse>> getStudentsBySchoolId(@PathVariable Long schoolId) {
        List<Student> students = this.schoolService.getAllStudentsBySchoolId(schoolId);
        if (students == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(StudentConverter.convertStudentEntityListToResponse(students));
    }

    @PostMapping("/{schoolId}/students")
    public ResponseEntity<CreateStudentResponse> addStudentToSchoolById(@PathVariable Long schoolId, @RequestBody CreateStudentRequest createStudentRequest) {
        School school = this.schoolService.addStudentToSchoolBySchoolId(schoolId, createStudentRequest);
        if (school == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body((SchoolConverter.convertSchoolToCreateStudentResponse(school)));
    }


    @GetMapping("/{schoolId}/students/{studentId}")
    public StudentResponse getStudentBySchoolIdAndStudentId(@PathVariable Long schoolId, @PathVariable Long studentId) {
        return StudentConverter.convertStudentEntityToResponse(
                this.schoolService.getStudentBySchoolIdAndStudentId(schoolId, studentId));
    }

}
