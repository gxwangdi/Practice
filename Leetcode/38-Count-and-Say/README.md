
A naive solution is like, get the first one, and parse round by round, and see what we gonna append. 

double 11, append 21, double 2 append 22, single 1, append 11, single 2 append 12. 
Pretty much like a finite state machine. 

Space O(n), Time O(n2).     
＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
Well, just search online, looks like there is only naive approach.  Was trying to figure out a way to directly build up the nth string based on the rule, so Time could be O(n).    

  