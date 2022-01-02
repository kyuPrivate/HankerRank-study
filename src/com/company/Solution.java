package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
        // do not change
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // write code here
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        // do not change
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size() - 2; i++){
            for(int j = 0; j < arr.get(i).size() - 2; j++) {
                int sumOfHourGlass = getHourGlassSum(arr, i, j);
                if (maxSum < sumOfHourGlass) {
                    maxSum = sumOfHourGlass;
                }
            }
        }
        return maxSum;
    }

    public static int getHourGlassSum(List<List<Integer>> arr, int i, int j) {
        return arr.get(i).get(j)        + arr.get(i).get(j + 1)         + arr.get(i).get(j + 2)
                                        + arr.get(i + 1).get(j + 1)
             + arr.get(i + 2).get(j)    + arr.get(i + 2).get(j + 1)     + arr.get(i +2).get(j + 2);
    }

}