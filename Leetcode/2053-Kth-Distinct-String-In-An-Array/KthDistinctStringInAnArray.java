class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[j].equals(arr[i]))
                    count++;
            }
            if (count == 1) {
                k--;
                if (k == 0)
                    return arr[j];
            }
        }
        return "";
    }
}
