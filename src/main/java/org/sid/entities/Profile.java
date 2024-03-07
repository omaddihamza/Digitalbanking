package org.sid.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.enumeration.Gender;
@Data
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Age;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    @OneToOne
    private UserEntity user;
}
