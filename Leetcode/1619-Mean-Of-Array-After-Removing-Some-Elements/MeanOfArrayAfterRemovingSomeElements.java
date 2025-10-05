
class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int small = arr.length*5/100;
        int large = arr.length*5/100;
        double sum = 0;
        double count = 0;
        for(int i=small; i<arr.length-large; i++) {
            sum += (double)arr[i];
            count++;
        }
        return sum/count;
    }
}
