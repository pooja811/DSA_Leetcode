class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String d) {

        int n = pos.length;
        Integer[] order = new Integer[n];
        for(int i=0;i<n;i++) order[i]=i;

        Arrays.sort(order,(a,b)->pos[a]-pos[b]);

        boolean[] alive = new boolean[n];
        Arrays.fill(alive,true);

        Deque<Integer> st = new ArrayDeque<>();

        for(int idx:order){

            if(d.charAt(idx)=='R') st.push(idx);

            else{
                while(!st.isEmpty()){

                    int top = st.peek();

                    if(h[top] < h[idx]){
                        alive[top]=false;
                        st.pop();
                        h[idx]--;
                    }
                    else if(h[top] > h[idx]){
                        alive[idx]=false;
                        h[top]--;
                        break;
                    }
                    else{
                        alive[top]=false;
                        alive[idx]=false;
                        st.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(alive[i]) res.add(h[i]);

        return res;
    }
}