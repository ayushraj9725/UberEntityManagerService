package org.uber.entitymanagerservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter    // this annotation internally creates the getter and setter both for those properties of the review class using lombok
@Setter
@Builder  // this annotation helps us to use a builder pattern in our project, lombok aspect this and give features to us
@NoArgsConstructor    // in aspect of using builder annotation, we have to use this annotation both about constructor
@AllArgsConstructor
@Entity  // this annotation helps us to use to do a logical task in module using this we are creating a real entity review table in our database
 // @Name("Booking_review")  // this will not use to named table
@Table(name = "booking_review")  // using this, we can define custom name of table using java in my db

// here we are adding the jsonIgnoreProperty For handling the crosscutting problem recursive fetching data
// we can also write the custom dtos to implement this like data transferring

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","booking"})
public class Review extends BaseModel{

    @Column(nullable = false)  // this is ensured that the comment not be null
    protected String comment ;

    protected Double rating ;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) // it helps to manage a database when ever we perform a delete operation, like we delete some independent table's data, it will automatically delete dependent data
    @JoinColumn(nullable = false) // one thing we know that if booking exists, then review can exist otherwise no, so we mark here column not be null
    private Booking booking; // here we have defined the 1:1 relationship between review and booking
    // we include it here because booking can be without review, but review can't be without booking, so it is better to write it here

}
