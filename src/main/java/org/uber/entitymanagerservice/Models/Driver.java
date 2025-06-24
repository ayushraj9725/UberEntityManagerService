package org.uber.entitymanagerservice.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Driver")
public class Driver extends BaseModel {

    private String name;

    @Column(nullable = false , unique = true)
    private String licenceNumber;

    // adding more details of Driver
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String aadhaarNumber;

    // driver associated with a car

    @OneToOne(mappedBy = "driver",  cascade = CascadeType.ALL )
    private Car car;

    @Enumerated(EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation ;

    @OneToOne
    private ExactLocation home ;

    private String activeCity ;

    @DecimalMin(value = "0.00" , message = "Rating must be greater than or equal to 0.00 ")
    @DecimalMax(value = "5.00" , message = "Rating must be lesser than or equal to 5.00 ")
    private Double rating ;

    private Boolean isAvailable ;

    // 1 : n , Driver : Booking
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private final List<Booking> bookings = new ArrayList<>();

}