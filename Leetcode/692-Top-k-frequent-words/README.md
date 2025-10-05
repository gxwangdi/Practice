
minHeap on frequency, then maintain K.

Note:
1. The comparator: (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()    String.compareTo() takes reverse order.

2. result is high to low, so list.add(0, minHeap.poll());
