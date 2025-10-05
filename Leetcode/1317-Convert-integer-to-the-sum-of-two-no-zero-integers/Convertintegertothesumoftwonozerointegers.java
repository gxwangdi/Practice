

class Convertintegertothesumoftwonozerointegers {
//     public int[] getNoZeroIntegers(int n) {
//         String str = String.valueOf(n);
//         StringBuilder sb = new StringBuilder();
//         int carry = 0;

//         for (int i=str.length()-1; i>0; i--) {
//             char c = str.charAt(i);
//             if (c - carry -1 >0) {
//                 sb.append(c-carry-1);
//                 carry = 0;
//                 continue;
//             }
//             carry = 1;
//             c += 10;
//             sb.append((c-'0')/2);
//         }
//         sb.append(str.charAt(0) - carry - 1 - '0');
//         int i1 = Integer.parseInt(sb.reverse().toString());
//         int i2 = n - i1;
//         return new int[]{i1, i2};
//     }

    public int[] getNoZeroIntegers(int n) {

        int a=0, b=0, step=1;

        while (n>0) {
            int d = n % 10; // digit
            n /= 10;

            if ((d == 0 || d == 1) && n>0) { // n>0 evades the case when 1 is the most significant digit
                a += step*(1+d);
                b += step*9;
                n--; // handle carry
            } else {
                a += step*1;
                b += step*(d-1);
            }
            step *= 10;
        }

        return new int[]{a,b};
    }
}
