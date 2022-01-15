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
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        int[] countArray = new int[queries.size() + 1];
        List<Integer> res = new ArrayList<>();

        for(List<Integer> query : queries) {
            int operationCode = query.get(0);
            int value = query.get(1);

            if (operationCode == 1) { // add to map
                if(dataMap.get(value) == null) {
                    countArray[1]++;
                    dataMap.put(value, 1);
                } else {
                    countArray[dataMap.get(value)]--;
                    countArray[dataMap.get(value) + 1]++;
                    dataMap.put(value, dataMap.get(value) + 1);
                }
            }
            else if (operationCode == 2) {
                if (dataMap.get(value) == null) {
                    // no action
                } else {
                    if(dataMap.get(value) == 1) {
                        countArray[0]++;
                        dataMap.remove(value);
                    } else {
                        countArray[dataMap.get(value)]--;
                        countArray[dataMap.get(value) - 1]++;
                        dataMap.put(value, dataMap.get(value) - 1);
                    }
                }
            }
            else if (operationCode == 3) {
                if(countArray[value] <= 0) {
                    res.add(0);
                } else {
                    res.add(1);
                }
            }
            else {
                // exception case
            }
        }

        return res;
    }
}


