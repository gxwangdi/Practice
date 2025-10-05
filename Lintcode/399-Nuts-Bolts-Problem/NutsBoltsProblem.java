

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
class NBComparator {
	public int cmp(String a, String b) {
		return 1;
	}
}

public class NutsBoltsProblem {
	/**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) {
            return;
        }
        if (nuts.length != bolts.length) {
            return;
        }
        
        int totalLength = nuts.length;
        qsort(nuts, bolts, 0, totalLength-1, compare);
    }
    
    private void qsort(String[] nuts, String[] bolts
     , int l, int r, NBComparator compare) {
        if (l >= r) {
            return;
        }
        // Find partition index for nuts, with bolts[l]
        int partIndex = partition(nuts, bolts[l], l, r, compare);
        // Partition bolts, with nuts[partIndex]
        partition(bolts, nuts[partIndex], l, r, compare);
        
        // quick sort recursively
        qsort(nuts, bolts, l, partIndex - 1, compare);
        qsort(nuts, bolts, partIndex + 1, r, compare);
    }
    
    private int partition(String[] arr, String pivot, int l, int r, NBComparator compare) {
        // pivot is from another array
        int m = l;
        for (int i = l + 1; i <= r; i++) {
            if (compare.cmp(arr[i], pivot) == -1 || compare.cmp(pivot, arr[i]) == 1) {
                m++;
                swap(arr, i, m);
            } else if (compare.cmp(arr[i], pivot) == 0 || compare.cmp(pivot, arr[i]) == 0) {
                swap(arr, i, l);
                i--;
            }
        }
        swap(arr, m, l);
        return m;
    }
    
    private void swap(String[] arr, int l, int r) {
        String temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
