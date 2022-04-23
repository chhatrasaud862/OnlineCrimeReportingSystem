package com.bca.ocrms.model.user.complain;

import com.bca.ocrms.enums.ComplainStatus;
import com.bca.ocrms.enums.CrimeType;
import com.bca.ocrms.model.user.register.Register;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user_complain")
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "Complain_SEQ_GEN")
    @SequenceGenerator(name="Complain_SEQ_GEN",sequenceName = "Complain_SEQ",allocationSize = 1)
    private Integer id;

    @Column(name="address",nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name="crime_type",nullable = false)
    private CrimeType crimeType;

    @Column(name="crime_date",nullable = false)
    private Date crimeDate;

    @Temporal(TemporalType.DATE)
    @Column(name="complain_date")
    private Date complainDate;

    @Column(nullable = false)
    private ComplainStatus complainStatus;

    @Column(name = "description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="register_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "Fk_register_complaint"))
    private Register register;

}
