package com.company;

import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        // do not change
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here

        int [] aCount = new int [26];
        int [] bCount = new int [26];// a.length = b.length
        int res = 0;

        for(int i = 0; i < a.length(); i++) {
            aCount[a.charAt(i) - 'a']++;
        }
        for(int i = 0; i < b.length(); i++) {
            bCount[b.charAt(i) - 'a']++;
        }


        for(int i = 0; i < 26; i++) {
            res += Math.abs(aCount[i] - bCount[i]);
        }

        return res;
    }

}