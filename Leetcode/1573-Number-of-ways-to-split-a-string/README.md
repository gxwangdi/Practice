
Times Principle.  

Take care of all '0's, in that case it is C(len(s), 2).

Take care of the string length, x1 and x2 could be long, and need to do modulo first.

Take care of prefix '0's, it will incur Integer.parseInt(String, int) to throw exception.
