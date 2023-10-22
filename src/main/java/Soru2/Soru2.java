package Soru2;
import java.io.*;
import java.util.*;

public class Soru2 {
    /*package whatever //do not write package name here */

    int partition (List<Integer> a, int start, int end)
    {
        int pivot = a.get(end);
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {

            if (a.get(j) < pivot)
            {
                i++;
                int t = a.get(i);
                a.set(i,a.get(j) );
                a.set(j, t);
            }
        }
        int t = a.get(i+1);
        a.set(i+1, a.get(end));
        a.set(end, t);
        return (i + 1);
    }

    void quick(List<Integer> a, int start, int end)
    {
        if (start < end)
        {
            int p = partition(a, start, end);
            quick(a, start, p - 1);
            quick(a, p + 1, end);
        }
    }
    public int comparision(List<Integer> arr){

        if (arr.size() <1 || arr.size() > 1000){
            throw new IllegalArgumentException("girilen dizi boyut sınırlara uygun değildir");
        }
        int i = 0;
       // List<Integer> arr = new ArrayList<>();
        int diff = 1;
       // Scanner sc = new Scanner(System.in);
       // System.out.println("lütfen sayı girişi yapın: \n tamamlamak için bir harfe basınız \n");

       /* while (sc.hasNextInt()){
            arr.add(sc.nextInt());
            i++;
        }*/
        quick(arr,0, arr.size()-1);
        if (arr.get(0) < -20000 || arr.get(arr.size()-1) > 20000){
            throw new IllegalArgumentException("girilen dizi elemanları sınırlara uygun değildir");
        }

        for (i=0; i< arr.size()-1; i++) {
            int tempDiff = arr.get(i+1) - arr.get(i);
            if(i == 0)
                diff = tempDiff;
            diff = Math.min(diff, tempDiff);

        }
        System.out.println("girilen sayılar arasındaki en küçük fark: " + diff);

        for (i=0; i< arr.size()-1; i++) {
            if (arr.get(i+1) - arr.get(i) == diff)
                System.out.println(arr.get(i) + "  " + arr.get(i+1));
        }
        return diff;
    }

}
