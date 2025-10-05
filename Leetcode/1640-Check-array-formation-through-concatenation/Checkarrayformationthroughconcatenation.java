

class Checkarrayformationthroughconcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<pieces.length; i++) {
            if (pieces[i] == null) {
                continue;
            }
            map.put(pieces[i][0], i);
        }
        int cur = 0;
        while (cur < arr.length) {
            if (!map.containsKey(arr[cur])) {
                return false;
            }
            int i = map.get(arr[cur]);
            int j = 0;
            while(cur < arr.length && j < pieces[i].length) {
                if (arr[cur]!=pieces[i][j]) {
                    return false;
                }
                cur++;
                j++;
            }
            if (j < pieces[i].length) {
                return false;
            }
        }
        return cur == arr.length;
    }
}
