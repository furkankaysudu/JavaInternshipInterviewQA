package Soru3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Soru3 {

    //Scanner sc = new Scanner(System.in);
    int i = 0;
   // List<Integer> prices = new ArrayList<>();
    List<ProductPrice> example = null;

    public List<ProductPrice> getShoppingList(List<Integer> prices){
       // System.out.println("alış veriş listesi giriniz: \n durmak için bir tuşa basın \n");
       /* while (sc.hasNextInt()){
            prices.add(sc.nextInt());
        }*/
        if (prices.size() < 1 || prices.size() > 100){
            throw new IllegalArgumentException("girilen dizi boyut sınırlara uygun değildir");
        }

        example = prices.stream().map(integer -> {
            if (integer > 2000 || integer < 0){
                throw new IllegalArgumentException("girilen dizi boyut sınırlara uygun değildir");
            }
            return new ProductPrice(integer, 0, false);
        }).toList();

        return chekDiscount();
    }
    public List<ProductPrice> chekDiscount(){
        for (i=0; i< example.size()-1; i++){
            if (example.get(i).price > example.get(i+1).price){
                example.get(i).discountedPrice = example.get(i).price - example.get(i+1).price;
                example.get(i).discountApplied = true;
            }
        }
       // return example;
        return getResult();
    }
    public List<ProductPrice> getResult(){

        List<Integer> undiscounted = new ArrayList<>();
        System.out.println("Sepet tutarı: \n");
        for (i=0; i< example.size(); i++){
            if (!example.get(i).discountApplied){
                System.out.println(example.get(i).price + " " );
                undiscounted.add(example.get(i).price);
            }else {
                System.out.println(example.get(i).discountedPrice + " " );
            }
        }
        undiscounted = undiscounted.stream().sorted().toList();

        System.out.println(undiscounted);
        return example;
    }
}
