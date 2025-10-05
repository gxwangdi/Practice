import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        num = Math.abs(num);
        Map<Integer, String> map = getMappings();
        if (num == 0) {
            return map.get(num);
        }
        
        StringBuilder sb = new StringBuilder();
        int count = num/1000000000;
        if (count != 0) {
            sb.append(getExpression(map, count));
            sb.append(" " + map.get(1000000000));
            num = num % 1000000000;
        }
        
        count = num/1000000;
        if (count != 0) {
            sb.append(getExpression(map, count));
            sb.append(" " + map.get(1000000));
            num = num % 1000000;
        }
        
        count = num/1000;
        if (count != 0) {
            sb.append(getExpression(map, count));
            sb.append(" " + map.get(1000));
            num = num % 1000;
        }
        
        if (num >0) {
            sb.append(getExpression(map, num));
        }
        
        if (sb.length()>0 && sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
    
    private String getExpression(Map<Integer, String> map, int num) {
        StringBuilder sb = new StringBuilder();
        int count = num/100;
        if (count != 0) {
            sb.append(" " + map.get(count) + " ");
            sb.append(map.get(100));
            num = num%100;
        }
        if (num > 0 && num < 20) {
            sb.append(" " + map.get(num));
        } else {
            count = num/10;
            if (count > 0) {
                sb.append(" " + map.get(count*10));
            }
            
            num = num%10;
            if (num > 0) {
                sb.append(" " + map.get(num));
            }
        }
        return sb.toString();
    }
    
    private Map<Integer, String> getMappings() {
        Map<Integer, String> res = new HashMap<>();
        res.put(1000000000, "Billion");
        res.put(1000000, "Million");
        res.put(1000, "Thousand");
        res.put(100, "Hundred");
        res.put(90, "Ninety"); 
        res.put(80, "Eighty");
        res.put(70, "Seventy");
        res.put(60, "Sixty");
        res.put(50, "Fifty");
        res.put(40, "Forty");
        res.put(30, "Thirty");
        res.put(20, "Twenty");
        res.put(19, "Nineteen");
        res.put(18, "Eighteen");
        res.put(17, "Seventeen");
        res.put(16, "Sixteen");
        res.put(15, "Fifteen");
        res.put(14, "Fourteen");
        res.put(13, "Thirteen");
        res.put(12, "Twelve");
        res.put(11, "Eleven");
        res.put(10, "Ten");
        res.put(9, "Nine");
        res.put(8, "Eight");
        res.put(7, "Seven");
        res.put(6, "Six");
        res.put(5, "Five");
        res.put(4, "Four");
        res.put(3, "Three");
        res.put(2, "Two");
        res.put(1, "One");
        res.put(0, "Zero");
        return res;
    }
}






