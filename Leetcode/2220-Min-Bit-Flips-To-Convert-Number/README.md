To count the number of 1s in binary representation.

while (res > 0) {
    count ++;
    res = res & (res-1);
}
