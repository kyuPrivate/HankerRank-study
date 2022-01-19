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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        Map<String, Integer> hashMap = new HashMap<>();
        int result = 0;


        for(int startPoint = 0; startPoint < s.length(); startPoint++) {
            int subStringLength = 1;
            for(int endPoint = startPoint + subStringLength; endPoint <= s.length(); endPoint = startPoint + subStringLength) {

                String subString = s.substring(startPoint, endPoint);

                char [] charArray = subString.toCharArray();
                Arrays.sort(charArray);
                String sortedSubString = new String(charArray);

                if(hashMap.get(sortedSubString) == null) {
                    hashMap.put(sortedSubString, 1);
                } else {
                    hashMap.put(sortedSubString, hashMap.get(sortedSubString) + 1);
                }
                subStringLength++;
            }
        }

        for(String sortedString : hashMap.keySet()) {
            int n = hashMap.get(sortedString);
            result = result + n * (n-1) / 2; // n Combination 2
        }

        return result;

    }

}
