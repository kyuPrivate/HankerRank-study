package com.company;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // do not change
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        // write code here
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.jumpingOnClouds(c);

        // do not change
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int res = 0;
        int index = 0;
        int lastIndex = c.size() - 1;

        return calc(res, index, lastIndex, c);
    }

    private static int calc (int res, int index, int lastIndex, List<Integer> c) {
        if (index + 1 >= lastIndex || index + 2 >= lastIndex) {
            return res + 1;
        }
        if (c.get(index + 2) == 0) {
            return calc(res + 1, index + 2, lastIndex, c);
        }
        if (c.get(index + 1) == 0) {
            return calc(res + 1, index + 1, lastIndex, c);
        }
        return 0;
    }



}