package com.bca.ocrms.model.admin;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="admin_register",uniqueConstraints = {
        @UniqueConstraint(name="unique_Register_email",columnNames = "email"),
        @UniqueConstraint(name="unique_Register_contact",columnNames = "contact")
})
public class AdminRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Register_seq_gen")
    @SequenceGenerator(name="Register_seq_gen",sequenceName = "Register_seq",allocationSize = 1)
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="contact",nullable = false)
    private String contact;

    @Column(name="id_number",nullable = false)
    private String idNumber;

    @Column(name="post",nullable = false)
    private String post;

    @Column(name="password",nullable = false)
    private String password;
}
