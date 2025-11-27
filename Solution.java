//import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Fast input reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }

            System.out.println(getMaxMex(a, n));
        }
    }

    public static int getMaxMex(int[] a, int n) {
        int mex = 0;
        long tokens = 0; // represents the extra "1s" we can use to grow towers

        for (int i = 0; i < n; i++) {
            tokens += a[i]; // accumulate tokens from knocking down a[i]
            if (tokens >= mex + 1) {
                mex++;
                tokens--; // use one token to construct height `mex`
            }
        }

        return mex;
    }
}
