class Solution {
    private Set<String> st;

    public String getHappyString(int n, int k) {
        st = new TreeSet<>();

        find("", n);

        if (st.size() < k) return "";

        int idx = 0;
        for (String str : st) {
            if (idx == k - 1) {
                return str;
            }
            idx++;
        }

        return "";
    }

    private void find(String str, int n) {

        if (str.length() == n) {
            st.add(str);
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {

            if (str.length() == 0 || ch != str.charAt(str.length() - 1)) {
                find(str + ch, n);
            }
        }
    }
}