class Solution{
    public String addBinary(String a, String b ){
        int lenA = a.length();
        int lenB = b.length();

        if(lenA<lenB)return addBinary(b,a);

        char[] result = new char[lenA +1];
        int carry = 0;
        int k= lenA;
for (int i = lenA - 1, j = lenB - 1; i >= 0; i--) {
        // for(int i= lenA -1; j = lenB-1;i>=0; i--){
            carry += a.charAt(i)-'0';
            if(j>=0){
                carry+=b.charAt(j--) - '0';

            }
            result[k--]= (char)('0'+(carry & 1));
            carry>>=1;
        }

        if(carry == 1){
            result[k]='1';
            return new String(result);
        }
        return new String(result,1, lenA);
         }
}