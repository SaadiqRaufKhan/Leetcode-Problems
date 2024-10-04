class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        int n = skill.size();
        int teams = n/2;
        
        int sum = 0;
        for(int s: skill) sum += s;
        
        if(sum % teams != 0) return -1;
        
        int sumPerTeam = sum / teams;
        
        sort(skill.begin(), skill.end());
        
        // vector<int> :: iterator i = skill.begin();
        // vector<int> :: iterator j = skill.end() - 1;
        
        int i = 0;
        int j = n - 1;
        
        long res = 0;
        
        while(i < j) {
            if(skill[i] + skill[j] == sumPerTeam) {
                res += (skill[i] * skill[j]);
            }
            else {
                return -1;
            }
            i++; j--;
        }

        return res;
        
    }
};