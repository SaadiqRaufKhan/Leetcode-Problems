class Solution {
public:
    int myAtoi(string s) {
        int len = s.size();
        int i=0;
        // skip white spaces
        while(s[i] == ' '){
            i++;
        }
        // check for polarity sign
        bool positive = s[i] == '+';
        bool negative = s[i] == '-';
        // doing the stuff below because there might be some strings that does't start with a + or - sign
        positive == true ? i++ : i;
        negative == true ? i++ : i;
        
        // using double for larger range
        double num = 0;
        while(i < len && s[i] >= '0' && s[i] <= '9'){
            num = num*10;
            num += (s[i]-'0');
            i++;
        }
        // take -ve if there was a - sign
        num = negative ? -num : num;
        // check for range
        num = (num > INT_MAX) ? INT_MAX : num;
        num = (num < INT_MIN) ? INT_MIN : num;
        cout<<num<<endl;
        return int(num);
    }
};