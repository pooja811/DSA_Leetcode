class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character>[] arr = new ArrayList[s.length()+1];
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        map.keySet().forEach(
            c->{
                if(arr[map.get(c)] == null){
                    arr[map.get(c)] = new ArrayList();
                }
                arr[map.get(c)] .add(c);
            }
        );

        for(int i= arr.length-1; i>0 ;i--){
            if(arr[i]!= null){
                for(Character c : arr[i]){
                    for(int j =0; j<i ;j++){
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}