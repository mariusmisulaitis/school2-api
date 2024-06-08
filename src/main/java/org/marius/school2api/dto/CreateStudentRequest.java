package org.marius.school2api.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CreateStudentRequest {
    private final String name;
    private final String lastname;
    private final Date birthdate;
    private final String phoneNo;
}
