package org.uber.entitymanagerservice.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car extends BaseModel{

    @ManyToOne
    private Color color;

    @Column(unique = true,nullable = false)
    private String plateNumber ;

    private String brand ;

    private String model ;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    @OneToOne
    private Driver driver ;
}
