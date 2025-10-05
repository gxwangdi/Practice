
This is more like a sorting algorithm. Starting from the given state, how many steps do you need to go to ascending order, it is the answer.

O(nlogn).
Reference jiuzhang. The algorithm is like:
1. collect all element frequencies;
2. check from head to tail, if there is reverse order, then get the number of full permutation for the rest of the elements. 
3. acumulate all these numbers.

