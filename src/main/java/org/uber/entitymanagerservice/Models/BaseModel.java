package org.uber.entitymanagerservice.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass  // it means: no table for a parent class, one table of each child class having this parent property
public abstract class BaseModel {

    // this class actually helps us to use existing property in our tables, which will be the same in all, so we are using inheritance,
    // but SQL does not know about inheritance than how it will help, the JPA comes and mapped it to use us easily
    // we are making it abstract, so that we would not create an object of this class even by mistake


    @Id // this annotation makes the id property to a primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // identity means auto_increment
    // @Column(nullable = false)
    protected long id ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells to spring, what type of format of this attribute to be stored into the table, i.e., Date / Time / Timestamp
    @CreatedDate  // this annotation tells that a spring handle only for the object creation time and date
    protected Date createdAt ;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // this annotation tells that spring handle only for the object update last time and date
    protected Date updatedAt ;


}
