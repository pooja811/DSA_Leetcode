class Solution {
    public String fractionAddition(String exp) {
        int numer = 0, denom = 1;
        int i = 0, n = exp.length();
        
        while (i < n) {
            int sign = 1;
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                sign = (exp.charAt(i) == '-') ? -1 : 1;
                i++;
            }
            
            int num = 0;
            while (i < n && Character.isDigit(exp.charAt(i))) {
                num = num * 10 + (exp.charAt(i++) - '0');
            }
            num *= sign;
            
            i++; // skip '/'
            
            int den = 0;
            while (i < n && Character.isDigit(exp.charAt(i))) {
                den = den * 10 + (exp.charAt(i++) - '0');
            }
            
            numer = numer * den + num * denom;
            denom *= den;
        }
        
        int g = gcd(Math.abs(numer), denom);
        return (numer / g) + "/" + (denom / g);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}