package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
   String description;

   //@OneToMany(mappedBy = "category")
   //List<Product> products;
   /*@OneToMany(fetch = FetchType.EAGER)
   List<Product> productList;*/
}
