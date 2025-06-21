package org.uber.entitymanagerservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","booking"}) // ignore the properties that are not mapped to the table, avoid or prevent from cross-cutting problem and recursion fetching data
public class PassengerReview extends BaseModel {

    @Column(nullable = false)
    private String passengerComment;

    private Double passengerRating;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking ;

}
