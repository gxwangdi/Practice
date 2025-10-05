
class CountSquareSumTriples {
    public int countTriples(int n) {
        Map<Integer, Integer> squ = new HashMap<>();
        for(int i=1; i<=n; i++) {
            squ.put(i*i, i);
        }
        int count = 0;
        for(int a=1; a<n; a++) {
            for(int b=a+1; b<n; b++) {
                int sum = a*a + b*b;
                if (squ.containsKey(sum)) {
                    count +=2;
                }
            }
        }
        return count;
    }
}
