class MedianFinder {
public:
    // data members
    double median;
    priority_queue<int> lheap;  // maxHeap
    priority_queue<int, vector<int>, greater<int>> rheap;  // minHeap

    // Constructor
    MedianFinder() {}
    
    void addNum(int num) {
        // compare sizes -> insert into the correct heap -> update median
        if(lheap.empty() && rheap.empty()) {
            median = num;
            lheap.push(num);
        }
        else {
            if(lheap.size() < rheap.size()) {
                if(num < median) {
                    lheap.push(num);
                }
                else {
                    int top = rheap.top();
                    rheap.pop();
                    lheap.push(top);
                    rheap.push(num);
                }
                median = (lheap.top() + rheap.top())/2.0;
            }
            else if(lheap.size() > rheap.size()) {
                if(num < median) {
                    int top = lheap.top();
                    lheap.pop();
                    rheap.push(top);
                    lheap.push(num);
                }
                else {
                    rheap.push(num);
                }
                median = (lheap.top() + rheap.top())/2.0;
            }
            else {
                if(num < median) {
                    lheap.push(num);
                    median = lheap.top();
                }
                else {
                    rheap.push(num);
                    median = rheap.top();
                }       
            }
        }
    }
    
    double findMedian() {
        return median;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */