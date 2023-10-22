package Soru2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Soru2Test {
    @Test void comparisionTest(){
        Soru2 a = new Soru2();
        int diff = a.comparision(new ArrayList<>(List.of(3, 1, 5, 23, 2, 4, 9, 10, 15, 31)));
        Assertions
                .assertEquals(1, diff);
    }
    @Test void outOfBounderyTest(){
        Soru2 a = new Soru2();
        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.comparision(new ArrayList<>(List.of(3, 1, 5, 23, 2, 4, 9, 10, 15, 31, 20001))));

        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.comparision(new ArrayList<>(List.of(3, 1, 5, 23, 2, 4, 9, 10, 15, 31, -20001))));

        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.comparision(new ArrayList<>(List.of())));
    }
}
