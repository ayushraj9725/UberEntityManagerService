package org.uber.entitymanagerservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "booking")
@Table(
        name = "booking" ,
        indexes = {
        @Index(columnList = "driver_id")
})
public class Booking extends BaseModel{

    // doing some composition btw table because we want to define relation to interact as per need

    @Enumerated(value = EnumType.STRING) // it tells to db that our type is enum so mapping handle by JPA as string type data representation
    private BookingStatus bookingStatus ;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime ;

    private long distance ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger ;

    @OneToOne
    private ExactLocation startLocation;

    @OneToOne
    private ExactLocation endLocation;

}

