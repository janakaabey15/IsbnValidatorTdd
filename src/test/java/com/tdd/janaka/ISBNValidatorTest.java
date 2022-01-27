package com.tdd.janaka;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class ISBNValidatorTest {

    @Test
    public  void checkValid10digitISBN(){
       ISBNValidator validator = new ISBNValidator();
       boolean result = validator.checkISBN("0140449116");
       assertTrue(result);
       result = validator.checkISBN("0140177396");
        assertTrue(result);
    }
     @Test
     public void validate13DigitIsbnNumber(){

         ISBNValidator validator = new ISBNValidator();
         boolean result = validator.checkISBN("9780689818769");
         assertTrue(result);

     }
     @Test
     public  void checkAnIValid10DigitISBN(){
         ISBNValidator validator = new ISBNValidator();
         boolean result = validator.checkISBN("0140449117");

         assertFalse(result);
     }
     @Test
     public  void checkAnIValid13DigitISBN(){
         ISBNValidator validator = new ISBNValidator();
         boolean result = validator.checkISBN("9780689818760");

         assertFalse(result);

     }

    @Test

    public void  checkValidIsbnNumberEndsWithX(){
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

     @Test
     public void nineDigitIsbnNotAllowed(){
         ISBNValidator validator = new ISBNValidator();

         assertThrows(NumberFormatException.class,
                 () ->{
             validator.checkISBN("123456789");
         });


     }
     @Test
     public void shouldContainOnlyIntegers(){
        ISBNValidator validator = new ISBNValidator();
                assertThrows(NumberFormatException.class,()->validator.checkISBN("helloworld"));
     }






}