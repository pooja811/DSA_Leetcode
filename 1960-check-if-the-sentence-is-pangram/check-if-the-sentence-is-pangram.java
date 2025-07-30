class Solution {
    public boolean checkIfPangram(String sentence) {
        // Set<Character> charSet = new HashSet<>();
        // for(int i=0; i<sentence.length();i++){
        //     char c = sentence.charAt(i);
        //     charSet.add(c);
        // }
        // return charSet.size()==26;


        boolean[] arr = new boolean [26];
        for(int i =0 ; i<sentence.length() ; i++){
            arr[sentence.charAt(i) - 'a'] = true;
        }
        for(boolean c : arr){
            if(!c){
                return false;
            }
        }
        return true;
    }
}