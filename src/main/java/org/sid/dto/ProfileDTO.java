package org.sid.dto;

import lombok.Data;
import org.sid.enumeration.Gender;

@Data
public class ProfileDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Age;
    private Gender gender;
    private Long IdUser;
}
