
class VAlidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length - 1;
    int i = 0;
    while(i < n && arr[i] < arr[i+1]) {
        i++;
    }

    if(i == n || i == 0) {
        return false;
    }

    while(i < n && arr[i] > arr[i+1]) {
        i++;
    }

    return i == n;
    }
}
