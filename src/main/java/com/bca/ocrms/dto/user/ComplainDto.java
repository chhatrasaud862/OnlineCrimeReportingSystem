package com.bca.ocrms.dto.user;

import com.bca.ocrms.enums.ComplainStatus;
import com.bca.ocrms.enums.CrimeType;
import com.bca.ocrms.model.user.register.Register;
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

    private ComplainStatus complainStatus;

    private Register register;

    @NotEmpty(message = "Description can not be empty!!")
    private String description;
}
