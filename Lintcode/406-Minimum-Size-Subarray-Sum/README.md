
Looks like slow/fast pointer to get a sliding window, window length is fast-slow+1.

Use a sum to collect the sum in the sliding window, use min to record the min length,

If there is one element bigger or equals to s, return 1!

if sum < s, fast moves forward,
if sum >= s, update min, sum -= arr[slow], slow moves forward.

if sum < s && min == Integer.MAX_VALUE, return -1;

