package com.bca.ocrms.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComplainDto {
    private Integer id;
    private String address;
    private String nationalIdNumber;
    private String crimeType;
    private String crimeDate;
    private String description;
}
