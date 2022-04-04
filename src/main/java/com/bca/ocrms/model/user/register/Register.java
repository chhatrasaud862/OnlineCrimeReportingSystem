package com.bca.ocrms.model.user.register;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Register_SEQ_GEN")
    @SequenceGenerator(name="Register_SEQ_GEN",sequenceName = "Register_SEQ",allocationSize = 1)
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="national_id_number",nullable = false)
    private String nationalIdNumber;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="mobile_number",nullable = false)
    private String mobileNumber;

    @Column(name = "password",nullable = false)
    private String password;
}
