class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(0,0,n,res,new StringBuilder(""));
        return res;
    }

    void backTracking(int open, int close, int n, List<String> res, StringBuilder sb){
        if(open == close && open == n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backTracking(open + 1, close,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open > close){
            sb.append(')');
            backTracking(open, close+1,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}