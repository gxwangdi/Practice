
Binary Search
Check if c - a^2c−a^2 is a perfect square, is by making use of Binary Search. The method remains same as that of a typical Binary Search to find a number. The only difference lies in that we need to find an integer, midmid in the range [0, c - a^2][0,c−a^2], such that this number is the square root of c - a^2c−a^2. Or in other words, we need to find an integer, midmid, in the range [0, c - a^2](0,c−a^2), such that midmidxmid = c - a^2mid=c−a^2.

Fermat Theorem
This approach is based on the following statement, which is based on Fermat's Theorem:
"Any positive number nn is expressible as a sum of two squares if and only if the prime factorization of nn, every prime of the form (4k+3)(4k+3) occurs an even number of times."
By making use of the above theorem, we can directly find out if the given number cc can be expressed as a sum of two squares.
To do so we simply find all the prime factors of the given number cc, which could range from [2,\sqrt{c}](2,√c) along with the count of those factors, by repeated division. If at any step, we find out that the number of occurences of any prime factor of the form (4k+3)(4k+3) occurs an odd number of times, we can return a False value.
In case, cc itself is a prime number, it won't be divisible by any of the primes in the [2,\sqrt{c}](2,√c). Thus, we need to check if cc can be expressed in the form of 4k+34k+3. If so, we need to return a False value, indicating that this prime occurs an odd number(1) of times.
Otherwise, we can return a True value.

