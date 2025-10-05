
For one solution, DPS + backtrace.

Or we can use DP. When passing one stone, count all the stones which it can reach, and record the jump length in the next stone. 
Finally, check the last stone`s jump length whether is null. If null, it represents that no stone can reach it, so return false, else true.

This way it will explore all possible approaches.

