package com.bca.ocrms.dto.user;

import com.bca.ocrms.enums.CrimeType;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class ComplainDto {
    private Integer id;

    @NotEmpty(message = "Address can not be empty!!")
    private String address;

    private CrimeType crimeType;

    private String crimeDate;

    private  Date complainDate;

    @NotEmpty(message = "Description can not be empty!!")
    private String description;
}
