
One single heap can do the job! maxHeap!

This is simple, but when k is pretty large, it will have TLE issue. Look at chanllege it requires O(n) time.

Prepare a two end queue, every new element comes in, remove elements at the tail that are smaller than the new element.
