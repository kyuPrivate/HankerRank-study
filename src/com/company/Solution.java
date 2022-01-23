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
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        // do not change
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int[] expenditureCountList;

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here

        // init & i = 0 case count
        int res = 0;
        expenditureCountList = new int[201]; // index 0 ~ 200
        for(int i = 0; i < d; i++) {
            expenditureCountList[expenditure.get(i)]++;
        }
        int doubleMedian = getDoubleMedian(d);
        if(expenditure.get(0 + d) >= doubleMedian) {
            res++;
        }


        // i = 1 ~
        for(int i = 1; i - 1 + d < expenditure.size() - 1; i++) {
            expenditureCountList[expenditure.get(i - 1)]--;
            expenditureCountList[expenditure.get(i - 1 + d)]++;
            doubleMedian = getDoubleMedian(d);
            if(expenditure.get(i + d) >= doubleMedian) {
                res++;
            }
        }

        return res;
    }

    public static int getDoubleMedian(int d) {
        int first = 0;
        int second = 0;

        if(d % 2 == 0) { // even
            int firstOrder = d / 2;
            int secondOrder = firstOrder + 1;

            for(int i = 0; i < 201; i++) {
                if(firstOrder - expenditureCountList[i] <= 0) {
                    first = i;
                    break;
                }
                firstOrder = firstOrder - expenditureCountList[i];
            }

            for(int i = 0; i < 201; i++) {
                if(secondOrder - expenditureCountList[i] <= 0) {
                    second = i;
                    break;
                }
                secondOrder = secondOrder - expenditureCountList[i];
            }
            return first + second;
        } else { // odd
            int firstOrder = d / 2 + 1;
            for(int i = 0; i < 201; i++) {
                if(firstOrder - expenditureCountList[i] <= 0) {
                    first = i;
                    break;
                }
                firstOrder = firstOrder - expenditureCountList[i];
            }
            return first * 2;
        }
    }

}