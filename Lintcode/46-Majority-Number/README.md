
We can sort it, which takes O(nlogn), then we can traverse it one by one, and calculate the frequency, or take the middle of the sorted array.

we can setup a map<value, frequency>, and get back when some frequency is bigger than half of the array size.

Space O(n), Time O(n).

For Time O(n), Space O(1) solution:
Keep one number, and a count. 
If cur == number, count++, or count--, if count == 0 number = cur.

At the end, number must be the one that appears more than half of the array.   

