// import java.util.Arrays;
import java.util.Vector;
class Solution {
    
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int sum = 0;
        for(int s: skill) {
            sum += s;
        }
        
        if(sum % teams != 0) return -1;
        
        int sumPerTeam = sum / teams;
        
        Arrays.sort(skill);
        
        int i = 0;
        int j = n - 1;
        // Vector<Integer> vec = new Vector<Integer>();
        long res = 0;
        while(i < j) {
            if(skill[i] + skill[j] == sumPerTeam) {
                // vec.addElement(skill[i] * skill[j]);
                res += (skill[i] * skill[j]);
            }
            else {
                return -1;
            }
            i++; j--;
        }
        
//         long res = 0;
//         for(int v: vec) {
//             res += v;
//         }
        return res;
        
    }
}





