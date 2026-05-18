class Solution {
    public int minJumps(int[] arr) 
    {
        int n = arr.length;

        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-- > 0)
            {
                int currIdx = q.poll();

                if(currIdx == n - 1) return steps;

                //================================================================
                //EXPLORE ALL POSSIBLE OPTIONS

                if(currIdx + 1 < n && !visited[currIdx + 1]) //OPTION-1 (Move Forward)
                {
                    visited[currIdx + 1] = true;
                    q.offer(currIdx + 1);
                }

                if(currIdx - 1 >= 0 && !visited[currIdx - 1]) //OPTION-2 (Move Backward)
                {
                    visited[currIdx - 1] = true;
                    q.offer(currIdx - 1);
                }

                for(int newIdx : mp.get(arr[currIdx])) //OPTION-3 (Move to same valued idx)
                {                                      //newIdx could be before currIdx or after currIdx
                    if(!visited[newIdx])
                    {
                        visited[newIdx] = true;
                        q.offer(newIdx);
                    }
                }

                //===================================================================
                mp.get(arr[currIdx]).clear(); //EXPLAINED BELOW :)
            }

            steps++;
        }

        return -1;
    }
}