class Solution {
    boolean divides(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 == 0 || l2 == 0 || l1 % l2 != 0) return false;

        int n = l1 / l2;

        String s3 = "";
        while(n > 0) {
            s3 += s2;
            n--;
        }

        return s1.equals(s3);
    }
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder res = new StringBuilder();

        String ans = "";
        int i = 0;

        while(i < str1.length() && i < str2.length()) {
            if(str1.charAt(i) == str2.charAt(i)) {
                res.append(str1.charAt(i));
                if(divides(str1, res.toString()) && divides(str2, res.toString())) {
                    ans = res.toString();
                }
                i++;
            }
            else break;
        }

        if(divides(str1, res.toString()) && divides(str2, res.toString())) {
            ans = res.toString();
        }
        return ans;
    }
}