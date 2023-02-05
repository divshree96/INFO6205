package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.util.Random;


public class Benchmark_Assignment2 {

    public static void main(String args[]) {
        Benchmark_Timer benchmarkTimer = new Benchmark_Timer<Integer[]>("Insertion sort BenchMark",
                (Integer[] arr)-> {
                    new InsertionSort().sort(arr, true);
                });

        int [] arr_length = {500, 1000, 2000, 4000, 8000, 16000, 32000};
        String[] arr_types = {"Random", "Ordered", "ReversedOrdered", "PartiallyOrdered" };
        for(String arr_type : arr_types) {
            System.out.println("\n");
            for(int i=0; i< arr_length.length; i++) {
                Integer[] sort_arr;
                sort_arr = generateArr(arr_type, arr_length[i]);
                double averageMilliSeconds = benchmarkTimer.run(sort_arr, 100);
                System.out.println("Average Time taken to sort a " + arr_type + " array of size "
                        + arr_length[i] + "is " + averageMilliSeconds +"ms");
            }

        }
    }

    public static Integer[] generateArr(String type, int size) {
        Integer[] arr = new Integer[size];
        Random random = new Random();

        switch(type) {
            case "Random":
                for(int i=0; i<size; i++)
                    arr[i] = random.nextInt();
                break;
            case "Ordered":
                for(int i=0; i<size; i++)
                    arr[i] = i;
                break;
            case "ReversedOrdered":
                for(int i=size-1; i>=0; i--)
                    arr[i] = i;
                break;
            case "PartiallyOrdered":
                int mid = size/2;
                for(int i=0; i<mid; i++)
                    arr[i] = i;
                for(int j=mid; j<size; j++)
                    arr[j] = size - j;
                break;
        }
        return arr;
    }
}
