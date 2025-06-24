package org.uber.entitymanagerservice.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passenger")
public class Passenger extends BaseModel{

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private String email ;

    @Column(nullable = false)
    private String password ;

    @Column(nullable = false)
    private String phoneNumber ;

    @OneToMany(mappedBy = "passenger" , cascade = CascadeType.ALL)
    private final List<Booking> bookings = new ArrayList<>();

    @DecimalMin(value = "0.00" , message = "Rating must be greater than or equal to 0.00 ")
    @DecimalMax(value = "5.00" , message = "Rating must be lesser than or equal to 5.00 ")
    private Double rating ;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking activeBooking ;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation lastKnownLocation ;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation home ;

}