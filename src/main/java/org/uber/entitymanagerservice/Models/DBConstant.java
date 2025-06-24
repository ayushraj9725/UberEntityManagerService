package org.uber.entitymanagerservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DBConstant extends BaseModel {

    @Column(unique = true, nullable = false)
    private String name ;

    private String value ;

}
