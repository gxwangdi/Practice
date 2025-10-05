/*
 Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
 
 Notice
 There is no need to read data from standard input stream. Both parameters are given in function aplusb, you job is to calculate the sum and return it.

 Clarification
Are a and b both 32-bit integers?

Yes.
Can I use bit operation?

Sure you can.
Example
Given a=1 and b=2 return 3
 * */
public class APlusBProblem {
	// recursive approach
    /*
   public int aplusb(int a, int b) {
       // write your code here, try to do it without arithmetic operators.
       if (b == 0) {
           return a;
       }
       if (a == 0) {
           return b;
       }
       int sum = a^b;
       int carry = (a&b) <<1;
       return aplusb(sum, carry);
   }*/
   
   // iterataive approach
   public int aplusb(int a, int b) {
       if (a == 0) {
           return b;
       }
       while (b!=0) {
           int sum = a^b;
           b = (a&b) <<1;
           a = sum;
       }
       return a;
   }
}




