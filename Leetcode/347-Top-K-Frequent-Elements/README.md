
Firstly build a map, and scan all words.

And put then into a mini-heap, write the comparator based on description.

Space O(n), Time(nlogk).  

PAY ATTENTION to the comparator implementation ! ! ! !   



For bucket sort, it can be done in linear complexity.  The idea is that, the frequency value range can only be 1~nums.length, so create a list array with length nums.length+1.  [1, nums.length] for values collection.

Note that values with the same frequency can be added together even the result set size exceeds k.

for (... res.size() < k; ...) {
  if (bucket[pos] != null) {
  	res.addAll(bucket[pos]);
  }
}
