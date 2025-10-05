

This is a nice approach. Starting from the end condition, 1 for A, -1 for B.

check rows, cols, diagonal1 is r==c, diagonal2 is r+c==2.

If any of these reaches 3, then it is A, if it is -3, it is B. Use turn ==1? and turn *= -1 to save a lot of boiler plate code.

It could be the case that the moves does not full fill the game. "Draw" vs "Pending"
