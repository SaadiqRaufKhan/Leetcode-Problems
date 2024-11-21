class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        
        StringBuilder s = new StringBuilder();
        helper(digits, 0, map, s, ans);
        
        return ans;
        
    }
    
    void helper(String input, int i, HashMap<Character, String> map, StringBuilder s, List<String> ans) {
        if(i >= input.length()) {
            ans.add(s.toString());
            return;
        }
        
        Character curr_char = input.charAt(i);
        String curr_str = map.get(curr_char);
        
        for(int j=0; j<curr_str.length(); j++) {
            s.append(curr_str.charAt(j));
            // System.out.println("i = " + i + " j = " + j + " s = " + s);
            helper(input, i+1, map, new StringBuilder(s.toString()), ans);
            s.deleteCharAt(s.length()-1);
        }
    }
}