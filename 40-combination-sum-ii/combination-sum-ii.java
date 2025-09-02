import java.util.AbstractList;

class Solution {
    private void combinationSum2(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;
            list.add(candidates[i]);
            combinationSum2(candidates, target-candidates[i], i+1, list, ans);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> getResults(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum2(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ans;
            @Override
            public int size() {
                if(ans == null) ans = getResults(candidates, target);
                return ans.size();
            }
            @Override
            public List<Integer> get(int index) {
                if(ans == null) ans = getResults(candidates, target);
                return ans.get(index);
            }
        };
    }
}

// //Here sorting maybe useful as we have to avoid the duplciates.

// class Solution {
//     //This is for loop recursion solution, it is faster and takes 2ms and beats 99%.
//     private void combSumBackTrack(int[] candidates, int size, int target, int index, List<Integer> interRes, List<List<Integer>> answer) {

//         if(target == 0) {
//             answer.add(new ArrayList<>(interRes));
//             return;
//         }

//         if(target < 0 || index >= size) return;

//         for(int i = index; i < size; i++) {
//             //If there is two 4's then We don't want to avoid the second 4 simply beacuse there is duplicare. This duplicate removal is only not to use the same 4 again and again. So just check, if i > index, so the duplicate is ignored second time only. SEe the first example's input.
//             if(i > index && candidates[i] == candidates[i-1]) continue;

//             if(candidates[i] > target) break;
            
//             interRes.add(candidates[i]);
//             combSumBackTrack(candidates, size, target - candidates[i], i+1, interRes, answer);
//             interRes.removeLast();
//         }
//     }

//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> answer = new ArrayList<>();
//         int index = 0;
//         Arrays.sort(candidates); //Sort so to remove the duplicates.
//         combSumBackTrack(candidates, candidates.length, target, index, new ArrayList<>(), answer);
//         return answer;
//     }

    //The below solution uses pick, not-pick logic. This is high TC. Lets try with for loop recursion

    //  private void recurseCombSum(int ind, int[]candidates, int target, int currSum, 
    //                             List<Integer> interAns, HashSet<List<Integer>> setAns, int prevNum) {
    //     if(currSum == target) {
    //         setAns.add(new ArrayList(interAns));
    //         return;
    //     }
    //     if(ind >= candidates.length || currSum> target) return;

    //     if(prevNum != candidates[ind] && currSum + candidates[ind] <= target ) {
    //         interAns.add(candidates[ind]);
    //         recurseCombSum(ind+1, candidates, target, currSum+candidates[ind], interAns, setAns, prevNum);
    //         //Update the prevNum only when you are removing it from the List, not for above case, only for notPick
    //         //case, the updated prevNum be used
    //         prevNum = interAns.get(interAns.size() - 1);
    //         interAns.remove(interAns.size() - 1);
    //     }

    //     recurseCombSum(ind+1, candidates, target, currSum, interAns, setAns, prevNum);
    // }
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    //     List<Integer> interAns = new ArrayList<>();
    //     HashSet<List<Integer>> setAns = new HashSet<>();
    //     int currSum = 0, ind = 0, prevNum = -1;

    //     //Sorting an int[] using Arrays.sort() function 
    //     Arrays.sort(candidates);
        
    //     if(candidates.length > 0)
    //         recurseCombSum(ind, candidates, target, currSum, interAns, setAns, prevNum);
        
    //     List<List<Integer>> finalAns = new ArrayList<>(setAns);
    //     return finalAns;        
    // }
//}