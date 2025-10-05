
//TODO(gxwangdi):comment is not complete at this time, needs more work.

it does not require some certain time/space complexity, then we can use a map.

every single set/get would need to update frequency, and remove/update/insert on heap takes O(logc), c is the capacity.
For now, it deals with frequency properly, but when more than two elements have the same frequency, then we will need to remove the earlier one, which is not handled properly.

