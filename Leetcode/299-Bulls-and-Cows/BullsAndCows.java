import java.util.Arrays;

public class BullsAndCows {
    
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        Arrays.fill(numbers, 0);
        for (int i=0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s==g) {
                bulls ++;
            } else {
                if (numbers[s]<0)   cows++;
                if (numbers[g]>0)   cows++;
                numbers[g]--;
                numbers[s]++;
            }
        }
        return bulls+"A"+cows+"B";
    }
    
    
    /*
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int numA =0;
        int numB =0;
        if (secret == null || guess == null || secret.length() == 0 || guess.length() == 0) {
            sb.append(numA).append("A").append(numB).append("B");
            return sb.toString();
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<secret.length(); i++) {
            char a = secret.charAt(i);
            if ( a == guess.charAt(i))
                numA ++;
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a)+1);
            }
        }
        
        for (int i=0; i<guess.length(); i++) {
            char b = guess.charAt(i);
            if (!map.containsKey(b)) {
                continue;
            }
            numB++;
            int f = map.get(b);
            if (f == 1) {
                map.remove(b);
            } else {
                map.put(b, f-1);
            }
        }
        sb.append(numA).append("A").append(numB-numA).append("B");
        return sb.toString();
    }*/
    
}

