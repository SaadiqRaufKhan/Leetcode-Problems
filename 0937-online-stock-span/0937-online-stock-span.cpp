class StockSpanner {
public:
    stack<pair<int,int>> *s;
    StockSpanner() {
        s = new stack<pair<int,int>>();
    }
    
    int next(int price) {
        int span = 1;
        while(!s->empty() && (s->top()).first <= price) {
            span += (s->top()).second;
            s->pop();
        }
        s->push({price, span});
        return span;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */