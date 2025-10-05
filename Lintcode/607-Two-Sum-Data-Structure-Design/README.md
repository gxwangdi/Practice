
Bidirectional linkedlist is best for two-pointer approach. 
Somehow the above has an NPE at last two lines in add() 
"cur.prev.next = node;"

Use find the counter will be much simpler, cause we only care about if there exists, do not care about where is the first or last pair.