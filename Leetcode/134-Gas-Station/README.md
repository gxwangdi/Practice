
Well, the car gas tank is unlimited, so we just use greedy strategy, load as much gas as possible and aggregate the result in a new array

diff[i] = gas[i] - cost[i].
if diff[i] >0, we can start to collect element sum from there, if sum >=0 before it reaches i, then move forward,

else, return -1.
