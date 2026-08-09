class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0) return 0;

        int p = 0;
        boolean neg = false;

        if (s.charAt(0) == '-') {
            neg = true;
            p = 1;
        } else if (s.charAt(0) == '+') {
            p = 1;
        }

        long ans = 0;

        for (int i = p; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c < '0' || c > '9') {
                break;
            }

            ans = ans * 10 + (c - '0');

            if (!neg && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (neg && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return neg ? (int) -ans : (int) ans;
    }
}