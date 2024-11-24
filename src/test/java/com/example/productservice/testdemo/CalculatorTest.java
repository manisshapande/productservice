package com.example.productservice.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    /*
    When --- then ---
    */
    @Test
    void wheAddTwoIntegersThenRightResultExpected() {
        //Arrange
        int a = 10;
        int b = 20;
        Calculator calculator = new Calculator();

        //Act
        int result = calculator.add(a, b);

        //Arrange
        assertEquals(40, result);
/*        if (result == 30){
            System.out.println("Success");
        }else {
            System.out.println("Failure");
            throw new RuntimeException("Failure");
        }*/
    }

    @Test
    void divide() {
        //Arrange
        int a = 10;
        int b = 0;
        Calculator calculator = new Calculator();

        //Act
        //int result = calculator.divide(a,b);

        //Assert
        Assertions.assertThrows(ArithmeticException.class, ()->calculator.divide(a,b));
    }
}