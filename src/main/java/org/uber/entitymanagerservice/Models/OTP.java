package org.uber.entitymanagerservice.Models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTP extends BaseModel{

    private String code ;

    private String sendToNumber ;

    public static OTP makeOTP(String phoneNumber){
        // initialize A random object somewhere; you should only need
        Random random = new Random();

        // generate the random number from 0 to 8999 and add 1000 to them
        Integer code = random.nextInt(9000) + 1000;

        return OTP.builder().code(code.toString()).sendToNumber(phoneNumber).build();
    }

}
