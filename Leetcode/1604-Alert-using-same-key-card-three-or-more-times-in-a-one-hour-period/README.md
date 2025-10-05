
1. Make sure to clarify "Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.", The approach is different for each scenario.   For leetcode, the accepted approach seems the later.

2. Compare "list.get(i+1)-list.get(i)<=60 && list.get(i+2)-list.get(i+1)<=60" vs "list.get(i+2) - list.get(i) <= 60" for simplicity and efficiency.

3. Set<> vs List<>, if 10:00 and 11:00 will be put into the Map<hour, [minutes]>, then we should not reduce duplicate.  
