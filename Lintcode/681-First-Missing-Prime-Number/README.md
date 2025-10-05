First of all, hard code to check 2,3,5,7, if something is missing, return, or add them all into a list.

For each iteration, we have list, start_index, end_index. if there are any number between nums[start_index] and nums[end_index] that is prime number, return it; or if nums[end_index] is prime number, add nums[end_index] into the list, and move the window to the next.

If traversing the whole array and we cannot find the minimum prime number, then return the first prime number after the biggest element in the array.


It does not say the input array is sorted, and all elements are prime, then the algorithm above does not work. Sorting takes O(nlogn), to use sieve of Eratosthenes algorithm takes O(n) for Time, and O(n) for Space.

Well, actually TreeSet would take overall O(nlogn) time, while HashSet would take more than O(n) space.

