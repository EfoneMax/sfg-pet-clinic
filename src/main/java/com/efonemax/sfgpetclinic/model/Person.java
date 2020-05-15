package com.efonemax.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Person {
    private String firstname;
    private String lastname;
}
