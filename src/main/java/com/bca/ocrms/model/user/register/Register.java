package com.bca.ocrms.model.user.register;

import com.bca.ocrms.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user_register",uniqueConstraints = {
        @UniqueConstraint(name="unique_Register_email",columnNames = "email"),
        @UniqueConstraint(name="unique_Register_mobileNumber",columnNames = "mobile_number"),
        @UniqueConstraint(name="unique_Register_nationalIdNumber",columnNames = "national_id_number")
})
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO/*,generator = "Register_SEQ_GEN"*/)
//    @SequenceGenerator(name="Register_SEQ_GEN",sequenceName = "Register_SEQ",allocationSize = 1)
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="national_id_number",nullable = false)
    private String nationalIdNumber;

    @Column(name="mobile_number",nullable = false)
    private String mobileNumber;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="date_of_birth",nullable = false)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name="gender",nullable = false)
    private Gender gender;

    private String photo;
}
