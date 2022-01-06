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

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
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
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        boolean[] s1Alpha = new boolean[26];
        boolean[] s2Alpha = new boolean[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Alpha[s1.charAt(i) - 'a'] = true;
        }
        for(int i = 0; i < s2.length(); i++) {
            s2Alpha[s2.charAt(i) - 'a'] = true;
        }

        for(int i = 0; i < 26; i++) {
            if(s1Alpha[i] && s2Alpha[i]) {
                return "YES";
            }
        }
        return "NO";
    }

}