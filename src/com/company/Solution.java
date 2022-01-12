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
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // do not change
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // write code here

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        // do not change
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long res = 0l;

        // arr element를 key로 element의 등장횟수를 value로 하는 rightMap에 넣는다.
        LinkedHashMap<Long, Long> rightMap = new LinkedHashMap<>();
        LinkedHashMap<Long, Long> leftMap = new LinkedHashMap<>();
        for(Long element : arr) {
            if(rightMap.get(element) == null) {
                rightMap.put(element, 1l);
            } else {
                rightMap.put(element, rightMap.get(element) + 1l);
            }
        }

        // arr의 데이터가 모두 같으면 n Cobination 2 를 반환한다.
        if(rightMap.size() == 1) {
            long n = arr.size();
            return n * (n-1) * (n-2) / 6;
        }

        for(Long middle : arr) {
            // value를 rightMap에서 갯수 -1 (0이 되면 제거)
            if(rightMap.get(middle) == 1l) {
                rightMap.remove(middle);
            } else {
                rightMap.put(middle, rightMap.get(middle) - 1l);
            }

            // mod가 0이 아니면 leftMap에 middle 추가하고 다음 middle로 이동
            long mod = middle % r;
            if (mod != 0l) {
                if(leftMap.get(middle) == null) {
                    leftMap.put(middle, 1l);
                } else {
                    leftMap.put(middle, leftMap.get(middle) + 1l);
                }
                continue;
            }

            long leftValue = middle / r;
            long rightValue = middle * r;

            if(leftMap.get(leftValue) != null && rightMap.get(rightValue) != null) {
                res += leftMap.get(leftValue) * rightMap.get(rightValue);
            }

            // leftMap에 middle 추가하고 다음 middle로 이동
            if(leftMap.get(middle) == null) {
                leftMap.put(middle, 1l);
            } else {
                leftMap.put(middle, leftMap.get(middle) + 1l);
            }
        }
        return res;
    }
}