/*
 Find the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

 Notice

The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases. 

Example
Given 1, return 0

Given 2, return 1

Given 10, return 34
**/       
public class Fibonacci {
	/* // Recursive.
    public int fibonacci(int n) {
        // write your code here
        if (n < 0) {
            return -1;
        }
        int[] init = {0, 1};
        if (n < 3) {
            return init[n - 1];
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }*/
    
    // Dynamic programming.
    public int fibonacci(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        
        dp[1] = 1;
        if (n < 3) {
            return dp[n -1];
        }
        for (int i=2; i<n; i++) {
            dp[i%2] = dp[(i-1)%2] + dp[(i-2)%2];
        }
        return dp[(n-1)%2];
    }
}





