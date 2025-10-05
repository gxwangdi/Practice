
We all know how to deal with pow(a, b), now the thing is, how to deal with the int array for b.     

The main idea is cashed on the repeated pattern of the remainder of a^b.
As long as we know the length of the pattern m, we just have to find an index point of this pattern based on b mod m.
In addition, if a > 1337, we can let a = a mod 1337.    

