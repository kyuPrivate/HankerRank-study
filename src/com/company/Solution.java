package com.company;

import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        // do not change
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // write code here
        String s = bufferedReader.readLine();
        long n = Long.parseLong(bufferedReader.readLine().trim());
        long result = Result.repeatedString(s, n);

        // do not change
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here

        long stringSize = s.length();
        long repeatTime = n / stringSize;
        long remainLength = n % stringSize;

        long appearOriginLetterTime = 0;
        for (int i = 0; i < stringSize; i++) {
            if(s.charAt(i) == 'a') {
                appearOriginLetterTime++;
            }
        }

        long appearRemainLetterTime = 0;
        for (int i = 0; i < remainLength; i++) {
            if(s.charAt(i) == 'a') {
                appearRemainLetterTime++;
            }
        }


        return appearOriginLetterTime * repeatTime + appearRemainLetterTime;
    }

}