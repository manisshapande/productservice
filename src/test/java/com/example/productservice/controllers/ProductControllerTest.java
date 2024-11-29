package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    //@MockBean(name = "SelfProductService")
    @MockBean
    private ProductService productService;

    @Test //(expected = IndexOutOfBoundsException.class)
    void getProductByIdThrowsException() throws ProductNotFoundException {
        //Arrange
        long productId = 2L;
        Product product = new Product();
        product.setId(2L);
        product.setTitle("Test Product");

        when(productService.getProductById(2L))
                .thenThrow(ProductNotFoundException.class);

        //Act & Assert
        Assertions.assertThrows(ProductNotFoundException.class,
                ()-> productController.getProductById(productId));//.getBody());

    }

    @Test
    void getProductById() throws ProductNotFoundException {
        //Arrange
        long productId = 2L;
        Product product = new Product();
        product.setId(2L);
        product.setTitle("Test Product");

        when(productService.getProductById(2L)).thenReturn(product);

        //Act
        Product p = productController.getProductById(productId);//.getBody(); used by responseentity but now we are using product in Productcontroller

        //Assert
        //assert p != null;
        Assertions.assertEquals("Test Product",p.getTitle());
    }

    @Test
    void createProduct() throws ProductNotFoundException {
        // Arrange
        long productId = 2L;
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Test Product");

        //when(productService.createProduct(product)).
        doNothing().when(productService.createProduct(product));

        // Act
        Product p = productController.getProductById(productId);

        //Assert
        verify(productService.createProduct(product));
        //Assertions.assertEquals("Test Product", p.getTitle());
    }
}