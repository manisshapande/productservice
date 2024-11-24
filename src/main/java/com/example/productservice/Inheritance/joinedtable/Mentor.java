package com.example.productservice.Inheritance.joinedtable;

import com.example.productservice.Inheritance.joinedtable.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_mentor")
public class Mentor extends User {
    String company;
    String avgRating;
}
