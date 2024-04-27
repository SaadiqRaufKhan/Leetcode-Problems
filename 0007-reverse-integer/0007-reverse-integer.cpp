class Solution {                      
public:
    int reverse(int x) {
        int r=0;      // decleare r 
        while(x){
         if (r>INT_MAX/10 || r<INT_MIN/10) return 0; // check 32 bit range if r is outside the range then return 0 
         r=r*10+x%10; // find remainder and add its to r
         x=x/10;     // Update the value of x
        } 
        return r;  // if r in the 32 bit range then return r
    }
};

// class Solution {
// public:
//     int reverse(int x) {
//         if(x == INT_MIN) return 0;
        
//         int sign = 1;
//         int temp = x;
//         if(temp < 0) {
//             sign = -1;
//             temp = temp * -1;
//         }
//         cout << temp << endl;
//         stack<int> s;
//         while(temp > 0) {
//             int d = temp % 10;
//             // cout << "d: " << d << endl;
//             s.push(d);
//             temp = temp / 10;
//             // cout << "temp: " << temp << endl;
//         }
//         long long exp = 1;
//         long long newx = 0;
//         // cout << "s.size: " << s.size() << endl;
//         while(!s.empty()) {
//             long long d = s.top();
//             // cout << "d: " << d << ", ";
//             s.pop();
//             d = d * exp;
//             // cout << "d': " << d << ", ";
//             newx += d;
//             // cout << "newx: " << newx << ", ";
//             exp *= 10;
//             // cout << "exp: " << exp << endl;
//         }
        
//         if(sign == -1) {
//             newx *= -1;
//         }
//         cout << "newx: " << newx << endl;
//         return newx;
//     }
// };