
Compare the element in the permutation sequence one by one would be a solution. It is just time comsuming.

Think of sorting the given permutation element, with bubble sort, after how many changes will the sequence becomes the first element, like totally ascending or descending order.

Another approach is like permutation index, get digit on each position, see which permutation it should be in, and add all these numbers. The thing is there are duplicate digits here.

Sometimes the index starts from 1, use long to keep index, fact and multiFact in case of overflow.

