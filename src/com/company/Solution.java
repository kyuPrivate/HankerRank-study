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
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // do not change
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        for(int i = 0; i < q.size(); i++) {
            if (q.get(i) > i + 3) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int swapCount = 0;
        int n = q.size();
        boolean flag = false;

        for(int i = 0; i < n - 1; i++) {
            flag = false;;
            for (int j = 0; j < n - 1 - i; j++) {
                if(q.get(j) > q.get(j + 1)) {
                    flag = true;
                    swap(q, j, j + 1);
                    swapCount++;
                }
            }
            if (flag == false) {
                break;
            }
        }

        System.out.println(swapCount);
    }

    public static void swap(List<Integer> q, int a, int b) {
        int temp = q.get(a);
        q.set(a, q.get(b));
        q.set(b, temp);
    }
}
