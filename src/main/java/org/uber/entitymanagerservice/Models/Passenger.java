package org.uber.entitymanagerservice.Models;

import jakarta.persistence.*;
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

}