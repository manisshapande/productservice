package com.example.productservice.Inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    String company;
    String avgRating;
}
