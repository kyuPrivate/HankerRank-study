package com.company;

import java.io.*;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swapCount = 0;
        for(int i = 0; i < arr.length; ) {
            if (arr[i] != i + 1) {
               swap(arr, i, arr[i] - 1);
               swapCount++;
            } else {
                i++;
            }
        }
        return swapCount;
    }

    static void swap (int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr [b];
        arr[b] = temp;
    }

}


