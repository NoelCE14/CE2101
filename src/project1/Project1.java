package project1;

import java.util.*;

public class Project1 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ExampleClass1 hybridSort = new ExampleClass1();
        MergeSort mergeSort = new MergeSort();

        Random rand = new Random(); 


        // example class 1
        System.out.println("size of array: ");
        int[] arrayH = new int[input.nextInt()];
        // System.out.println("nums = ");
        for(int i = 0; i < arrayH.length; i++)
            arrayH[i] = rand.nextInt(100);
        int[] arrayM = Arrays.copyOf(arrayH, arrayH.length);

        System.out.println("minimium size of blk: ");
        int s = input.nextInt();

        // Merge sort
        long startH = System.nanoTime();
        hybridSort.hybridSort(arrayH, 0, arrayH.length-1, s);
        long endH = System.nanoTime();
        long elapsedTimeH = (endH - startH)/1000; 
        
        System.out.println(Arrays.toString(arrayH));
        System.out.println("Hybrid sort excution time " + elapsedTimeH + " us");


        // Merge sort
        long startM = System.nanoTime();
        mergeSort.mergeSort(arrayM, 0, arrayM.length-1);
        long endM = System.nanoTime();
        long elapsedTimeM = (endM - startM)/1000; 
        
        System.out.println(Arrays.toString(arrayM));
        System.out.println("Merge sort excution time " + elapsedTimeM + " us");


        input.close();
    }
}
