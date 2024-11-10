class Solution {
    public String reverseWords(String s) {        
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i<s.length()) {
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int j = i;
            StringBuilder str = new StringBuilder();
            while(j < s.length() && s.charAt(j) != ' ') {
                System.out.println("j = " + j);
                str.append(s.charAt(j));
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