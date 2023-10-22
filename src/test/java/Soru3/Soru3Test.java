package Soru3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Soru3Test {
    @Test void getShoppingListTest(){
        int sum = 0;
        Soru3 a = new Soru3();
        List<Integer> arr = new ArrayList<>();
        List<ProductPrice> result = a.getShoppingList(new ArrayList<>(List.of(5, 6, 4, 3, 4)));

        for (int i = 0; i< result.size(); i++){
            sum += (result.get(i).discountApplied)? result.get(i).discountedPrice : result.get(i).price;
            if(!result.get(i).discountApplied){
                arr.add(result.get(i).price);
            }
        }
        arr = arr.stream().sorted().toList();

        Assertions
                .assertEquals(15, sum);
        Assertions
                .assertEquals(3, arr.size());
    }
    @Test void outOfBounderyTest(){
        Soru3 a = new Soru3();
        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.getShoppingList(new ArrayList<>(List.of(5, 6, 4, 3, 4, 2001))));

        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.getShoppingList(new ArrayList<>(List.of(5, 6, 4, 3, 4, -1))));

        Assertions
                .assertThrows(IllegalArgumentException.class,()->a.getShoppingList(new ArrayList<>(List.of())));
    }
}
