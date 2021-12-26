package com.company;

import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        // do not change
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        String path = bufferedReader.readLine();
        int result = Result.countingValleys(steps, path);

        // do not change
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}


class Result {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleyCount = 0;

        int heightLevel = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                heightLevel++;
            }
            else if (path.charAt(i) == 'D'){
                heightLevel--;
            }

            if (heightLevel == 0 && path.charAt(i) == 'U') { // valley가 성립하려면 이번에 해석한 paht.chatAt(i)이 U이면서 heightLevel을 0(해수면)으로 만들어야 한다.
                valleyCount++;
            }
        }
        return valleyCount;
    }
}
