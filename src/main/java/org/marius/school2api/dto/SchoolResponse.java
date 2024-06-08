package org.marius.school2api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolResponse {
    private Long id;
    private String title;
    private String address;
    private String phoneNo;
}
