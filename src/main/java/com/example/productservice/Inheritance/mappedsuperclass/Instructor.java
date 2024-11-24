package com.example.productservice.Inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_instrutor")
public class Instructor extends User{
    String specialisation;
}
