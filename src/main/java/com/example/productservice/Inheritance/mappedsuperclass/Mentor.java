package com.example.productservice.Inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_mentor")
public class Mentor extends User{
    String company;
    String avgRating;
}
