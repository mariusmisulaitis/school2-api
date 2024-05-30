package org.marius.school2api.dto;

import lombok.Data;

@Data
public class SchoolResponse {
    private Long id;
    private String title;
    private String address;
    private String phoneNo;
}
