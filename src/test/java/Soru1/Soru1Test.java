package Soru1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Soru1Test {
    @Test void firstTest(){
    }
    @Test void illegalArgumentTest(){
        Soru1 a = new Soru1();
        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.mergeStrings( "", "aars"));
    }
    @Test void sameSizeStringTest(){
        Soru1 a = new Soru1();
        String result = a.mergeStrings("hrte", "aars");
        Assertions
                .assertEquals("haratres", result);
    }
    @Test void firstStringLongerTest(){
        Soru1 a = new Soru1();
        String result = a.mergeStrings("knnulr", "ausza");
        Assertions
                .assertEquals("kanunsuzlar", result);
    }
    @Test void secondStringLongerTest(){
        Soru1 a = new Soru1();
        String result = a.mergeStrings("knnu", "auszlar");
        Assertions
                .assertEquals("kanunsuzlar", result);
    }
}
