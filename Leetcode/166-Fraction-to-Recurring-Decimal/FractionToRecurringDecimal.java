import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();    
        sb.append((numerator>0)^(denominator>0)?"-":""); // Deal with symbol first!   
        
        // expand to long positive to deal with possible overflow by Integer.MIN_VALUE.
        long num = Math.abs((long)numerator); 
        long den = Math.abs((long)denominator); 
        
        // Integral part 
        sb.append(num/den);     
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length()); 
        while (num != 0) {
            num*=10;
            sb.append(num/den);
            num%=den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }// end of fractionToDecimal       
}




