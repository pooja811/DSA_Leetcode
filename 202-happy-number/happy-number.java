class Solution {
   public static boolean isHappy(int n) {
		int s =n;
        int f =n;
         do{
            s = digitCount(s);
            f = digitCount(digitCount(f));
         }while(s != f);
         
         return s==1;
	}

	public static int digitCount(int n) {
		int sum = 0;
		while (n > 0) {
			int temp = n % 10;
			sum += temp * temp; 
			n = n / 10;
		}
		return sum;
	}
}