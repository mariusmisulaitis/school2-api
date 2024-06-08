package org.marius.school2api.dto;

import lombok.Data;

@Data
public class CreateSchoolRequest {
    private final String title;
    private final String address;
    private final String phoneNo;
}
