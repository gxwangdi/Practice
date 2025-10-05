
Basically use a 2D prefix sum,   Sum[i][j] means the sum for all elements in [0...i][0...j].   

Then the area of (r1, c1)   (r2, c2) is calculated by Sum[r2][c2] - Sum[r2][c1-1] - Sum[r1-1][c2] + Sum[r1-1][c1-1].      

====================================================


