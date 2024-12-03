package com.example.productservice.controllers;

import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.SelfProductService;

import com.example.productservice.services.TokenService;
import org.hibernate.cache.spi.access.UnknownAccessTypeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

   ProductService productService;

   TokenService tokenService;

   // public ProductController(@Qualifier("SelfProductService") ProductService productService, SelfProductService selfProductService) {
    public ProductController(ProductService productService, TokenService tokenService) {
        this.productService = productService;
        this.tokenService = tokenService;
    }

    @GetMapping("/{id}")
    //public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
    public Product getProductById(
           // @RequestHeader("Token") String token,
            @PathVariable("id") Long id) throws ProductNotFoundException {
            /*if (!tokenService.validateToken(token)){
                throw new UnknownAccessTypeException("User is not authorized");
            }*/
        Product product = null;
        //try {
             product = productService.getProductById(id);
        /*}catch(InstanceNotFoundException e){
            //throw new RuntimeException(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        ResponseEntity<Product> productResponseEntity;
/*        if (product == null){
            productResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return productResponseEntity;
        }*/
        //productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        //return productService.getProductById(id);
        //return productResponseEntity;

        return product;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
       return productService.replaceProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

/*    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleInstanceNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(exception.getId());
        productNotFoundExceptionDto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }*/



}
