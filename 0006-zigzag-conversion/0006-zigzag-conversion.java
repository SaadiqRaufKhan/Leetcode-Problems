class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows == s.length()) return s;

        StringBuilder[] arr = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int dir = 1; // 1: down, -1: up
        int currRow = 0;
        for(int i=0; i<s.length(); i++) {
            if(currRow == numRows) {
                currRow -= 2;
                dir *= -1;
            }
            else if(currRow == -1) {
                currRow += 2;
                dir *= -1;
            }
            arr[currRow].append(s.charAt(i));
            
            if(dir > 0) currRow++;
            else currRow--;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb: arr) {
            // System.out.println(sb.toString());
            ans.append(sb);
        }

        return ans.toString();
    }
}