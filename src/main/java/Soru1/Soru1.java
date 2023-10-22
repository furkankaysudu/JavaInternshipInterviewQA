package Soru1;

import java.util.Arrays;
import java.util.Scanner;

public class Soru1 {

    /*Scanner sc = new Scanner(System.in);
    String firstStr;
    String secondStr;*/

    public String mergeStrings(String firstStr, String secondStr){

      /*System.out.println("birinci metni giriniz: \n");
        firstStr = sc.nextLine();
        System.out.println("ikinci metni giriniz: \n");
        secondStr = sc.nextLine();*/

        char[] lettersFirst = firstStr.toCharArray();
        char[] lettersSecond = secondStr.toCharArray();
        if (lettersFirst.length >= 2500 || lettersSecond.length >= 2500){
            throw new IllegalArgumentException("karakter boyut sınırını aştınız");
        } else if (lettersFirst.length <1  || lettersSecond.length <1) {
            throw new IllegalArgumentException("karakter boyut sınırına uygun girdi yapınız");
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while(true){
            try{
                result.append(lettersFirst[i]);
            }catch (IndexOutOfBoundsException exception){
                return appendRemaining(i, lettersSecond, result);
            }
            try{
                result.append(lettersSecond[i]);
            }catch (IndexOutOfBoundsException exception){
               return appendRemaining(i, lettersFirst, result);
            }
            i++;
        }
    }

    private String appendRemaining(int i, char[] remainingLetters, StringBuilder result) {

        String resultStr = result.append(remainingLetters, i, remainingLetters.length-i).toString();
        if (resultStr.charAt(resultStr.length()-1 ) == resultStr.charAt(resultStr.length()-2)){
            resultStr = resultStr.substring(0, resultStr.length()-1);
        }
        return resultStr;

    }
}


























