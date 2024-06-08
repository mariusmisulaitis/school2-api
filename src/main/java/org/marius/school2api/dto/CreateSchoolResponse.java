package org.marius.school2api.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateSchoolResponse extends SchoolResponse {
    public CreateSchoolResponse(SchoolResponse schoolResponse) {
        super(schoolResponse.getId(),
                schoolResponse.getTitle(),
                schoolResponse.getAddress(),
                schoolResponse.getPhoneNo());
    }
}
