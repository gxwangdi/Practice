
We can use greedy method to solve this.
num1 can take charge of i(0<=i<=k) numbers and num2 can the charge of the rest k-i numbers
Now the question is: how to get maximum number(x digits) from an array

Recall Remove Duplicate Letters, we can use a stack. we scan the array, when the stack is not empty, and current integer in the array is greater than current stack peek(), we pop the stack, as long as the rest of the array can gurantee to provide enough integers to form an integer of k bits.

Now we have two maximum array, with one size of i and another size of k-i, now we should combine the two into one maximum integer

It's like merge sort.
But pay attention to the case where two digit are equal, which to choose?
example:
6 0
6 0 4
we should choose the second 6 first. So we should write a compare function that compare two array till the end, not just the current two digits.