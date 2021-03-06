package com.bca.ocrms.dto.user;

import com.bca.ocrms.enums.Gender;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Valid
public class RegisterDto {
    private int id;

    @NotEmpty(message = "Number can not be empty!!")
    private String name;

    private String dateOfBirth;

    private Gender gender;

    @Email
    @NotEmpty(message = "Email can not be empty!!")
    private String email;

    @Size(max = 10,min = 0,message = "mobileNumber should be 0 to 10.")
    @NotEmpty(message = "Mobile number can not be empty!!")
    private String mobileNumber;

    @NotEmpty(message = "Password can not be empty!!")
    private String password;

    private String photo;
    private MultipartFile multipartFile;
}
