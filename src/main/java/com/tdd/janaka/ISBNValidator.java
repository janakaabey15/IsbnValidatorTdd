package com.tdd.janaka;

public class ISBNValidator {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbnNum) {

        if (isbnNum.length() == LONG_ISBN_LENGTH) {
            return isThisValidLongIsbn(isbnNum);
        } else if(isbnNum.length() == SHORT_ISBN_LENGTH) {
            return isThisValidShortIsbn(isbnNum);
        }
        throw new NumberFormatException("ISBN numbers must be 10 digits long");



    }

    private boolean isThisValidShortIsbn(String isbnNum) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbnNum.charAt(i))) {

                if (i == 9 && isbnNum.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN Numbers can Only Contains Numeric Digits");
                }
            } else {
                total += Character.getNumericValue(isbnNum.charAt(i)) * (SHORT_ISBN_LENGTH - i);
            }
        }


        return  (total % SHORT_ISBN_MULTIPLIER == 0);

    }

    private boolean isThisValidLongIsbn(String isbnNum) {
        int total =0;
        for(int i=0; i< LONG_ISBN_LENGTH;i++){
            if(i%2==0){
                total += Character.getNumericValue(isbnNum.charAt(i));
            }
            else {
                total += Character.getNumericValue(isbnNum.charAt(i))*3;
            }
        }
        return (total %LONG_ISBN_MULTIPLIER ==0);
    }
}
