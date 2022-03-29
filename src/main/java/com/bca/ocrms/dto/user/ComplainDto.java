package com.bca.ocrms.dto.user;

import lombok.*;

import java.util.Date;

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
    private Date crimeDate;
    private String description;
}
