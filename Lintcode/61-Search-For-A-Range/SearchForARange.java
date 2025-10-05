
public class SearchForARange {
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    /*
    public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start, end, mid;
        int[] bound = new int[2]; 
        
        // search for left bound
        start = 0; 
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
    }*/
    
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if (A == null || A.length == 0) {
			return res;
		}

		int first = getEarliestTarget(A, 0, A.length - 1, target);
		if (first == -1) {
			return res;
		}
		int last = getLatestTarget(A, first, A.length - 1, target);
		res[0] = first;
		res[1] = last;
		return res;
	}

	private int getEarliestTarget(int[] arr, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				end = mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (arr[start] == target) {
			return start;
		}
		return -1;
	}

	private int getLatestTarget(int[] arr, int start, int end, int target) {
		if (start > end) {
			return -1;
		}
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				start = mid;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if (arr[end] == target) {
			return end;
		}
		if (arr[start] == target) {
			return start;
		}
		return -1;
	}
}
