package org.marius.school2api.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class StudentResponse {
    private Long id;
    private String name;
    private String lastname;
    private Date birthdate;
    private String phoneNo;
}
