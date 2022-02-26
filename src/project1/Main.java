package project1;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        ExampleClass1 hybridSort = new ExampleClass1();

        Random rand = new Random(); 


        // example class 1
        System.out.println("size of array: ");
        int[] array = new int[input.nextInt()];
        // System.out.println("nums = ");
        for(int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);
        // insertion sort
        // int[] arrayI = new int[input.nextInt()];
        // System.out.println("nums = ");
        // for(int i = 0; i < arrayI.length; i++)
        //     arrayI[i] = input.nextInt();
        
        // long startI = System.nanoTime();
        // insertionSort.insertionSort(arrayI);
        // long endI = System.nanoTime();
        // long elapsedTimeI = (endI - startI)/1000; 
        
        // System.out.println(Arrays.toString(arrayI));
        // System.out.println("excution time " + elapsedTimeI + " us");

        // mergesort
        
        long startM = System.nanoTime();
        mergeSort.mergeSort(array, 0, array.length-1);
        long endM = System.nanoTime();
        long elapsedTimeM = (endM - startM)/1000; 
        
        System.out.println(Arrays.toString(array));
        System.out.println("excution time " + elapsedTimeM + " us");

        // hybrid sort
        


        input.close();
    }
}
