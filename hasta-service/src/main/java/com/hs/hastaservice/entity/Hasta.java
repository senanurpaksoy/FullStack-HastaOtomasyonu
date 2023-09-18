package com.hs.hastaservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class Hasta {
    @Id
    @SequenceGenerator(name= "hs_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hs_seq")
    private Long id;
    private String firstname;
    private String lastname;
    private Instant birthdate;


}
