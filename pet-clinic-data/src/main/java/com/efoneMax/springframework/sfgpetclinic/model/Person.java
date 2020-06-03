package com.efoneMax.springframework.sfgpetclinic.model;

import lombok.Data;

@Data
public class Person extends BaseEntity {
    private String firstname;
    private String lastname;
}
