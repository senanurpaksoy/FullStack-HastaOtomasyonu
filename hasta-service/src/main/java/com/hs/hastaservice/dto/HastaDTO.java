package com.hs.hastaservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class HastaDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Instant birthdate;
}
