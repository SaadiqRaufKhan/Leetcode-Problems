class Solution {
    public String reverseWords(String s) {
        // String ans = s.trim();
        
        List<String> list = new ArrayList<>();
        String ans = s;
        int i = 0;
        while(i<ans.length()) {
            if(ans.charAt(i) == ' ') {
                i++;
                continue;
            }
            int j = i;
            StringBuilder str = new StringBuilder();
            while(j < ans.length() && ans.charAt(j) != ' ') {
                System.out.println("j = " + j);
                str.append(ans.charAt(j));
                j++;
            }
            list.add(str.toString());
            System.out.println(str.toString());
            i = j;
        }
        
        StringBuilder str = new StringBuilder();
        
        for(int k=list.size()-1; k>=0; k--) {
            str.append(list.get(k));
            if(k != 0) {
                str.append(" ");    
            }
            
        }
        
        return str.toString();
        
        
    }
}